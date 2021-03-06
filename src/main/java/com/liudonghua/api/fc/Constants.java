package com.liudonghua.api.fc;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Constants implements EnvironmentAware {

	public static String JWT_DEFAULT_TOKEN_NAME;

	public static String JWT_DEFAULT_SECRET;

	public static String FC_DEFAULT_SERVER_IP;

	public static String FC_DEFAULT_SERVER_PORT;

	public static String FC_DEFAULT_USERNAME;

	public static String FC_DEFAULT_PASSWORD;

	@Override
	public void setEnvironment(Environment environment) {
		JWT_DEFAULT_TOKEN_NAME = environment.getProperty("jwt.default.token.name");
		JWT_DEFAULT_SECRET = environment.getProperty("jwt.default.secret");
		FC_DEFAULT_SERVER_IP = environment.getProperty("fc.default.server.ip");
		FC_DEFAULT_SERVER_PORT = environment.getProperty("fc.default.server.port");
		FC_DEFAULT_USERNAME = environment.getProperty("fc.default.username");
		FC_DEFAULT_PASSWORD = environment.getProperty("fc.default.password");
		System.out.println(String.format(
				"setEnvironment with JWT_DEFAULT_TOKEN_NAME: %s\n, JWT_DEFAULT_SECRET: %s\n, FC_DEFAULT_SERVER_IP: %s\n, FC_DEFAULT_SERVER_PORT: %s\n, FC_DEFAULT_USERNAME: %s\n, FC_DEFAULT_PASSWORD: %s\n",
				JWT_DEFAULT_TOKEN_NAME, JWT_DEFAULT_SECRET, FC_DEFAULT_SERVER_IP, FC_DEFAULT_SERVER_PORT,
				FC_DEFAULT_USERNAME, FC_DEFAULT_PASSWORD));
	}
}
