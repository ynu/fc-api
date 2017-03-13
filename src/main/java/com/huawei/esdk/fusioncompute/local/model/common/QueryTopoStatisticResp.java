/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.fusioncompute.local.model.common;

import java.util.List;

/**
 * 查询对象的TOP监控数据响应消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryTopoStatisticResp
{
    /**
     * Items的个数。
     */
    private Integer total;
    
    /**
     * 预留。
     */
    private String result;
    
    /**
     * 指标返回值列表。
     */
    private List<TopoStatistic> items;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public List<TopoStatistic> getItems()
    {
        return items;
    }
    
    public void setItems(List<TopoStatistic> items)
    {
        this.items = items;
    }

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    
}
