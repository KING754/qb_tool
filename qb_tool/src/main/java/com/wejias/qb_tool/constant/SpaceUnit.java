package com.wejias.qb_tool.constant;

public enum SpaceUnit {
    Byte("B",(double)1),
    KB("K",(double)1024),
    MB("M",(double)1024*(double)1024),
    GB("G",(double)1024*(double)1024*(double)1024),
    TB("T",(double)1024*(double)1024*(double)1024*(double)1024),
    PB("P",(double)1024*(double)1024*(double)1024*(double)1024*(double)1024);
    
    private String displayName;
    private double minBytNum;
    
    SpaceUnit(String displayName, double minBytNum) {
       this.displayName = displayName;
       this.minBytNum = minBytNum;
    }
    
    public double getMinByteNum() {
        return this.minBytNum;
    }
    
    public static String getDoubleSpaceAndUnit(long byteSize) {
        String reSpaceStr = "null";
        if(byteSize <= 0) {
            return reSpaceStr;
        }
        
        if(byteSize >= PB.minBytNum) {
            double spaceDoubleNum = (double)byteSize/PB.minBytNum;
            reSpaceStr = spaceDoubleNum+PB.displayName;
        }else if(byteSize >= TB.minBytNum){
            double spaceDoubleNum = (double)byteSize/TB.minBytNum;
            reSpaceStr = spaceDoubleNum+TB.displayName;
        }else if(byteSize >= GB.minBytNum){
            double spaceDoubleNum = (double)byteSize/GB.minBytNum;
            reSpaceStr = spaceDoubleNum+GB.displayName;
        }else if(byteSize >= MB.minBytNum){
            double spaceDoubleNum = (double)byteSize/MB.minBytNum;
            reSpaceStr = spaceDoubleNum+MB.displayName;
        }else if(byteSize >= KB.minBytNum){
            double spaceDoubleNum = (double)byteSize/KB.minBytNum;
            reSpaceStr = spaceDoubleNum+KB.displayName;
        }else {
            reSpaceStr = byteSize+Byte.displayName;
        }
        return reSpaceStr;
    }
}
