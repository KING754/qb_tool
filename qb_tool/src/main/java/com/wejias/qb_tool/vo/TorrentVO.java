package com.wejias.qb_tool.vo;

import java.util.Date;
import java.util.Map;

public class TorrentVO {
	private String 						path;
	private Date						addDate;
	private Date 						finishDate;
	private long 						sizeNum;
	private long						completedSize;
	private long 						uploadSizeNum;
	private Map<String, Double> 		siteUploadSize;
	private String 						srcSite;
	private long 						activeHours;
	private String						cat;

	private String name;
	private String uploadSize;
	private String size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public long getSizeNum() {
		return sizeNum;
	}

	public void setSizeNum(long sizeNum) {
		this.sizeNum = sizeNum;
	}

	public long getUploadSizeNum() {
		return uploadSizeNum;
	}

	public void setUploadSizeNum(long uploadSizeNum) {
		this.uploadSizeNum = uploadSizeNum;
	}

	public String getUploadSize() {
		return uploadSize;
	}

	public void setUploadSize(String uploadSize) {
		this.uploadSize = uploadSize;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Map<String, Double> getSiteUploadSize() {
		return siteUploadSize;
	}

	public void setSiteUploadSize(Map<String, Double> siteUploadSize) {
		this.siteUploadSize = siteUploadSize;
	}

	public String getSrcSite() {
		return srcSite;
	}

	public void setSrcSite(String srcSite) {
		this.srcSite = srcSite;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getActiveHours() {
		return activeHours;
	}

	public void setActiveHours(long activeHours) {
		this.activeHours = activeHours;
	}
	
	


	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public TorrentVO(TorrentDto torrent) {
		this.path = torrent.getContent_path();
		this.addDate =  new Date(torrent.getAdded_on() * 1000);
		this.finishDate = new Date(torrent.getCompletion_on() * 1000);
		this.sizeNum = torrent.getTotal_size();
		this.completedSize = torrent.getDownloaded();
		this.uploadSizeNum = torrent.getUploaded();
		this.srcSite = torrent.getTracker();
		this.activeHours = torrent.getTime_active();
		this.cat = torrent.getCategory();
		
		System.out.println(path);
		System.out.println(torrent.getTime_active());
		System.out.println(torrent.getSeeding_time());
	}

	@Override
	public String toString() {
		return "TorrentVO [ \n	"
				+ "name=" + name 
				+ ",\n	finishDate=" + finishDate
				+ ",\n	addDate=" + addDate
				+ ",\n	totalSize=" + ((double)sizeNum/1024.0/1024.0) 
				+ ",\n	downloadSize=" + ((double)completedSize/1024.0/1024.0)
				+ ",\n	uploadSize=" + ((double)uploadSizeNum/1024.0/1024.0)
				+ ",\n	siteUploadSize=" + siteUploadSize 
				+ ",\n	srcSite=" + srcSite 
				+ ",\n	path=" + path
				+ ",\n	activeHours=" + activeHours/60/60/24 
				+ ",\n	cat=" + cat 
				+ " \n]";
	}

}