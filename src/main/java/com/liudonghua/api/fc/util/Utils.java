package com.liudonghua.api.fc.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;
import com.liudonghua.api.fc.Constants;

public class Utils {

	// @Autowired
	// Environment environment;

	// private static ClientProviderBean clientProvider;

	public static void tokenInvalidateResponse(HttpServletResponse response) {
		// https://brendangraetz.wordpress.com/2010/06/17/use-servlet-filters-for-user-authentication/
		// response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		PrintWriter out;
		try {
			out = response.getWriter();
			JSONObject json = new JSONObject();
			json.put("result", 401);
			json.put("data", "Token invalidate");
			out.print(json.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// public static ClientProviderBean initLoginClientProviderBean() {
	// if (clientProvider == null) {
	// clientProvider = new ClientProviderBean();
	// // 设定服务器配置_设定服务器IP
	// clientProvider.setServerIp(Constants.FC_DEFAULT_SERVER_IP);
	// // 设定服务器配置_设定服务器端口号
	// clientProvider.setServerPort(Constants.FC_DEFAULT_SERVER_PORT);
	// clientProvider.setUserName(Constants.FC_DEFAULT_USERNAME);
	// // 初始化用户资源实例
	// AuthenticateResource auth =
	// ServiceFactory.getService(AuthenticateResource.class, clientProvider);
	// // 以用户名，用户密码作为传入参数，调用AuthenticateResource提供的login方法，完成用户的登录
	// FCSDKResponse<LoginResp> loginResponse =
	// auth.login(Constants.FC_DEFAULT_USERNAME,
	// Constants.FC_DEFAULT_PASSWORD);
	// }
	// return clientProvider;
	// }
}
