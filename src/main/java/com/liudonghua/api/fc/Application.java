package com.liudonghua.api.fc;

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
        System.out.println("initLoginClientProviderBean...");
        ClientProviderBean clientProvider = new ClientProviderBean();
        // 设定服务器配置_设定服务器IP
        clientProvider.setServerIp(environment.getProperty("fc.default.server.ip"));
        // 设定服务器配置_设定服务器端口号
        clientProvider.setServerPort(environment.getProperty("fc.default.server.port"));
        clientProvider.setUserName(environment.getProperty("fc.default.username"));
        // 初始化用户资源实例
        AuthenticateResource auth = ServiceFactory.getService(AuthenticateResource.class, clientProvider);
        // 以用户名，用户密码作为传入参数，调用AuthenticateResource提供的login方法，完成用户的登录
        auth.login(environment.getProperty("fc.default.username"), environment.getProperty("fc.default.password"));
        return clientProvider;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}