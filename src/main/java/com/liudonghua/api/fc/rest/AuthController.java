package com.liudonghua.api.fc.rest;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;
import com.liudonghua.api.fc.Constants;
import com.liudonghua.api.fc.util.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
	
	private final Map<String, List<String>> userDb = new HashMap<>();

    public AuthController() {
        userDb.put("api", Arrays.asList("user", "admin"));
    }

	@RequestMapping("/login")
    public LoginResponse login(@RequestParam(name="username") String username, 
    		@RequestParam(name="password") String password)
        throws ServletException {
		String token = null;
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) 
        		&& username.equals(Constants.FC_DEFAULT_USERNAME)
        		&& password.equals(Constants.FC_DEFAULT_PASSWORD)) {
        	token = Jwts.builder().setSubject(username)
                    .claim("roles", userDb.get(username)).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, Constants.JWT_DEFAULT_SECRET).compact();
        }
        return new LoginResponse(token);
    }

    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
	
}
