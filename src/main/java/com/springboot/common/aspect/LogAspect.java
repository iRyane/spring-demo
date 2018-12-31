package com.springboot.common.aspect;

import com.springboot.common.annotation.Log;
import com.springboot.common.utils.HttpContextUtils;
import com.springboot.common.utils.IPUtils;
import com.springboot.modules.sys.entity.LogEntity;
import com.springboot.modules.sys.entity.UserEntity;
import com.springboot.modules.sys.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author :yan
 * @Date :Create in 12/31/18
 * @Description :系统日志:切面处理类
 */
@Aspect
@Component
public class LogAspect {

    @Autowired private LogService logService;

    @Pointcut("@annotation(com.springboot.common.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint point) {
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LogEntity logEntity = new LogEntity();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            logEntity.setOperation(logAnnotation.value());
        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logEntity.setMethod(className + "." + methodName + "()");

        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            logEntity.setParams(params);
        }

        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        logEntity.setIp(IPUtils.getIpAddr(request));

        // 用户名
        String username = ((UserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
        logEntity.setUsername(username);

        logEntity.setTime((int) time);
        logEntity.setCreateDate(new Date());
        // 保存系统日志
        logService.save(logEntity);
    }
}
