
package com.api.service.impl;

import com.base.BaseApiService;
import com.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.UserEntity;
import com.api.feign.MemberServiceFeigin;
import com.api.service.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {
	// 订单服务继承会员服务接口，用来实现feign客户端 减少重复接口代码
	@Autowired
	private MemberServiceFeigin memberServiceFeigin;

	@RequestMapping("/getOrderMember")
	public ResponseBase getOrderMember(String name) {
		System.out.println("name:" + name);
		UserEntity user = memberServiceFeigin.getMem(name);
		if (user == null) {
			return setResultError("没有查询到用户信息");
		}
		return setResultSuccess(user);
	}


	// 没有解决服务雪崩效应
	@RequestMapping("/orderToMember")
	public ResponseBase orderToUserInfo() {
		// 线程名称组合： 使用通过线程池名称+线程id组合
		System.out.println("orderToUserInfo:" + "当前线程池名称:" + Thread.currentThread().getName());
		return memberServiceFeigin.getUserInfo();
	}

	//
	@RequestMapping("/getOrderInfo")
	public ResponseBase getOrderInfo() {
		System.out.println("getOrderInfo:" + "当前线程池名称:" + Thread.currentThread().getName());
		return setResultSuccess("getOrderInfo");
	}

	// 使用Hystrix解决服务雪崩效应
	@HystrixCommand(fallbackMethod = "orderToUserInfoFallback")
	@RequestMapping("/orderToUserInfoHystrix")
	public ResponseBase orderToUserInfoHystrix() {
		System.out.println("orderToUserInfo:" + "当前线程池名称:" + Thread.currentThread().getName());
		return memberServiceFeigin.getUserInfo();
	}

	@RequestMapping("/orderToUserInfoFallback")
	public ResponseBase orderToUserInfoFallback() {
		return setResultError("系统错误");
	}

}
