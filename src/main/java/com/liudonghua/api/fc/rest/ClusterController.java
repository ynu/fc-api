package com.liudonghua.api.fc.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ComputeResource;
import com.huawei.esdk.fusioncompute.local.model.site.SiteBasicInfo;
import com.huawei.esdk.fusioncompute.local.resources.cluster.ClusterResource;
import com.huawei.esdk.fusioncompute.local.resources.site.SiteResource;
import com.liudonghua.api.fc.util.Utils;

@RestController
@RequestMapping("/site")
public class ClusterController {
	
	/**
	 * @return
	 * <code>
	 * <pre>
	 * {
	 *     "result": [{
	 *         "urn": "urn:sites:3F7B07E2:clusters:79",
	 *         "uri": "/service/sites/3F7B07E2/clusters/79",
	 *         "name": "ManagementCluster",
	 *         "parentObjUrn": null,
	 *         "parentObjName": null,
	 *         "description": "管理和测试集群",
	 *         "cpuResource": {
	 *             "totalSizeMHz": 180000,
	 *             "allocatedSizeMHz": 20000,
	 *             "allocatedVcpus": null
	 *         },
	 *         "memResource": {
	 *             "totalSizeMB": 725862,
	 *             "allocatedSizeMB": 149471
	 *         },
	 *         "tag": "domain/default",
	 *         "params": null
	 *     }],
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }	 
	 * </pre>	 
	 * </code>
	 */
	@RequestMapping("/{siteUri}/cluster")
	public FCSDKResponse queryClusters(@PathVariable String siteUri, HttpSession session) {
		ClientProviderBean clientProvider = (ClientProviderBean) session.getAttribute("clientProvider");
		if(clientProvider == null) {
			clientProvider = Utils.initClientProviderBean();
		}
		ClusterResource clusterResource = ServiceFactory.getService(ClusterResource.class, clientProvider);
//		List<String> clusterUrns = new ArrayList<String>();
//		clusterUrns.add("urn:sites:3EB607A6:clusters:10");
		FCSDKResponse<List<ClusterBasicInfo>> queryClusters = clusterResource.queryClusters(siteUri, null, null, null, null);
		return queryClusters;
	}

	/**
	 * @return 
	 * <code>
	 * <pre>
	 * {
	 *     "result": {
	 *         "urn": "urn:sites:3F7B07E2:clusters:79",
	 *         "uri": "/service/sites/3F7B07E2/clusters/79",
	 *         "name": "ManagementCluster",
	 *         "parentObjUrn": null,
	 *         "description": "管理和测试集群",
	 *         "tag": "domain/default",
	 *         "isMemOvercommit": true,
	 *         "isEnableHa": true,
	 *         "haResSetting": {
	 *             "isControlPolicy": false,
	 *             "controlPolicy": null,
	 *             "cpuReservation": 0,
	 *             "memoryReservation": 0,
	 *             "hostsFaultQuantity": 1,
	 *             "isCustomisedSlot": false,
	 *             "slotcpuinmhz": 153600,
	 *             "slotmeminmb": 1048576,
	 *             "failoverHosts": [],
	 *             "isAutoMigrateAllVms": false,
	 *             "isHaHostAutonomy": false,
	 *             "hbDataStorePolicy": 0,
	 *             "hbDataStorePreferred": [],
	 *             "hbDataStoreNumber": 0,
	 *             "isolateArbitrateAddress": ""
	 *         },
	 *         "isEnableDrs": false,
	 *         "drsSetting": {
	 *             "drsLevel": 3,
	 *             "drsFragmentLimen": [{
	 *                 "fragmentTime": 0,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 1,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 2,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 3,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 4,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 5,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 6,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 7,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 8,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 9,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 10,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 11,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 12,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 13,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 14,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 15,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 16,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 17,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 18,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 19,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 20,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 21,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 22,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 23,
	 *                 "limen": 5
	 *             }],
	 *             "drsCycle": {
	 *                 "cycleType": 1,
	 *                 "cycleSpec": null
	 *             },
	 *             "drsRules": [],
	 *             "powerLevel": 0,
	 *             "powerLimen": 3,
	 *             "powerFragmentLimen": [{
	 *                 "fragmentTime": 0,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 1,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 2,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 3,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 4,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 5,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 6,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 7,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 8,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 9,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 10,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 11,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 12,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 13,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 14,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 15,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 16,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 17,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 18,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 19,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 20,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 21,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 22,
	 *                 "limen": 5
	 *             }, {
	 *                 "fragmentTime": 23,
	 *                 "limen": 5
	 *             }],
	 *             "dpmCycle": {
	 *                 "cycleType": 1,
	 *                 "cycleSpec": null
	 *             },
	 *             "factor": 3,
	 *             "drsThreshold": {
	 *                 "cpu": 0,
	 *                 "memory": 0
	 *             },
	 *             "dpmThresholds": [{
	 *                 "limen": 1,
	 *                 "underloadThreshold": 0,
	 *                 "overloadThreshold": 63
	 *             }, {
	 *                 "limen": 3,
	 *                 "underloadThreshold": 23,
	 *                 "overloadThreshold": 72
	 *             }, {
	 *                 "limen": 5,
	 *                 "underloadThreshold": 45,
	 *                 "overloadThreshold": 81
	 *             }, {
	 *                 "limen": 7,
	 *                 "underloadThreshold": 54,
	 *                 "overloadThreshold": 90
	 *             }, {
	 *                 "limen": 9,
	 *                 "underloadThreshold": 63,
	 *                 "overloadThreshold": 100
	 *             }],
	 *             "electricStrategy": 1
	 *         },
	 *         "drsExtensionConfig": [],
	 *         "statistics": "/service/sites/3F7B07E2/clusters/79/statistics",
	 *         "resStrategy": "loadBalance",
	 *         "isEnableImc": false,
	 *         "imcSetting": null,
	 *         "maxCpuQuantity": 36,
	 *         "enableVmDrs": false,
	 *         "drsVmConfig": [],
	 *         "enableGuestNuma": false,
	 *         "enableHostNumaDRS": false,
	 *         "enableIOTailor": true,
	 *         "params": {
	 *             "enableVmIORingAdaptation": "false",
	 *             "hanaOptimizedStrategy": "false",
	 *             "enableIORingAdaptation": "false"
	 *         },
	 *         "dsFaultStrategy": 0,
	 *         "parentObjName": null
	 *     },
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }	 
	 * </pre>	 
	 * </code>
	 */
	@RequestMapping("/{siteUri}/cluster/{clusterUri}")
	public FCSDKResponse queryCluster(@PathVariable String siteUri, @PathVariable String clusterUri, HttpSession session) {
		ClientProviderBean clientProvider = (ClientProviderBean) session.getAttribute("clientProvider");
		if(clientProvider == null) {
			clientProvider = Utils.initClientProviderBean();
		}
		ClusterResource clusterResource = ServiceFactory.getService(ClusterResource.class, clientProvider);
		FCSDKResponse<ClusterInfo> queryCluster = clusterResource.queryCluster(clusterUri);
		return queryCluster;
	}

	/**
	 * @return 
	 * <code>
	 * <pre>
	 * {
	 *     "result": {
	 *         "totalSizeMHz": 180000,
	 *         "allocatedSizeMHz": 20000,
	 *         "totalSizeMB": 725862,
	 *         "allocatedSizeMB": 149471,
	 *         "allocatedVcpus": 184
	 *     },
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }	 
	 * </pre>	 
	 * </code>
	 */
	@RequestMapping("/{siteUri}/computerResource/{clusterUri}")
	public FCSDKResponse queryComputeResource(@PathVariable String siteUri, @PathVariable String clusterUri, HttpSession session) {
		ClientProviderBean clientProvider = (ClientProviderBean) session.getAttribute("clientProvider");
		if(clientProvider == null) {
			clientProvider = Utils.initClientProviderBean();
		}
		ClusterResource clusterResource = ServiceFactory.getService(ClusterResource.class, clientProvider);
		FCSDKResponse<ComputeResource> queryComputeResource = clusterResource.queryComputeResource(clusterUri);
		return queryComputeResource;
	}
}
