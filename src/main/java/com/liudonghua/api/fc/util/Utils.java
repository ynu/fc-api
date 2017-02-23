package com.liudonghua.api.fc.util;

import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;

public class Utils {

	public static ClientProviderBean initClientProviderBean() {
		ClientProviderBean clientProvider = new ClientProviderBean();
		// clientProvider.setProtocol("http");
		// 设定服务器配置_设定服务器IP
		clientProvider.setServerIp("202.203.209.74");
		// 设定服务器配置_设定服务器端口号
		clientProvider.setServerPort("7443");
		return clientProvider;
	}
}
