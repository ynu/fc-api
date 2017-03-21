package com.liudonghua.api.fc.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.site.SiteBasicInfo;
import com.huawei.esdk.fusioncompute.local.resources.site.SiteResource;
import com.liudonghua.api.fc.util.Utils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/site")
public class SiteController {
	
	/**
	 * @return
	 * <code>
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
	@ApiOperation(value = "查询所有站点信息", notes = "查询所有站点信息")
	@RequestMapping(path="/", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<List<SiteBasicInfo>> querySites() {
		SiteResource site = ServiceFactory.getService(SiteResource.class, Utils.initLoginClientProviderBean());
		FCSDKResponse<List<SiteBasicInfo>> sites = site.querySites();
		return sites;
	}
}
