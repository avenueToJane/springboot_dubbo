package com.springboot.exception;

import org.springboot.beans.dto.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 * <p>
 * Title: ExceptionHandle
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: xxx
 * </p>
 * 
 * @author Mr.yang
 * @date 2018年9月25日 下午9:22:04
 */
@ControllerAdvice
public class ExceptionHandle {
	// 统一拦截处理Controller的异常
	@ExceptionHandler(value = Exception.class) // 指定捕获Exception异常
	@ResponseBody
	public Result exceptionHandler(Exception e) {
		Result result = new Result();
		// 判断捕获的异常是否是自定义异常
		if (e instanceof GeneralException) {
			result.setReturnCode(((GeneralException) e).getErrorCode());
			result.setReturnMessage(e.getMessage());
		} else {
			result.setReturnCode("-9999");
			result.setReturnMessage("未知错误");
		}
		return result;
	}
}
