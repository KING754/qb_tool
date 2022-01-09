package com.wejias.qb_tool.constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.wejias.qb_tool.helper.JsonHelper;

public class TrackerInfo {
    public static Map<String, String> RID_TRACKER_MAP = new HashMap<String, String>();

    public static void initTrackerMap(List<Map<String, Object>> trackerList) {
        if (trackerList == null || trackerList.isEmpty()) {
            throw new NullPointerException("main tracker is null or empty");
        }
        
        for (Map<String, Object> map : trackerList) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String trackURL = entry.getKey();
                Object val = entry.getValue();
                if(val instanceof JSONArray) {
                    List<String> ridList = JsonHelper.toTypeList(val.toString(),String.class);
                    if(ridList != null && !ridList.isEmpty()) {
                        for (String rid : ridList) {
                            RID_TRACKER_MAP.put(rid, trackURL);
                        }
                    }
                }
            }
        }
        
    }
    
    public static String getTrackerURL(String rid) {
        return RID_TRACKER_MAP.get(rid);
    }
    
}
