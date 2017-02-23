package com.liudonghua.api.fc.rest;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;
import com.liudonghua.api.fc.util.Utils;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	/**
	 * @return 
	 * <code>
	 * <pre>
	 * {
	 *     "result": {
	 *         "validity": 3600000,
	 *         "privilegeIds": [],
	 *         "userId": "c71491d4-b23b-49ef-a797-4ae13d30da41",
	 *         "userName": "test",
	 *         "roleList": ["administrator"],
	 *         "rightType": "1"
	 *     },
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }
	 * </pre>
	 * </code>
	 */
	@RequestMapping("/")
	public FCSDKResponse login(HttpSession session) {
		ClientProviderBean clientProvider = Utils.initClientProviderBean();
		// 初始化用户资源实例
		AuthenticateResource auth = ServiceFactory.getService(AuthenticateResource.class, clientProvider);
		// 以用户名，用户密码作为传入参数，调用AuthenticateResource提供的login方法，完成用户的登录
		FCSDKResponse<LoginResp> loginResponse = auth.login("test", "zaq1XSW@");
		session.setAttribute("clientProvider" , clientProvider);
		return loginResponse;
	}
}
