package com.liudonghua.api.fc.rest;

import java.util.List;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ComputeResource;
import com.huawei.esdk.fusioncompute.local.resources.cluster.ClusterResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/site")
public class ClusterController {

	@Autowired
	ClientProviderBean clientProviderBean;

	/**
	 * @return <code>
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
	@ApiOperation(value = "查询集群列表", notes = "根据siteId查询集群列表", authorizations = { @Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/cluster", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<List<ClusterBasicInfo>> queryClusters(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId) {
		ClusterResource clusterResource = ServiceFactory.getService(ClusterResource.class, clientProviderBean);
		// List<String> clusterUrns = new ArrayList<String>();
		// clusterUrns.add("urn:sites:3EB607A6:clusters:10");
		String siteUri = String.format("/service/sites/%s", siteId);
		FCSDKResponse<List<ClusterBasicInfo>> queryClusters = clusterResource.queryClusters(siteUri, null, null, null,
				null);
		return queryClusters;
	}

	/**
	 * @return <code>
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
	@ApiOperation(value = "查询集群详情", notes = "根据siteId/clusterId查询集群详情", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/cluster/{clusterId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<ClusterInfo> queryCluster(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@ApiParam(name = "clusterId", value = "The id of the cluster", defaultValue = "79") @PathVariable String clusterId) {
		ClusterResource clusterResource = ServiceFactory.getService(ClusterResource.class, clientProviderBean);
		String clusterUri = String.format("/service/sites/%s/clusters/%s", siteId, clusterId);
		FCSDKResponse<ClusterInfo> queryCluster = clusterResource.queryCluster(clusterUri);
		return queryCluster;
	}

	/**
	 * @return <code>
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
	@ApiOperation(value = "查询集群内计算资源统计信息", notes = "根据siteId/clusterId查询集群内计算资源统计信息", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/computerResource/{clusterId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<ComputeResource> queryComputeResource(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@ApiParam(name = "clusterId", value = "The id of the cluster", defaultValue = "79") @PathVariable String clusterId) {
		ClusterResource clusterResource = ServiceFactory.getService(ClusterResource.class, clientProviderBean);
		String clusterUri = String.format("/service/sites/%s/clusters/%s", siteId, clusterId);
		FCSDKResponse<ComputeResource> queryComputeResource = clusterResource.queryComputeResource(clusterUri);
		return queryComputeResource;
	}
}
