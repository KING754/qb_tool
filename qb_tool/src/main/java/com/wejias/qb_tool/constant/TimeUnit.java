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
        String reHoursStr = "0";
        if(secondNum <= 0) {
            return reHoursStr;
        }
        
        if(secondNum >= HOUR.minSecondNum) {
            double timeDoubleNum = (double)secondNum/HOUR.minSecondNum;
            reHoursStr = String.format("%.2f", timeDoubleNum)+HOUR.displayUnit;
        }else if(secondNum >= MINUTE.minSecondNum){
            double spaceDoubleNum = (double)secondNum/MINUTE.minSecondNum;
            reHoursStr = String.format("%.2f", spaceDoubleNum)+MINUTE.displayUnit;
        }else {
            reHoursStr = secondNum+SECOND.displayUnit;
        }
        return reHoursStr;
    }
}
