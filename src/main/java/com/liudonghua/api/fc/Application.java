package com.liudonghua.api.fc;

import java.util.Map;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;
import com.liudonghua.api.fc.util.JwtFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    @Autowired
    Environment environment;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/site/*");
        return registrationBean;
    }

    @Bean
    public ClientProviderBean initLoginClientProviderBean() {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("env: %s=%s%n", envName, env.get(envName));
        }
        System.out.println("initLoginClientProviderBean...");
        ClientProviderBean clientProvider = new ClientProviderBean();
        // 设定服务器配置_设定服务器IP
        clientProvider.setServerIp(System.getenv().get("fc.default.server.ip"));
        // 设定服务器配置_设定服务器端口号
        clientProvider.setServerPort(System.getenv().get("fc.default.server.port"));
        clientProvider.setUserName(System.getenv().get("fc.default.username"));
        // 初始化用户资源实例
        AuthenticateResource auth = ServiceFactory.getService(AuthenticateResource.class, clientProvider);
        // 以用户名，用户密码作为传入参数，调用AuthenticateResource提供的login方法，完成用户的登录
        auth.login(System.getenv().get("fc.default.username"), System.getenv().get("fc.default.password"));
        return clientProvider;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}