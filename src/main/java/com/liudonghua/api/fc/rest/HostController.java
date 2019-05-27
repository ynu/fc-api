package com.liudonghua.api.fc.rest;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.host.HostBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.host.HostInfo;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostListReq;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostUsageResp;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostsUsageResp;
import com.huawei.esdk.fusioncompute.local.resources.host.HostResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/site")
public class HostController {

	@Autowired
	ClientProviderBean clientProviderBean;

	/**
	 * 
	 * @param siteId
	 * @param limit
	 * @param offset
	 * @return
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "total": 10,
	 *     "list": [
	 *       {
	 *         "urn": "urn:sites:3F7B07E2:hosts:390",
	 *         "uri": "/service/sites/3F7B07E2/hosts/390",
	 *         "name": "CNA03",
	 *         "description": "CNA03",
	 *         "ip": "202.203.209.78",
	 *         "bmcIp": null,
	 *         "bmcUserName": null,
	 *         "clusterUrn": "urn:sites:3F7B07E2:clusters:280",
	 *         "clusterName": "生产集群",
	 *         "status": "normal",
	 *         "isMaintaining": false,
	 *         "multiPathMode": "CURRENCY",
	 *         "hostMultiPathMode": "CURRENCY",
	 *         "memQuantityMB": 362931,
	 *         "cpuQuantity": 36,
	 *         "cpuMHz": 2500,
	 *         "nicQuantity": 1,
	 *         "attachedISOVMs": [],
	 *         "computeResourceStatics": "/service/sites/3F7B07E2/hosts/390/computeResourceStatics",
	 *         "ntpIp1": "202.203.209.70",
	 *         "ntpIp2": null,
	 *         "ntpIp3": null,
	 *         "ntpCycle": 64,
	 *         "physicalCpuQuantity": 2,
	 *         "gpuCapacity": 0,
	 *         "gpuCapacityReboot": 0,
	 *         "imcSetting": null,
	 *         "maxImcSetting": "Ivy Bridge",
	 *         "cpuResource": {
	 *           "totalSizeMHz": 90000,
	 *           "allocatedSizeMHz": 0,
	 *           "allocatedVcpus": null
	 *         },
	 *         "memResource": {
	 *           "totalSizeMB": 362931,
	 *           "allocatedSizeMB": 238511
	 *         },
	 *         "gdvmMemory": 128,
	 *         "gdvmMemoryReboot": 128,
	 *         "gsvmMemory": 64,
	 *         "gsvmMemoryReboot": 64,
	 *         "haState": "alive",
	 *         "haRole": "slave",
	 *         "isFailOverHost": false,
	 *         "hostRealName": "CNA03",
	 *         "params": {
	 *           "nowHanaOptimizedStrategy": "false",
	 *           "nowEnableIORingAdaptation": "false",
	 *           "hanaOptimizedStrategy": "false",
	 *           "realtimeUsedSizeMB": "305901",
	 *           "enableIORingAdaptation": "false"
	 *         },
	 *         "clusterEnableIOTailor": true,
	 *         "maintaining": false
	 *       }
	 *     ]
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询主机列表", notes = "根据siteId以及可选的limit/offset查询主机列表", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/hostResource/", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<HostBasicInfo>> queryHostList(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, clientProviderBean);
		String siteUri = String.format("/service/sites/%s", siteId);
		QueryHostListReq req = new QueryHostListReq();
		req.setLimit(limit);
		req.setOffset(offset);
		FCSDKResponse<PageList<HostBasicInfo>> queryHostList = hostResource.queryHostList(siteUri, req);
		return queryHostList;
	}

	/**
	 * 
	 * @param siteId
	 * @param hostId
	 * @return
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "urn": "urn:sites:3F7B07E2:hosts:390",
	 *     "uri": "/service/sites/3F7B07E2/hosts/390",
	 *     "name": "CNA03",
	 *     "description": "CNA03",
	 *     "ip": "202.203.209.78",
	 *     "bmcIp": null,
	 *     "bmcUserName": null,
	 *     "clusterUrn": "urn:sites:3F7B07E2:clusters:280",
	 *     "clusterName": "生产集群",
	 *     "status": "normal",
	 *     "isMaintaining": false,
	 *     "multiPathMode": "CURRENCY",
	 *     "hostMultiPathMode": "CURRENCY",
	 *     "vendor": "Inspur",
	 *     "model": "NF5280M3",
	 *     "memQuantityMB": 362931,
	 *     "cpuQuantity": 36,
	 *     "cpuMHz": 2500,
	 *     "nicQuantity": 1,
	 *     "attachedISOVMs": [],
	 *     "computeResourceStatics": "/service/sites/3F7B07E2/hosts/390/computeResourceStatics",
	 *     "ntpIp1": "202.203.209.70",
	 *     "ntpIp2": null,
	 *     "ntpIp3": null,
	 *     "ntpCycle": 64,
	 *     "physicalCpuQuantity": 2,
	 *     "gpuCapacity": 0,
	 *     "gpuCapacityReboot": 0,
	 *     "imcSetting": null,
	 *     "maxImcSetting": "Ivy Bridge",
	 *     "hostDNSCfg": null,
	 *     "hostRoutetable": null,
	 *     "defaultGateway": null,
	 *     "hypervisor": "UVP",
	 *     "gdvmMemory": 128,
	 *     "gdvmMemoryReboot": 128,
	 *     "gsvmMemory": 64,
	 *     "gsvmMemoryReboot": 64,
	 *     "haState": "alive",
	 *     "haRole": "slave",
	 *     "isFailOverHost": false,
	 *     "clusterEnableIOTailor": true,
	 *     "hostRealName": "CNA03",
	 *     "params": {
	 *       "nowHanaOptimizedStrategy": "false",
	 *       "nowEnableIORingAdaptation": "false",
	 *       "hanaOptimizedStrategy": "false",
	 *       "realtimeUsedSizeMB": "305928",
	 *       "enableIORingAdaptation": "false"
	 *     },
	 *     "maintaining": false
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询指定主机", notes = "根据siteId/hostId查询指定主机", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/hostResource/{hostId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<HostInfo> queryHost(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@ApiParam(name = "hostId", value = "The id of the host", defaultValue = "390") @PathVariable String hostId) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, clientProviderBean);
		String hostUri = String.format("/service/sites/%s/hosts/%s", siteId, hostId);
		FCSDKResponse<HostInfo> queryHost = hostResource.queryHost(hostUri);
		return queryHost;
	}

	/**
	 * 
	 * @param siteId
	 * @param scope
	 * @return
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "total": 10,
	 *     "rebooting": 0,
	 *     "normal": 10,
	 *     "fault": 0,
	 *     "initial": 0,
	 *     "unknown": 0,
	 *     "poweroff": 0,
	 *     "booting": 0,
	 *     "shutdowning": 0
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询主机列表统计信息", notes = "根据siteId以及可选的scope查询主机列表统计信息", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/hostResource/hostsUsage", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<QueryHostsUsageResp> queryHostsUsage(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(name = "scope ", required = false, defaultValue = "") String scope) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, clientProviderBean);
		String siteUri = String.format("/service/sites/%s", siteId);
		FCSDKResponse<QueryHostsUsageResp> queryHostsUsage = hostResource.queryHostsUsage(siteUri, scope);
		return queryHostsUsage;
	}

	/**
	 * 
	 * @param siteId
	 * @param hostId
	 * @return
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "cpuResource": {
	 *       "totalSizeMHz": 90000,
	 *       "allocatedSizeMHz": 0
	 *     },
	 *     "memResource": {
	 *       "totalSizeMB": 362931,
	 *       "allocatedSizeMB": 238511
	 *     }
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询指定主机计算资源使用情况", notes = "根据siteId/hostId查询指定主机计算资源使用情况", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/hostResource/hostsUsage/{hostId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<QueryHostUsageResp> queryHostUsage(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@ApiParam(name = "hostId", value = "The id of the host", defaultValue = "390") @PathVariable String hostId) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, clientProviderBean);
		String hostUri = String.format("/service/sites/%s/hosts/%s", siteId, hostId);
		FCSDKResponse<QueryHostUsageResp> queryHostUsage = hostResource.queryHostUsage(hostUri);
		return queryHostUsage;
	}
}
