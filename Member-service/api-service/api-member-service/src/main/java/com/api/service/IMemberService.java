
package com.api.service;

import com.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.entity.UserEntity;


public interface IMemberService {

	// 实体类是存放接口项目还是 存放在实现项目 实体类存放在接口项目里面
	// 实体类和定义接口信息存放在接口项目
	// 代码实现存放在接口实现类里面

	@RequestMapping("/getMem")
	public UserEntity getMem(@RequestParam("name") String name);

	@RequestMapping("/getMember")
	public UserEntity getMember(@RequestParam("name") String name);

	@RequestMapping("/getUserInfo")
	public ResponseBase getUserInfo();

}
