package com.liudonghua.api.fc.rest;

import java.util.List;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.site.SiteBasicInfo;
import com.huawei.esdk.fusioncompute.local.resources.site.SiteResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/site")
public class SiteController {

	@Autowired
	ClientProviderBean clientProviderBean;

	/**
	 * @return <code>
	 * <pre>
	 * {
	 *    "result": [{
	 *        "urn": "urn:sites:3F7B07E2",
	 *        "uri": "/service/sites/3F7B07E2",
	 *        "name": "site",
	 *        "ip": "202.203.209.74",
	 *        "isDC": false,
	 *        "isSelf": true,
	 *        "status": "normal"
	 *    }],
	 *    "errorCode": "00000000",
	 *    "errorDes": null
	 * }
	 * </pre>
	 * </code>
	 */
	@ApiOperation(value = "查询所有站点信息", notes = "查询所有站点信息", authorizations = { @Authorization(value = "token") })
	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<List<SiteBasicInfo>> querySites() {
		SiteResource site = ServiceFactory.getService(SiteResource.class, clientProviderBean);
		FCSDKResponse<List<SiteBasicInfo>> sites = site.querySites();
		return sites;
	}
}
