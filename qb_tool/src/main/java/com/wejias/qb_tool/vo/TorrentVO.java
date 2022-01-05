package com.wejias.qb_tool.vo;

import java.util.Date;
import java.util.Map;

import com.wejias.qb_tool.constant.SpaceUnit;
import com.wejias.qb_tool.constant.TimeUnit;

public class TorrentVO {
    public String                               name;
    public String                               cat;
    public String                               downloadSizeStr;            // unit:(G,M,KB)
    public String                               uploadsizeStr;              // unit:(G,M,KB)
    public Double                               uploadPrecent;              // 上传率
    public Date                                 addDate;
    public String                               totalSizeStr;               // unit:(G,M,KB)
    public String                               downAll;                    // 是/否
    public Date                                 finishDate;
    public String                               downloadHours;              // 下载用时,unit:hour
    public String                               existHours;                 // 存在天数,unit:hour
    public String                               activeHours;
    public String                               activePrecent;              // 做种率
    public String                               path;

    private Map<String, Double>                 siteUploadSize;

    // temp
    private long                                totalByteSize;
    private long                                downloadByteSize;
    private long                                uploadByteSize;
    private String                              srcSite;
    private long                                activeSecond;
    
    
    
    
    /**
     * 表需要的数据
     * name,分类,downloadSize(G,M,KB),updateloadsize(G,M,KB),上传率,开始时间,总大小,是否完成下载,完成时间,下载用时,存在时数,做种时数,做种时间比,savepath,site1上传,site2上传.....
     */  
    public TorrentVO(TorrentDto torrent) {
        this.name = torrent.getName();
        this.cat = torrent.getCategory();
        
        this.downloadByteSize = torrent.getDownloaded();
        this.downloadSizeStr = SpaceUnit.getDoubleSpaceAndUnit(this.downloadByteSize);
        
        this.uploadByteSize = torrent.getUploaded();
        this.uploadsizeStr = SpaceUnit.getDoubleSpaceAndUnit(this.uploadByteSize);
        
        this.uploadPrecent = ((double)uploadByteSize/(double)downloadByteSize);
        
        this.addDate = new Date(torrent.getAdded_on() * 1000);
        
        this.totalByteSize = torrent.getTotal_size();
        this.totalSizeStr = SpaceUnit.getDoubleSpaceAndUnit(totalByteSize);
        
        this.downAll = (torrent.getDownloaded() == torrent.getTotal_size() ? "已下完":"未下完");
        
        this.finishDate = new Date(torrent.getCompletion_on() * 1000);
        
        long downloadUseSecond = this.finishDate.getTime() - this.addDate.getTime()/1000;
        this.downloadHours = TimeUnit.getDoubleTimeAndUnitNoDay(downloadUseSecond);
        
        long existSecond = System.currentTimeMillis() - this.finishDate.getTime()/1000;
        this.existHours = TimeUnit.getDoubleTimeAndUnitNoDay(existSecond);
        
        
        this.path = torrent.getSave_path();
        
        this.srcSite = torrent.getTracker();
        this.activeSecond = torrent.getTime_active();

        System.out.println(path);
        System.out.println(torrent.getTime_active());
        System.out.println(torrent.getSeeding_time());
    }

    @Override
    public String toString() {
        return "TorrentVO [ \n	" + "name=" + name 
                + ",\n  cat=" + cat 
                + ",\n	downloadByteSize="+ downloadByteSize
                + ",\n  downloadSizeStr="+ downloadSizeStr
                
                + ",\n	uploadByteSize=" + uploadByteSize
                + ",\n  uploadsizeStr=" + uploadsizeStr
                
                + ",\n  uploadPrecent=" + uploadPrecent
                
                + ",\n	addDate=" + addDate
                
                + ",\n	totalSizeByte=" + totalByteSize
                + ",\n  totalSizeStr=" + totalSizeStr
                
                + ",\n  downAll=" + downAll
                
                + ",\n  finishDate=" + finishDate
                
                + ",\n  downloadHours=" + downloadHours
                
                + ",\n  existHours=" + existHours 
                
                + ",\n	path=" + path
                
                + ",\n	activeSecond=" + activeSecond
                
                + ",\n	siteUploadSize=" + siteUploadSize
                + ",\n	srcSite=" + srcSite 
                + " \n]";
    }

    /**
     * 表需要的数据
     * name,分类,downloadSize(G,M,KB),updateloadsize(G,M,KB),上传率,开始时间,总大小,是否完成下载,完成时间,下载用户,存在天数,做种时间,做种时间比,savepath,site1上传,site2上传.....
     */

}