package com.springboot.common.exception;

import com.springboot.common.utils.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RRException.class)
	public ResponseBo handleRRException(RRException e){
	    ResponseBo map = new ResponseBo();
		map.put("code", e.getCode());
		map.put("msg", e.getMessage());

		return map;
	}
	
	@ExceptionHandler(value = AuthorizationException.class)
	public ResponseBo handleAuthorizationException(AuthorizationException e) {
	    log.error(e.getMessage(), e);
		return ResponseBo.error(HttpStatus.SC_FORBIDDEN, "没有权限访问");
	}

	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseBo handleNumberFormatException(NumberFormatException e){
		log.error(e.getMessage(), e);
		return ResponseBo.error(HttpStatus.SC_BAD_REQUEST, "参数类型有误");
	}
}
