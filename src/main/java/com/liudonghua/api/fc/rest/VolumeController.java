package com.liudonghua.api.fc.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.storage.QueryDatastoreVolumeResp;
import com.huawei.esdk.fusioncompute.local.model.storage.Volume;
import com.huawei.esdk.fusioncompute.local.model.storage.VolumeQueryParams;
import com.huawei.esdk.fusioncompute.local.resources.storage.VolumeResource;
import com.liudonghua.api.fc.util.Utils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/site")
public class VolumeController {

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
	 *     "total": 304,
	 *     "list": [
	 *       {
	 *         "urn": "urn:sites:3F7B07E2:volumes:1245",
	 *         "uri": "/service/sites/3F7B07E2/volumes/1245",
	 *         "uuid": "5c4c2648-117e-46f7-bd7d-e832d56a6a5b",
	 *         "name": "医院信息管理",
	 *         "quantityGB": 500,
	 *         "status": "USE",
	 *         "storageType": "LUNPOME",
	 *         "isThin": true,
	 *         "type": "normal",
	 *         "datastoreUrn": "urn:sites:3F7B07E2:datastores:131",
	 *         "datastoreName": "宏杉存储_托管集群",
	 *         "indepDisk": false,
	 *         "persistentDisk": true,
	 *         "volNameOnDev": "5c4c2648-117e-46f7-bd7d-e832d56a6a5b",
	 *         "volProvisionSize": 0,
	 *         "userUsedSize": null,
	 *         "isDiffVol": false,
	 *         "volType": 0,
	 *         "maxReadBytes": 0,
	 *         "maxWriteBytes": 0,
	 *         "maxReadRequest": 0,
	 *         "maxWriteRequest": 0,
	 *         "pciType": "IDE",
	 *         "occupiedVolume": false,
	 *         "bindToVm": 3,
	 *         "srcVolumeUrn": null,
	 *         "volumeUseType": null,
	 *         "ioWeight": "0",
	 *         "siocFlag": null,
	 *         "volumeUrl": null,
	 *         "linkCloneParent": null,
	 *         "volInfoUrl": null,
	 *         "drExtParams": null,
	 *         "params": null,
	 *         "pvscsiSupport": 0,
	 *         "storageVersion": null,
	 *         "storageSN": null,
	 *         "lunId": null,
	 *         "sdUrn": null,
	 *         "sdUri": null,
	 *         "iscsi": null
	 *       }
	 *     ]
	 *   }
	 * }
	 */
	@ApiOperation(value = "分页查询卷列表", notes = "根据siteId以及可选的limit/offset分页查询卷列表")
	@RequestMapping(path="/{siteId}/volumeResource/", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<Volume>> queryVolumes(@PathVariable String siteId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		VolumeResource volumeResource = ServiceFactory.getService(VolumeResource.class, Utils.initLoginClientProviderBean());
		String siteUri = String.format("/service/sites/%s", siteId);
		VolumeQueryParams param = new VolumeQueryParams();
		param.setLimit(limit);
		param.setOffset(offset);
		FCSDKResponse<PageList<Volume>> queryVolumes = volumeResource.queryVolumes(siteUri, param);
		return queryVolumes;
	}

	/**
	 * 
	 * @param siteId
	 * @param volumeId
	 * @param refreshFlag
	 * @return
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "urn": "urn:sites:3F7B07E2:volumes:1245",
	 *     "uri": "/service/sites/3F7B07E2/volumes/1245",
	 *     "uuid": "5c4c2648-117e-46f7-bd7d-e832d56a6a5b",
	 *     "name": "医院信息管理",
	 *     "quantityGB": 500,
	 *     "status": "USE",
	 *     "storageType": "LUNPOME",
	 *     "isThin": true,
	 *     "type": "normal",
	 *     "datastoreUrn": "urn:sites:3F7B07E2:datastores:131",
	 *     "datastoreName": "宏杉存储_托管集群",
	 *     "indepDisk": false,
	 *     "persistentDisk": true,
	 *     "volNameOnDev": "5c4c2648-117e-46f7-bd7d-e832d56a6a5b",
	 *     "volProvisionSize": 0,
	 *     "userUsedSize": null,
	 *     "isDiffVol": false,
	 *     "volType": 0,
	 *     "maxReadBytes": 0,
	 *     "maxWriteBytes": 0,
	 *     "maxReadRequest": 0,
	 *     "maxWriteRequest": 0,
	 *     "pciType": "IDE",
	 *     "occupiedVolume": null,
	 *     "bindToVm": null,
	 *     "srcVolumeUrn": "null",
	 *     "volumeUseType": 0,
	 *     "ioWeight": "0",
	 *     "siocFlag": 0,
	 *     "volumeUrl": "/POME/datastore_131/vol/vol_5c4c2648-117e-46f7-bd7d-e832d56a6a5b/vol_5c4c2648-117e-46f7-bd7d-e832d56a6a5b.vhd",
	 *     "linkCloneParent": null,
	 *     "volInfoUrl": null,
	 *     "drExtParams": "",
	 *     "params": null,
	 *     "pvscsiSupport": 0,
	 *     "storageVersion": null,
	 *     "storageSN": null,
	 *     "lunId": null,
	 *     "sdUrn": null,
	 *     "sdUri": null,
	 *     "iscsi": null
	 *   }
	 * }
	 */
	@ApiOperation(value = "查询指定卷", notes = "根据siteId/volumeId查询指定卷")
	@RequestMapping(path="/{siteId}/volumeResource/{volumeId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<Volume> queryVolume(@PathVariable String siteId, @PathVariable String volumeId, 
			@RequestParam(name="refreshFlag", required=false, defaultValue="false") boolean refreshFlag) {
		VolumeResource volumeResource = ServiceFactory.getService(VolumeResource.class, Utils.initLoginClientProviderBean());
		String volumeUri = String.format("/service/sites/%s/volumes/%s", siteId, volumeId);
		FCSDKResponse<Volume> queryVolume = volumeResource.queryVolume(volumeUri, refreshFlag);
		return queryVolume;
	}
	
	/**
	 * 
	 * @param siteId
	 * @param dataStoreId
	 * @param limit
	 * @param offset
	 * @return

	 */
	@ApiOperation(value = "分页根据DataStore查询所有卷", notes = "根据siteId/dataStoreId以及可选的limit/offset分页根据DataStore查询所有卷")
	@RequestMapping(path="/{siteId}/volumeResource/datastoreVolumes/{dataStoreId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<QueryDatastoreVolumeResp>> queryDatastoreVolumes(@PathVariable String siteId, 
			@PathVariable String dataStoreId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		VolumeResource volumeResource = ServiceFactory.getService(VolumeResource.class, Utils.initLoginClientProviderBean());
		String siteUri = String.format("/service/sites/%s", siteId);
		String dataStoreUri = String.format("urn:sites:%s:datastores:%s", siteUri, dataStoreId);
		FCSDKResponse<PageList<QueryDatastoreVolumeResp>> queryDatastoreVolumes = volumeResource.queryDatastoreVolumes(siteUri, limit, offset, dataStoreUri);
		return queryDatastoreVolumes;
	}
}
