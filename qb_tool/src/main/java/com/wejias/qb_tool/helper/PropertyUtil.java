package com.wejias.qb_tool.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.wejias.qb_tool.constant.Constant;

public class PropertyUtil {

    public static void init() {
        loadProps(Constant.SETTING_PROPERTIES, Constant.SETTING_PROPERTY_PATH);
        loadProps(Constant.SITE_PROPERTIES, Constant.SITE_PROPERTY_PATH);
    }

    private static void loadProps(Properties props, String propertyFilePath) {
        InputStream in = null;
        try {
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(propertyFilePath);
            props.load(in);
        } catch (FileNotFoundException e) {
            System.out.println("config.properties文件未找到");
        } catch (IOException e) {
            System.out.println("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("config.properties文件流关闭出现异常");
            }
        }
    }

    public static String getPropertyStrValue(Properties prop, String key) {
        if (null == prop) {
            throw new NullPointerException("prop is null.whit key:" + key);
        }
        return prop.getProperty(key);
    }

}
