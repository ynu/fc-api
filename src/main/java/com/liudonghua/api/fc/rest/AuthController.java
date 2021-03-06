package com.liudonghua.api.fc.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	Environment environment;

	/**
	 * @return <code>
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

	@ApiOperation(value = "登录获取Token", notes = "根据username/password获取Token")
	@RequestMapping(path = "/login", method = RequestMethod.GET, produces = "application/json")
	public LoginResponse login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) throws ServletException {
		String token = null;
		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)
				&& username.equals(environment.getProperty("fc.default.username"))
				&& password.equals(environment.getProperty("fc.default.password"))) {
			token = Jwts.builder().setSubject(username)
					.signWith(SignatureAlgorithm.HS256, environment.getProperty("jwt.default.secret")).compact();
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
