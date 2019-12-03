
package com.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.api.service.IMemberService;


@FeignClient(name = "app-service-member")
public interface MemberServiceFeigin extends IMemberService {
	// 服务降级 熔断
	// 实体类是存放接口项目还是 存放在实现项目 实体类存放在接口项目里面
	// 实体类和定义接口信息存放在接口项目
	// 代码实现存放在接口实现类里面

}
