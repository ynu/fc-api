package com.liudonghua.api.fc.rest;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.alarm.ActiveAlarmQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.Alarm;
import com.huawei.esdk.fusioncompute.local.model.alarm.Event;
import com.huawei.esdk.fusioncompute.local.model.alarm.EventQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.HistoryAlarm;
import com.huawei.esdk.fusioncompute.local.model.alarm.HistoryAlarmQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.QueryThresholdsResp;
import com.huawei.esdk.fusioncompute.local.resources.alarm.AlarmResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@Api(value = "/site", authorizations = { @Authorization(value = "token") }, tags = "alarm")
@RestController
@RequestMapping("/site")
public class AlarmController {

	@Autowired
	ClientProviderBean clientProviderBean;

	/**
	 * @return <code>
	 * <pre>
	 * {
	 *     "result": {
	 *         "total": 35,
	 *         "list": [{
	 *             "iSerialNo": 55829,
	 *             "svAlarmID": "15.1000102",
	 *             "objectType": "否",
	 *             "objectUrn": "urn:sites:3F7B07E2:vms:i-000001D0",
	 *             "urnByName": "LOC-MongoDB1",
	 *             "svAlarmName": "虚拟机内存占用率超过阈值",
	 *             "iAlarmCategory": "原始告警",
	 *             "iAlarmLevel": "次要",
	 *             "iClearType": "-",
	 *             "dtOccurTime": "1487701980000",
	 *             "dtUpdateTime": "1487815200000",
	 *             "dtClearTime": "-",
	 *             "svClearAlarmUserName": "-",
	 *             "svAdditionalInfo": "当前阈值\u003d80.0%,虚拟机内存占用率\u003d79.89%",
	 *             "svAlarmCause": "-",
	 *             "svEventType": "设备事件",
	 *             "iAutoClear": "是",
	 *             "iAffectOpFlag": "影响",
	 *             "dtArrivedTime": "1487701998157",
	 *             "svLocationInfo": "-",
	 *             "svMoc": "vms",
	 *             "iDisplay": "未屏蔽",
	 *             "iParse": "0",
	 *             "iSyncNo": "139796"
	 *         }]
	 *     },
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }
	 * </pre>
	 * </code>
	 */
	@ApiOperation(value = "查询活动告警", notes = "根据siteId以及可选的limit/offset查询活动告警", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/alarm/activeAlarm", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<Alarm>> queryActiveAlarms(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
			@ApiParam(name = "offset", value = "The value of offset", defaultValue = "0") @RequestParam(value = "offset", defaultValue = "0", required = false) int offset) {
		AlarmResource alarmResource = ServiceFactory.getService(AlarmResource.class, clientProviderBean);
		ActiveAlarmQueryParams par = new ActiveAlarmQueryParams();
		par.setLimit(limit);
		par.setOffset(offset);
		String siteUri = String.format("/service/sites/%s", siteId);
		FCSDKResponse<PageList<Alarm>> queryActiveAlarms = alarmResource.queryActiveAlarms(par, siteUri);
		return queryActiveAlarms;
	}

	/**
	 * @return <code>
	 * <pre>
	 * {
	 *     "result": {
	 *         "total": 1141,
	 *         "list": [{
	 *             "eventName": "虚拟机IP发生变化",
	 *             "objectType": "否",
	 *             "objectUrn": "urn:sites:3F7B07E2:vms:i-00000001",
	 *             "urnByName": "VRM01",
	 *             "eventID": "15.3000205",
	 *             "occurTime": "1441111287530",
	 *             "additionalInfo": "虚拟机ID\u003di-00000001,改变前虚拟机的IP\u003d0.0.0.0,改变后虚拟机的IP\u003d202.203.209.72",
	 *             "isParse": "0",
	 *             "locationInfo": "-"
	 *         }]
	 *     },
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }	 
	 * </pre>
	 * </code>
	 */
	@ApiOperation(value = "查询事件列表功能", notes = "根据siteId以及可选的limit/offset查询事件列表功能", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/alarm/event", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<Event>> queryEvents(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
			@RequestParam(value = "offset", defaultValue = "0", required = false) int offset) {
		AlarmResource alarmResource = ServiceFactory.getService(AlarmResource.class, clientProviderBean);
		EventQueryParams par = new EventQueryParams();
		par.setLimit(limit);
		par.setOffset(offset);
		String siteUri = String.format("/service/sites/%s", siteId);
		FCSDKResponse<PageList<Event>> queryEvents = alarmResource.queryEvents(par, siteUri);
		return queryEvents;
	}

	/**
	 * @return <code>
	 * <pre>
	 * {
	 *     "result": {
	 *         "total": 101006,
	 *         "list": [{
	 *             "iSerialNo": 6550,
	 *             "iSyncNo": 39368,
	 *             "svAlarmID": "15.1008003",
	 *             "objectType": "否",
	 *             "objectUrn": "urn:sites:3F7B07E2:sites:3F7B07E2",
	 *             "urnByName": "site",
	 *             "svAlarmName": "系统配置的DNS服务不可用",
	 *             "iAlarmCategory": "清除告警",
	 *             "iAlarmLevel": "紧急",
	 *             "iClearType": "正常清除",
	 *             "dtOccurTime": "1485086699894",
	 *             "dtUpdateTime": "-",
	 *             "dtClearTime": "1485087956914",
	 *             "svClearAlarmUserName": "-",
	 *             "svAdditionalInfo": "-",
	 *             "svAlarmCause": "DNS Service Normal",
	 *             "svEventType": "业务质量事件",
	 *             "iAutoClear": "是",
	 *             "iAffectOpFlag": "不影响",
	 *             "dtArrivedTime": "1485087957868",
	 *             "svLocationInfo": "-",
	 *             "svMoc": "sites",
	 *             "iDisplay": "未屏蔽",
	 *             "iParse": "0"
	 *         }]
	 *     },
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询历史告警", notes = "根据siteId以及可选的limit/offset查询历史告警", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/alarm/historyAlarm", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<PageList<HistoryAlarm>> queryHistoryAlarms(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
			@RequestParam(value = "offset", defaultValue = "0", required = false) int offset) {
		AlarmResource alarmResource = ServiceFactory.getService(AlarmResource.class, clientProviderBean);
		HistoryAlarmQueryParams par = new HistoryAlarmQueryParams();
		par.setLimit(limit);
		par.setOffset(offset);
		String siteUri = String.format("/service/sites/%s", siteId);
		FCSDKResponse<PageList<HistoryAlarm>> queryHistoryAlarms = alarmResource.queryHistoryAlarms(par, siteUri);
		return queryHistoryAlarms;
	}

	/**
	 * @return <code>
	 * <pre>
	 * {
	 *     "result": {
	 *         "total": 19,
	 *         "result": 0,
	 *         "itemSize": 19,
	 *         "items": [{
	 *             "id": "1",
	 *             "alarmID": "15.1000025",
	 *             "metricId": "cpu_usage",
	 *             "metricDesc": "CPU占用率",
	 *             "objectType": "clusters",
	 *             "objectTypeDesc": "集群",
	 *             "metricUnit": "%",
	 *             "alarmCompFlag": "0",
	 *             "alarmThrWarning": "65535",
	 *             "alarmThrMinor": "70",
	 *             "alarmThrMajor": "80",
	 *             "alarmThrCritical": "65535",
	 *             "eviValue": "5"
	 *         }]
	 *     },
	 *     "errorCode": "00000000",
	 *     "errorDes": null
	 * }	 
	 * </pre>	 
	 * </code>
	 */
	@ApiOperation(value = "查询所有阈值项信息", notes = "根据siteId以及可选的limit/offset查询所有阈值项信息", authorizations = {
			@Authorization(value = "token") })
	@RequestMapping(path = "/{siteId}/alarm/thresold", method = RequestMethod.GET, produces = "application/json")
	public FCSDKResponse<QueryThresholdsResp> queryThresholds(
			@ApiParam(name = "siteId", value = "The id of the site", defaultValue = "3F7B07E2") @PathVariable String siteId,
			@RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
			@RequestParam(value = "offset", defaultValue = "0", required = false) int offset) {
		AlarmResource alarmResource = ServiceFactory.getService(AlarmResource.class, clientProviderBean);
		String siteUri = String.format("/service/sites/%s", siteId);
		FCSDKResponse<QueryThresholdsResp> queryThresholds = alarmResource.queryThresholds(siteUri);
		return queryThresholds;
	}
}
