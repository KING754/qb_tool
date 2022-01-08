package com.wejias.qb_tool.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SiteInfo {
    public static Map<String, String> SITE_NAME_DOMAIN_MAP = new HashMap<String, String>();

    public static void initSiteMap() {
        if (Constant.SITE_PROPERTIES == null || Constant.SITE_PROPERTIES.isEmpty()) {
            throw new NullPointerException("Constant.SITE_PROPERTIES is null or empty");
        }

        Set<Object> proNameSet = Constant.SITE_PROPERTIES.keySet();
        for (Object info : proNameSet) {
            String key = (String)info;
            String value = Constant.SITE_PROPERTIES.getProperty(key);
            SITE_NAME_DOMAIN_MAP.put(key, value);
        }
    }
    
    public static String getSiteName(String path) {
        for (Entry<String, String> siteInfo : SITE_NAME_DOMAIN_MAP.entrySet()) {
            String domian = siteInfo.getValue();
            if(path.indexOf(domian) >= 0) {
               return siteInfo.getKey();
            }
        }
        return null;
    }
    
}
