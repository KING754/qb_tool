package com.wejias.qb_tool.constant;

public enum TimeUnit {
    SECOND("秒",1),
    MINUTE("分钟",60),
    HOUR("小时",60*60),
    DAY("天",60*60*24);
    
    private String displayUnit;
    private double minSecondNum;
    
    TimeUnit(String displayUnit, double minSecondNum) {
       this.displayUnit = displayUnit;
       this.minSecondNum = minSecondNum;
    }
    
    public static String getDoubleTimeAndUnitNoDay(long secondNum) {
        String reSpaceStr = "0";
        if(secondNum <= 0) {
            return reSpaceStr;
        }
        
        if(secondNum >= HOUR.minSecondNum) {
            double spaceDoubleNum = (double)secondNum/HOUR.minSecondNum;
            reSpaceStr = spaceDoubleNum+HOUR.displayUnit;
        }else if(secondNum >= MINUTE.minSecondNum){
            double spaceDoubleNum = (double)secondNum/MINUTE.minSecondNum;
            reSpaceStr = spaceDoubleNum+MINUTE.displayUnit;
        }else {
            reSpaceStr = secondNum+SECOND.displayUnit;
        }
        return reSpaceStr;
    }
}
