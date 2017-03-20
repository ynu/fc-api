package com.liudonghua.api.fc.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.storage.AvailableDatastoreQueryParams;
import com.huawei.esdk.fusioncompute.local.model.storage.Datastore;
import com.huawei.esdk.fusioncompute.local.model.storage.DatastoreQueryParams;
import com.huawei.esdk.fusioncompute.local.resources.storage.DataStorageResource;
import com.liudonghua.api.fc.util.Utils;

@RestController
@RequestMapping("/site")
public class DataStorageController {

	/**
	 * 
	 * @param siteUri
	 * @param limit
	 * @param offset
	 * @return
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
	 */
	@RequestMapping("/{siteId}/dataStorage/")
	public FCSDKResponse<PageList<Datastore>> queryDataStores(@PathVariable String siteId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		DataStorageResource dataStorageResource = ServiceFactory.getService(DataStorageResource.class, Utils.initLoginClientProviderBean());
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
	 * @param offset
	 * /site/3F7B07E2/dataStorage/1/134/availableDatastore/
	 * @return
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
	 */
	@RequestMapping("/{siteId}/dataStorage/{dataStoreId}/{hostId}/availableDatastore")
	public FCSDKResponse<PageList<Datastore>> queryAvailableDatastore(@PathVariable String siteId, @PathVariable String dataStoreId, @PathVariable String hostId,
			@RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
		DataStorageResource dataStorageResource = ServiceFactory.getService(DataStorageResource.class, Utils.initLoginClientProviderBean());
		String siteUri = String.format("/service/sites/%s", siteId);
		AvailableDatastoreQueryParams param = new AvailableDatastoreQueryParams();
		param.setLimit(limit);
		param.setOffset(offset);
		param.setScope(String.format("urn:sites:%s:hosts:%s", siteId, hostId));
	    param.setDatastoreURN(String.format("urn:sites:%s:datastores:%s", siteId, dataStoreId));
		FCSDKResponse<PageList<Datastore>> queryAvailableDatastore = dataStorageResource.queryAvailableDatastore(siteUri, param);
		return queryAvailableDatastore;
	}

	/**
	 * 
	 * @param siteId
	 * @param datastoreId
	 * @return
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
	 */
	@RequestMapping("/{siteId}/dataStorage/{datastoreId}")
	public FCSDKResponse<Datastore> queryDataStore(@PathVariable String siteId, @PathVariable int datastoreId) {
		DataStorageResource dataStorageResource = ServiceFactory.getService(DataStorageResource.class, Utils.initLoginClientProviderBean());
		String siteUri = String.format("/service/sites/%s", siteId);
		String datastoreUri = siteUri + "/datastores/" + datastoreId;
		FCSDKResponse<Datastore> queryDataStore = dataStorageResource.queryDataStore(datastoreUri);
		return queryDataStore;
	}
}
