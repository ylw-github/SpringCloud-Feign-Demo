
package com.api.service;

import com.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;


public interface IOrderService {

	// 订单服务调用会员服务接口信息 feign
	@RequestMapping("/getOrderMember")
	public ResponseBase getOrderMember(String name);



	@RequestMapping("/getOrderInfo")
	public ResponseBase getOrderInfo();
}
