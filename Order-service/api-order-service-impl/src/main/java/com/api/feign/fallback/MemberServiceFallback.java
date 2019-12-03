
package com.api.feign.fallback;

import com.base.BaseApiService;
import com.base.ResponseBase;
import org.springframework.stereotype.Component;

import com.api.entity.UserEntity;
import com.api.feign.MemberServiceFeigin;


@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFeigin {

	public UserEntity getMem(String name) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("系统错误.没有获取到用户信息");
		return userEntity;
	}

	public UserEntity getMember(String name) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("系统错误.没有获取到用户信息");
		return userEntity;
	}

	public ResponseBase getUserInfo() {
		// 服务降级处理
		return setResultError("系统错误,请稍后重试!");
	}

}
