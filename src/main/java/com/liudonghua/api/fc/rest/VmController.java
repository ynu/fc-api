package com.liudonghua.api.fc.rest;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmsReq;
import com.huawei.esdk.fusioncompute.local.model.vm.VmInfo;
import com.huawei.esdk.fusioncompute.local.resources.vm.VmResource;

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
public class VmController {

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
	 *     "total": 243,
	 *     "list": [
	 *       {
	 *         "uri": "/service/sites/3F7B07E2/vms/i-0000027D",
	 *         "urn": "urn:sites:3F7B07E2:vms:i-0000027D",
	 *         "uuid": "5d48e6af-968d-45d0-a912-93aa2419c243",
	 *         "name": "商旅学院",
	 *         "description": null,
	 *         "group": null,
	 *         "location": "urn:sites:3F7B07E2:clusters:335",
	 *         "locationName": "托管集群",
	 *         "hostUrn": "urn:sites:3F7B07E2:hosts:420",
	 *         "clusterUrn": "urn:sites:3F7B07E2:clusters:335",
	 *         "dataStoreUrns": null,
	 *         "status": "running",
	 *         "pvDriverStatus": "running",
	 *         "toolInstallStatus": "empty",
	 *         "cdRomStatus": "empty",
	 *         "isTemplate": false,
	 *         "isLinkClone": false,
	 *         "createTime": "2017-03-20 07:43:19",
	 *         "vncAcessInfo": null,
	 *         "vmConfig": {
	 *           "cpu": null,
	 *           "memory": null,
	 *           "disks": null,
	 *           "nics": [
	 *             {
	 *               "name": null,
	 *               "urn": null,
	 *               "uri": null,
	 *               "portGroupUrn": null,
	 *               "portGroupName": null,
	 *               "mac": "28:6e:d4:88:c8:ec",
	 *               "ip": "113.55.12.216",
	 *               "ips6": [
	 *                 "fe80::c1e7:d0d7:17fb:17c6"
	 *               ],
	 *               "sequenceNum": 0,
	 *               "virtIo": null,
	 *               "ipList": "113.55.12.216",
	 *               "nicType": null,
	 *               "portId": null
	 *             }
	 *           ],
	 *           "usb": null,
	 *           "gpu": null,
	 *           "properties": {
	 *             "bootOption": null,
	 *             "isEnableHa": null,
	 *             "vmFaultProcess": null,
	 *             "reoverByHost": null,
	 *             "clockMode": null,
	 *             "isEnableMemVol": null,
	 *             "isEnableFt": null,
	 *             "isAutoUpgrade": null,
	 *             "attachType": null,
	 *             "gpuShareType": null,
	 *             "isReserveResource": null,
	 *             "secureVmType": null,
	 *             "isHpet": null,
	 *             "bootFirmware": null,
	 *             "vmVncKeymapSetting": null
	 *           }
	 *         },
	 *         "vmRebootConfig": null,
	 *         "osOptions": null,
	 *         "idle": 134,
	 *         "deleteTime": null,
	 *         "toolsVersion": "1.3.10.32",
	 *         "imcSetting": null,
	 *         "minCompatibleimcSetting": "Ivy Bridge",
	 *         "isBindingHost": false,
	 *         "additionalStatus": null,
	 *         "hostName": "CNA06",
	 *         "clusterName": "托管集群",
	 *         "vmType": 0,
	 *         "drStatus": 9,
	 *         "rpoStatus": 0,
	 *         "initSyncStatus": 0,
	 *         "drDrillVmUri": null,
	 *         "drDrillVmUrn": null,
	 *         "objectPrivs": [],
	 *         "isMultiDiskSpeedup": null,
	 *         "params": null
	 *       }
	 *     ]
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "分页查询虚拟机信息", notes = "根据siteId以及可选的limit/offset分页查询虚拟机信息", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/vmResource/", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<VmInfo>> queryVMs(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		VmResource vmResource = ServiceFactory.getService(VmResource.class, clientProviderBean);
		String siteUri = String.format("/service/sites/%s", siteId);
		QueryVmsReq req = new QueryVmsReq();
		req.setLimit(limit);
		req.setOffset(offset);
		FCSDKResponse<PageList<VmInfo>> queryVMs = vmResource.queryVMs(req, siteUri);
		return queryVMs;
	}

	/**
	 * 
	 * @param siteId
	 * @param vmId
	 * @return
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "uri": "/service/sites/3F7B07E2/vms/i-0000027D",
	 *     "urn": "urn:sites:3F7B07E2:vms:i-0000027D",
	 *     "uuid": "5d48e6af-968d-45d0-a912-93aa2419c243",
	 *     "name": "商旅学院",
	 *     "description": "",
	 *     "group": "",
	 *     "location": "urn:sites:3F7B07E2:clusters:335",
	 *     "locationName": "托管集群",
	 *     "hostUrn": "urn:sites:3F7B07E2:hosts:420",
	 *     "clusterUrn": "urn:sites:3F7B07E2:clusters:335",
	 *     "dataStoreUrns": [
	 *       "urn:sites:3F7B07E2:datastores:131"
	 *     ],
	 *     "status": "running",
	 *     "pvDriverStatus": "running",
	 *     "toolInstallStatus": "empty",
	 *     "cdRomStatus": "empty",
	 *     "isTemplate": false,
	 *     "isLinkClone": false,
	 *     "createTime": "2017-03-20 07:43:19",
	 *     "vncAcessInfo": {
	 *       "hostIp": "202.203.209.81",
	 *       "vncPort": 5911,
	 *       "vncPassword": "1Zb@/7@T",
	 *       "vncOldPassword": null
	 *     },
	 *     "vmConfig": {
	 *       "cpu": {
	 *         "quantity": 4,
	 *         "coresPerSocket": 4,
	 *         "reservation": 0,
	 *         "weight": 4000,
	 *         "limit": 0,
	 *         "cpuHotPlug": 0,
	 *         "affinitySet": null
	 *       },
	 *       "memory": {
	 *         "quantityMB": 8192,
	 *         "reservation": 5734,
	 *         "weight": 81920,
	 *         "limit": 8192,
	 *         "memHotPlug": 0
	 *       },
	 *       "disks": [
	 *         {
	 *           "pciType": "IDE",
	 *           "sequenceNum": 1,
	 *           "volumeUrn": "urn:sites:3F7B07E2:volumes:1273",
	 *           "volumeUrl": "/POME/datastore_131/vol/vol_87f11ae2-72f7-4b94-aadd-d3666e2c4204/	 * vol_87f11ae2-72f7-4b94-aadd-d3666e2c4204.vhd",
	 *           "volumeUuid": "87f11ae2-72f7-4b94-aadd-d3666e2c4204",
	 *           "quantityGB": 80,
	 *           "isDataCopy": true,
	 *           "datastoreUrn": "urn:sites:3F7B07E2:datastores:131",
	 *           "isThin": false,
	 *           "indepDisk": false,
	 *           "persistentDisk": true,
	 *           "storageType": "LUNPOME",
	 *           "volType": 1,
	 *           "maxReadBytes": 0,
	 *           "maxWriteBytes": 0,
	 *           "maxReadRequest": 0,
	 *           "maxWriteRequest": 0,
	 *           "type": "normal",
	 *           "diskName": "i-0000027D-xvda",
	 *           "ioWeight": 0,
	 *           "datastoreName": "宏杉存储_托管集群",
	 *           "isCoverData": null
	 *         },
	 *         {
	 *           "pciType": "IDE",
	 *           "sequenceNum": 2,
	 *           "volumeUrn": "urn:sites:3F7B07E2:volumes:1274",
	 *           "volumeUrl": "/POME/datastore_131/vol/vol_1aabc25a-4acb-4e12-a655-1e2d87979c85/	 * vol_1aabc25a-4acb-4e12-a655-1e2d87979c85.vhd",
	 *           "volumeUuid": "1aabc25a-4acb-4e12-a655-1e2d87979c85",
	 *           "quantityGB": 300,
	 *           "isDataCopy": null,
	 *           "datastoreUrn": "urn:sites:3F7B07E2:datastores:131",
	 *           "isThin": false,
	 *           "indepDisk": false,
	 *           "persistentDisk": true,
	 *           "storageType": "LUNPOME",
	 *           "volType": 1,
	 *           "maxReadBytes": 0,
	 *           "maxWriteBytes": 0,
	 *           "maxReadRequest": 0,
	 *           "maxWriteRequest": 0,
	 *           "type": "normal",
	 *           "diskName": "商旅学院",
	 *           "ioWeight": 0,
	 *           "datastoreName": "宏杉存储_托管集群",
	 *           "isCoverData": null
	 *         }
	 *       ],
	 *       "nics": [
	 *         {
	 *           "name": "Network Adapter 0",
	 *           "urn": "urn:sites:3F7B07E2:vms:i-0000027D:nics:0",
	 *           "uri": "/service/sites/3F7B07E2/vms/i-0000027D/nics/0",
	 *           "portGroupUrn": "urn:sites:3F7B07E2:dvswitchs:3:portgroups:7",
	 *           "portGroupName": "113 vlan0",
	 *           "mac": "28:6e:d4:88:c8:ec",
	 *           "ip": "113.55.12.216",
	 *           "ips6": [
	 *             "fe80::c1e7:d0d7:17fb:17c6"
	 *           ],
	 *           "sequenceNum": 0,
	 *           "virtIo": 0,
	 *           "ipList": "113.55.12.216",
	 *           "nicType": 0,
	 *           "portId": "316"
	 *         }
	 *       ],
	 *       "usb": [
	 *         {
	 *           "controllerType": "EHCI+UHCI",
	 *           "device": [],
	 *           "usbHostName": null
	 *         }
	 *       ],
	 *       "gpu": [],
	 *       "properties": {
	 *         "bootOption": "disk",
	 *         "isEnableHa": true,
	 *         "vmFaultProcess": "notprocess",
	 *         "reoverByHost": false,
	 *         "clockMode": "freeClock",
	 *         "isEnableMemVol": true,
	 *         "isEnableFt": false,
	 *         "isAutoUpgrade": true,
	 *         "attachType": false,
	 *         "gpuShareType": "normal",
	 *         "isReserveResource": false,
	 *         "secureVmType": null,
	 *         "isHpet": false,
	 *         "bootFirmware": "BIOS",
	 *         "vmVncKeymapSetting": 7
	 *       }
	 *     },
	 *     "vmRebootConfig": {
	 *       "cpu": {
	 *         "quantity": 4,
	 *         "coresPerSocket": 4,
	 *         "reservation": 0,
	 *         "weight": 4000,
	 *         "limit": 0,
	 *         "cpuHotPlug": null,
	 *         "affinitySet": null
	 *       },
	 *       "memory": {
	 *         "quantityMB": 8192,
	 *         "reservation": 5734,
	 *         "weight": 81920,
	 *         "limit": 8192,
	 *         "memHotPlug": null
	 *       }
	 *     },
	 *     "osOptions": {
	 *       "osType": "Windows",
	 *       "osVersion": 2,
	 *       "guestOSName": null,
	 *       "hostname": "WIN-N3OBK6UPGMF",
	 *       "password": null
	 *     },
	 *     "idle": 136,
	 *     "deleteTime": null,
	 *     "toolsVersion": "1.3.10.32",
	 *     "imcSetting": null,
	 *     "minCompatibleimcSetting": "Ivy Bridge",
	 *     "isBindingHost": false,
	 *     "additionalStatus": [],
	 *     "hostName": "CNA06",
	 *     "clusterName": "托管集群",
	 *     "vmType": 0,
	 *     "drStatus": 9,
	 *     "rpoStatus": 0,
	 *     "initSyncStatus": 0,
	 *     "drDrillVmUri": null,
	 *     "drDrillVmUrn": null,
	 *     "objectPrivs": [],
	 *     "isMultiDiskSpeedup": false,
	 *     "params": {
	 *       "externalUuid": "5d48e6af-968d-45d0-a912-93aa2419c243",
	 *       "vmSubStatus": "0",
	 *       "cdromSequenceNum": "1003",
	 *       "parentObjUrn": null,
	 *       "PCI_IB_CARD": "0",
	 *       "gpu": "[]"
	 *     }
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询虚拟机详情 ", notes = "根据siteId/vmId查询虚拟机详情 ", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/vmResource/{vmId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<VmInfo> queryVM(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@ApiParam(name = "vmId", value = "The id of the vm", defaultValue = "i-0000027D") @PathVariable String vmId) {
		VmResource vmResource = ServiceFactory.getService(VmResource.class, clientProviderBean);
		String vmUri = String.format("/service/sites/%s/vms/%s", siteId, vmId);
		FCSDKResponse<VmInfo> queryVM = vmResource.queryVM(vmUri);
		return queryVM;
	}
}
