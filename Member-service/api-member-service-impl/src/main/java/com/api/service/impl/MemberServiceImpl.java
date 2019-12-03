
package com.api.service.impl;

import com.base.BaseApiService;
import com.base.ResponseBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.UserEntity;
import com.api.service.IMemberService;


@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {
	@Value("${server.port}")
	private String serverPort;

	@Override
	public UserEntity getMem(String name) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(name + "serverPort:" + serverPort);
		userEntity.setAge(20);
		return userEntity;
	}

	@RequestMapping("/getMember")
	public UserEntity getMember(@RequestParam("name") String name) {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		UserEntity userEntity = new UserEntity();
		userEntity.setName(name + "serverPort:" + serverPort);
		userEntity.setAge(20);
		return userEntity;
	}

	@RequestMapping("/getUserInfo")
	public ResponseBase getUserInfo() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		return setResultSuccess("订单服务调用会员服务..");
	}

}
