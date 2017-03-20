package com.liudonghua.api.fc.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.host.HostBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.host.HostInfo;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostListReq;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostUsageResp;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostsUsageResp;
import com.huawei.esdk.fusioncompute.local.resources.host.HostResource;
import com.liudonghua.api.fc.util.Utils;

@RestController
@RequestMapping("/site")
public class HostController {

	/**
	 * 
	 * @param siteId
	 * @param limit
	 * @param offset
	 * @return
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
	 */
	@RequestMapping("/{siteId}/hostResource/")
	public FCSDKResponse<PageList<HostBasicInfo>> queryHostList(@PathVariable String siteId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, Utils.initLoginClientProviderBean());
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
	 */
	@RequestMapping("/{siteId}/hostResource/{hostId}")
	public FCSDKResponse<HostInfo> queryHost(@PathVariable String siteId, @PathVariable String hostId) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, Utils.initLoginClientProviderBean());
		String hostUri = String.format("/service/sites/%s/hosts/%s", siteId, hostId);
		FCSDKResponse<HostInfo> queryHost = hostResource.queryHost(hostUri);
		return queryHost;
	}

	/**
	 * 
	 * @param siteId
	 * @param scope
	 * @return
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
	 */
	@RequestMapping("/{siteId}/hostResource/hostsUsage")
	public FCSDKResponse<QueryHostsUsageResp> queryHostsUsage(@PathVariable String siteId,
			@RequestParam(name = "scope ", required = false, defaultValue = "") String scope) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, Utils.initLoginClientProviderBean());
		String siteUri = String.format("/service/sites/%s", siteId);
		FCSDKResponse<QueryHostsUsageResp> queryHostsUsage = hostResource.queryHostsUsage(siteUri, scope);
		return queryHostsUsage;
	}

	/**
	 * 
	 * @param siteId
	 * @param hostId
	 * @return
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
	 */
	@RequestMapping("/{siteId}/hostResource/hostsUsage/{hostId}")
	public FCSDKResponse<QueryHostUsageResp> queryHostUsage(@PathVariable String siteId, @PathVariable String hostId) {
		HostResource hostResource = ServiceFactory.getService(HostResource.class, Utils.initLoginClientProviderBean());
		String hostUri = String.format("/service/sites/%s/hosts/%s", siteId, hostId);
		FCSDKResponse<QueryHostUsageResp> queryHostUsage = hostResource.queryHostUsage(hostUri);
		return queryHostUsage;
	}
}
