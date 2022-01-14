package com.wejias.qb_tool.vo;

import java.util.Date;
import java.util.Map;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.wejias.qb_tool.constant.SiteInfo;
import com.wejias.qb_tool.constant.SpaceUnit;
import com.wejias.qb_tool.constant.TimeUnit;
import com.wejias.qb_tool.constant.TrackerInfo;
import com.wejias.qb_tool.helper.CustomBooleanConverter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TorrentVO {
    @ExcelProperty(value = "名称")
    public String                               name;
    @ExcelProperty(value = "分类")
    public String                               cat;
    @ExcelProperty(value = "下载")
    public String                               downloadSizeStr;            // unit:(G,M,KB)
    @ExcelProperty(value = "总上传")
    public String                               uploadsizeStr;              // unit:(G,M,KB)
    @ExcelProperty(value = "上传率")
    public Double                               uploadPrecent;              // 上传率
    @ExcelProperty(value = "开始时间")
    public Date                                 addDate;
    @ExcelProperty(value = "总大小")
    public String                               totalSizeStr;               // unit:(G,M,KB)
    @ExcelProperty(value = "是否下载完成",converter = CustomBooleanConverter.class)
    public boolean                              downAll;                    // 是/否,任何一个site下载完成,就是下载完成了.
    @ExcelProperty(value = "完成时间")
    public Date                                 finishDate;
    @ExcelProperty(value = "下载耗时")
    public String                               downloadHours;              // 下载用时,unit:hour
    @ExcelProperty(value = "存活时间")
    public String                               existHours;                 // 存在天数,unit:hour
    @ExcelProperty(value = "活动时间")
    public String                               activeHours;
    @ExcelProperty(value = "活动率")
    public Double                               activePrecent;              // 做种时间比率
    @ExcelProperty(value = "存放路径")
    public String                               path;

    @ExcelIgnore
    public Map<String, Long>                   siteUploadSize;
    @ExcelIgnore
    public String                              site;

    // temp
    @ExcelProperty({"总大小(B)"})
    public long                                totalByteSize;
    @ExcelProperty({"下载大小(B)"})
    public long                                downloadByteSize;
    @ExcelProperty({"上传大小(B)"})
    public long                                uploadByteSize;
    @ExcelProperty({"活动时间(秒)"})
    public long                                activeSecond;
    @ExcelIgnore
    public long                                existSecond;
    
    public void calStrField() {
      this.downloadSizeStr = SpaceUnit.getDoubleSpaceAndUnit(this.downloadByteSize);
        
      this.uploadsizeStr = SpaceUnit.getDoubleSpaceAndUnit(this.uploadByteSize);
      
      this.uploadPrecent = ((double)uploadByteSize/(double)downloadByteSize);
      String valueTemp = String.format("%.2f", this.uploadPrecent);
      this.uploadPrecent = Double.valueOf(valueTemp);
      
      
      this.totalSizeStr = SpaceUnit.getDoubleSpaceAndUnit(totalByteSize);
      
      this.activeHours =  TimeUnit.getDoubleTimeAndUnitNoDay(activeSecond);
      
      this.activePrecent = ((double)activeSecond/(double)existSecond);
      valueTemp = String.format("%.2f", this.activePrecent);
      this.activePrecent = Double.valueOf(valueTemp);
    }
    
    
    /**
     * 表需要的数据
     * name,分类,downloadSize(G,M,KB),updateloadsize(G,M,KB),上传率,开始时间,总大小,是否完成下载,完成时间,下载用时,存在时数,做种时数,做种时间比,savepath,site1上传,site2上传.....
     */  
    public TorrentVO(String rid,TorrentDto torrent) {
        this.name = torrent.getName();
        this.cat = torrent.getCategory();
        
        this.downloadByteSize = torrent.getDownloaded();
        this.uploadByteSize = torrent.getUploaded();
        this.totalByteSize = torrent.getTotal_size();
        
        this.addDate = new Date(torrent.getAdded_on() * 1000);
        this.finishDate = new Date(torrent.getCompletion_on() * 1000);
        
        this.downAll = torrent.getDownloaded() >= torrent.getTotal_size();
        
        long downloadUseSecond = (this.finishDate.getTime() - this.addDate.getTime())/1000;
        this.downloadHours = TimeUnit.getDoubleTimeAndUnitNoDay(downloadUseSecond);
        
        this.existSecond = (System.currentTimeMillis() - this.finishDate.getTime())/1000;
        this.existHours = TimeUnit.getDoubleTimeAndUnitNoDay(existSecond);
        
        this.activeSecond = torrent.getTime_active();
        
        this.path = torrent.getSave_path();
        
        String tracker = torrent.getTracker();
        if(tracker == null || tracker.equals("")) {
            tracker = TrackerInfo.getTrackerURL(rid);
        }
        this.site = SiteInfo.getSiteName(tracker);
    }

    /**
     * 表需要的数据
     * name,分类,downloadSize(G,M,KB),updateloadsize(G,M,KB),上传率,开始时间,总大小,是否完成下载,完成时间,下载用时,存在时数,做种时数,做种时间比,savepath,site1上传,site2上传.....
     */  
    
    @Override
    public String toString() {
        return "TorrentVO [ "
                + "\n  name=" + name 
                + ",\n  cat=" + cat 
                + ",\n  downloadByteSize="+ downloadByteSize
                + ",\n  downloadSizeStr="+ downloadSizeStr
                + ",\n  uploadByteSize=" + uploadByteSize
                + ",\n  uploadsizeStr=" + uploadsizeStr
                + ",\n  uploadPrecent=" + uploadPrecent
                
                + ",\n  addDate=" + addDate
                + ",\n  totalSizeByte=" + totalByteSize
                + ",\n  totalSizeStr=" + totalSizeStr
                + ",\n  downAll=" + downAll
                + ",\n  finishDate=" + finishDate
                + ",\n  downloadHours=" + downloadHours
                + ",\n  existHours=" + existHours
                + ",\n  activeSecond=" + activeSecond 
                + ",\n  activeHours=" + activeHours
                + ",\n  activePrecent=" + activePrecent
                + ",\n  path=" + path
                
                + ",\n  siteUploadSize=" + siteUploadSize
                + ",\n  site=" + site 
                + " \n]";
    }

    /**
     * 表需要的数据
     * name,分类,downloadSize(G,M,KB),updateloadsize(G,M,KB),上传率,开始时间,总大小,是否完成下载,完成时间,下载用户,存在天数,做种时间,做种时间比,savepath,site1上传,site2上传.....
     */
    

}