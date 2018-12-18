package com.springboot.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


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
	public Map handleRRExeption(RRException e){
		Map map = new HashMap();
		map.put("code", e.getCode());
		map.put("msg", e.getMessage());

		return map;
	}
	
	@ExceptionHandler(value = AuthorizationException.class)
	public String handleAuthorizationException(AuthorizationException e) {
	    log.error(e.getMessage(), e);
		return "403";
	}
}
