package com.liudonghua.api.fc.rest;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.storage.AvailableDatastoreQueryParams;
import com.huawei.esdk.fusioncompute.local.model.storage.Datastore;
import com.huawei.esdk.fusioncompute.local.model.storage.DatastoreQueryParams;
import com.huawei.esdk.fusioncompute.local.resources.storage.DataStorageResource;

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
public class DataStorageController {

	@Autowired
	ClientProviderBean clientProviderBean;

	/**
	 * 
	 * @param siteUri
	 * @param limit
	 * @param offset
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "total": 20,
	 *     "list": [
	 *       {
	 *         "urn": "urn:sites:3F7B07E2:datastores:1",
	 *         "uri": "/service/sites/3F7B07E2/datastores/1",
	 *         "suUrn": "urn:sites:3F7B07E2:storageunits:6FE4A2A1AD074151B894831C78C5537D",
	 *         "suName": "scsi-366c92bf0000b31941d78304db51ec09a-part10",
	 *         "storageType": "local",
	 *         "clusterSize": null,
	 *         "name": "autoDS01",
	 *         "status": "NORMAL",
	 *         "capacityGB": 1845,
	 *         "usedSizeGB": 781,
	 *         "freeSizeGB": 1064,
	 *         "hosts": [
	 *           "urn:sites:3F7B07E2:hosts:134"
	 *         ],
	 *         "isThin": false,
	 *         "description": null,
	 *         "thinRate": 100,
	 *         "actualCapacityGB": 1845,
	 *         "actualFreeSizeGB": 1064,
	 *         "refreshTime": "2015-09-01 11:07:01",
	 *         "version": null,
	 *         "tierSize": null,
	 *         "ioDelay": null,
	 *         "expandCount": null,
	 *         "suIdList": [],
	 *         "siocFlag": 0,
	 *         "storageUnits": [
	 *           {
	 *             "urn": "6FE4A2A1AD074151B894831C78C5537D",
	 *             "sdName": "LOCAL",
	 *             "suName": "scsi-366c92bf0000b31941d78304db51ec09a-part10"
	 *           }
	 *         ],
	 *         "params": null
	 *       }
	 *     ]
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "分页查询站点/主机/集群下所有数据存储", notes = "根据siteId以及可选的limit/offset分页查询站点/主机/集群下所有数据存储", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/dataStorage/", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<Datastore>> queryDataStores(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		DataStorageResource dataStorageResource = ServiceFactory.getService(DataStorageResource.class,
				clientProviderBean);
		String siteUri = String.format("/service/sites/%s", siteId);
		DatastoreQueryParams param = new DatastoreQueryParams();
		param.setLimit(limit);
		param.setOffset(offset);
		FCSDKResponse<PageList<Datastore>> queryDataStores2 = dataStorageResource.queryDataStores(siteUri, param);
		return queryDataStores2;
	}

	/**
	 * 
	 * @param siteId
	 * @param dataStoreId
	 * @param hostId
	 * @param limit
	 * @param offset      /site/3F7B07E2/dataStorage/1/134/availableDatastore/
	 * @return
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "total": 5,
	 *     "list": [
	 *       {
	 *         "urn": "urn:sites:3F7B07E2:datastores:1",
	 *         "uri": "/service/sites/3F7B07E2/datastores/1",
	 *         "suUrn": "urn:sites:3F7B07E2:storageunits:6FE4A2A1AD074151B894831C78C5537D",
	 *         "suName": "scsi-366c92bf0000b31941d78304db51ec09a-part10",
	 *         "storageType": "local",
	 *         "clusterSize": null,
	 *         "name": "autoDS01",
	 *         "status": "CONNECTED",
	 *         "capacityGB": 1845,
	 *         "usedSizeGB": 781,
	 *         "freeSizeGB": 1064,
	 *         "hosts": [
	 *           "urn:sites:3F7B07E2:hosts:134"
	 *         ],
	 *         "isThin": false,
	 *         "description": null,
	 *         "thinRate": 100,
	 *         "actualCapacityGB": 1845,
	 *         "actualFreeSizeGB": 1064,
	 *         "refreshTime": "2015-09-01 11:07:01",
	 *         "version": null,
	 *         "tierSize": null,
	 *         "ioDelay": null,
	 *         "expandCount": null,
	 *         "suIdList": [],
	 *         "siocFlag": 0,
	 *         "storageUnits": [],
	 *         "params": null
	 *       }
	 *     ]
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "分页查询集群/主机下可模板部署的所有数据存储", notes = "根据siteId以及可选的limit/offset分页查询集群/主机下可模板部署的所有数据存储", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/dataStorage/{dataStoreId}/{hostId}/availableDatastore", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<Datastore>> queryAvailableDatastore(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@ApiParam(name = "dataStoreId", value = "The id of the dataStore", defaultValue = "1") @PathVariable String dataStoreId,
			@ApiParam(name = "hostId", value = "The id of the host", defaultValue = "134") @PathVariable String hostId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		DataStorageResource dataStorageResource = ServiceFactory.getService(DataStorageResource.class,
				clientProviderBean);
		String siteUri = String.format("/service/sites/%s", siteId);
		AvailableDatastoreQueryParams param = new AvailableDatastoreQueryParams();
		param.setLimit(limit);
		param.setOffset(offset);
		param.setScope(String.format("urn:sites:%s:hosts:%s", siteId, hostId));
		param.setDatastoreURN(String.format("urn:sites:%s:datastores:%s", siteId, dataStoreId));
		FCSDKResponse<PageList<Datastore>> queryAvailableDatastore = dataStorageResource
				.queryAvailableDatastore(siteUri, param);
		return queryAvailableDatastore;
	}

	/**
	 * 
	 * @param siteId
	 * @param datastoreId
	 * @return
	 * @return <code>
	 * <pre>
	 * {
	 *   "errorCode": "00000000",
	 *   "errorDes": null,
	 *   "result": {
	 *     "urn": "urn:sites:3F7B07E2:datastores:1",
	 *     "uri": "/service/sites/3F7B07E2/datastores/1",
	 *     "suUrn": "urn:sites:3F7B07E2:storageunits:6FE4A2A1AD074151B894831C78C5537D",
	 *     "suName": "scsi-366c92bf0000b31941d78304db51ec09a-part10",
	 *     "storageType": "local",
	 *     "clusterSize": null,
	 *     "name": "autoDS01",
	 *     "status": "NORMAL",
	 *     "capacityGB": 1845,
	 *     "usedSizeGB": 781,
	 *     "freeSizeGB": 1064,
	 *     "hosts": [
	 *       "urn:sites:3F7B07E2:hosts:134"
	 *     ],
	 *     "isThin": false,
	 *     "description": null,
	 *     "thinRate": 100,
	 *     "actualCapacityGB": 1845,
	 *     "actualFreeSizeGB": 1064,
	 *     "refreshTime": "2015-09-01 11:07:01",
	 *     "version": null,
	 *     "tierSize": null,
	 *     "ioDelay": null,
	 *     "expandCount": 0,
	 *     "suIdList": [
	 *       "6FE4A2A1AD074151B894831C78C5537D"
	 *     ],
	 *     "siocFlag": 0,
	 *     "storageUnits": [
	 *       {
	 *         "urn": "6FE4A2A1AD074151B894831C78C5537D",
	 *         "sdName": null,
	 *         "suName": "scsi-366c92bf0000b31941d78304db51ec09a-part10"
	 *       }
	 *     ],
	 *     "params": null
	 *   }
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询指定数据存储", notes = "根据siteId/datastoreId查询指定数据存储", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/dataStorage/{datastoreId}", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<Datastore> queryDataStore(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@PathVariable int datastoreId) {
		DataStorageResource dataStorageResource = ServiceFactory.getService(DataStorageResource.class,
				clientProviderBean);
		String siteUri = String.format("/service/sites/%s", siteId);
		String datastoreUri = siteUri + "/datastores/" + datastoreId;
		FCSDKResponse<Datastore> queryDataStore = dataStorageResource.queryDataStore(datastoreUri);
		return queryDataStore;
	}
}
