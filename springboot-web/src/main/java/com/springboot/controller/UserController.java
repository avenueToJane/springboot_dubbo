package com.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.exception.GeneralException;
import com.springboot.service.RedisService;
import com.springboot.utils.ExecutorUtil;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springboot.beans.constant.ErrorConstant;
import org.springboot.beans.vo.User;
import org.springboot.iservice.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
	// 在使用到的类中声明log以及输出log信息。
	private static Logger logger = Logger.getLogger(UserController.class);

	@Reference(version = "1.0.0")
	private IUserService iUserService;

	private ExecutorUtil executorUtil = new ExecutorUtil();

	@Autowired
	private RedisService redisService;

	@GetMapping("hello")
	public String hello() {
		return iUserService.sayHello("Hello springboot and dubbo!");
	}
	@ApiOperation(value = "查询用户信息", notes = "查询用户信息", produces = "application/json", consumes = "application/json", httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = User.class) })
	@ApiImplicitParams({})
	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public User findUser() {
		logger.info("saddddddddddddddddddddddddd");
		User user = iUserService.findUser();
		logger.info("用户的信息" + user);
		redisService.add("12", "111111");// redis存入数据
		return user;
	}

	@ApiOperation(value = "添加新用户", notes = "添加新用户", produces = "application/json", consumes = "application/json", httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = User.class) })
	@ApiImplicitParams({})
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public User addUser(@RequestBody(required = true) @Valid User user, BindingResult result) throws GeneralException {
		if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			throw new GeneralException(ErrorConstant.IN_PARAM_VALIDATE_ERROR, fieldErrors.get(0).getDefaultMessage());
		}
		iUserService.addUser(user);
		logger.info("用户的信息" + user);
		return user;
	}

	@ApiOperation(value = "多线程异步接口测试", notes = "多线程异步接口测试", produces = "application/json", consumes = "application/json", httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = User.class) })
	@ApiImplicitParams({})
	@RequestMapping(value = "/testExecutor", method = RequestMethod.POST)
	public User testExecutor(@RequestBody(required = true) @Valid User user, BindingResult result)
			throws GeneralException {
		if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			throw new GeneralException(ErrorConstant.IN_PARAM_VALIDATE_ERROR, fieldErrors.get(0).getDefaultMessage());
		}
		executorUtil.getExecutorService().execute(new Runnable() {
			public void run() {
				try {
					// 休眠实现 单位秒===========================
					logger.info("多线程的实现=============开始");
					TimeUnit.SECONDS.sleep(10);
					logger.info("多线程的实现=============结束");
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}

			}
		});
		logger.info("用户的信息" + user);
		return user;
	}
}
