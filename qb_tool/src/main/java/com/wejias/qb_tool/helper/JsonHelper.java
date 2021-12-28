package com.wejias.qb_tool.helper;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
*
*/
public class JsonHelper {
	private static Logger logger = Logger.getLogger(JsonHelper.class);
	
	private static final SerializerFeature[] features = new SerializerFeature[]{
		SerializerFeature.WriteDateUseDateFormat,
		SerializerFeature.WriteNullListAsEmpty,
		SerializerFeature.WriteNullStringAsEmpty,
		SerializerFeature.WriteMapNullValue,
		SerializerFeature.DisableCircularReferenceDetect
	};
	
	public static String toJsonStr(Object obj) {
		try{
			return JSON.toJSONString(obj,features);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(obj+" #toJsonStr fail #"+ e.getMessage());
			return null;
		}
	}
	

	public static <T> T toJSONObject(String jsonStr,Class<T> type){
		try{
			return JSON.parseObject(jsonStr,type);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(jsonStr +","+type+" toJSONObject fail"+e.getMessage());
			return null;
		}
		
	}
	
	public static JSONObject toJSONObject(String jsonStr){
		try{
			return JSON.parseObject(jsonStr);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(jsonStr +", toJSONObject fail"+e.getMessage());
			return null;
		}
		
	}
	
	public static  <T> List<T> toTypeList(String jsonStr,Class<T> type){
		try{
			return JSON.parseArray(jsonStr, type);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(jsonStr +","+type+" toObjectList fail"+e.getMessage());
			return null;
		}
	}
	
	
	public static List<Object> toObjList(String jsonStr){
		try{
			return JSON.parseArray(jsonStr);
		}catch(Exception e){
			logger.error(jsonStr +",toObjectList fail"+e.getMessage());
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> strToMap(String jsonStr){
		try{
			Map<String,Object> jsonMap = JSON.parseObject(jsonStr,Map.class);
			return jsonMap;
		}catch(Exception e){
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> strToStrMap(String jsonStr){
		try{
			Map<String,String> jsonMap = JSON.parseObject(jsonStr,Map.class);
			return jsonMap;
		}catch(Exception e){
			return null;
		}
	}
	
	
	public static Map<String,Integer> strToStrAndIntMap(String jsonStr){
		try{
			@SuppressWarnings("unchecked")
			Map<String,Integer> jsonMap = JSON.parseObject(jsonStr,Map.class);
			return jsonMap;
		}catch(Exception e){
			return null;
		}
	}
	
	
//	public static <T> T toObjByGson(String jsonStr,Class<T> type){
//		try{
//			return new Gson().fromJson(jsonStr,type);
//		}catch(Exception e){
//			e.printStackTrace();
//			logger.error(jsonStr +","+type+" toJSONObject fail"+e.getMessage());
//			return null;
//		}
//	}
	
	
//	public static String toJsonStrByGson(Object obj) {
//		try{
//			return new Gson().toJson(obj);
//		}catch(Exception e){
//			logger.error(obj+" toJsonStr fail"+e.getMessage());
//			return null;
//		}
//	}

	
	public static void main(String... args){
//		PvpBattleResult record = new PvpBattleResult();
//		PvpBattleResult.PvpBattleHero hero = new PvpBattleResult.PvpBattleHero();
//		PvpBattleResult.PvpBattleHeroBuff buff = new PvpBattleResult.PvpBattleHeroBuff();
//		hero.setHero_buff(new PvpBattleResult.PvpBattleHeroBuff[]{buff,buff});
//		record.setAttacker(new PvpBattleResult.PvpBattleHero[]{hero,hero});
	}
}
