package com.wejias.qb_tool.vo;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;


public class TorrentDto {
	private  Long    		amount_left;
	private  Long    		max_ratio;
	private  Boolean    	auto_tmm;
	private  Long    		seeding_time;
	private  Long    		trackers_count;
	private  Long    		availability;
	private  Long    		num_incomplete;
	private  Long    		seeding_time_limit;
	private  Boolean    	force_start;
	private  String    		save_path;
	private  Long    		num_seeds;
	private  Long    		dl_limit;
	private  Long    		eta;
	private  Long    		last_activity;
	private  Long    		num_leechs;
	private  Long    		num_complete;
	/**最后完整可见于*/
	private  Long    		seen_complete;
	private  String    		tracker;
	private  Long    		uploaded;
	/**完成于*/
	private  Long    		completion_on;
	private  Long    		ratio_limit;
	private  String    		state;
	/**添加于*/
	private  Long    		added_on;							
	private  Long    		time_active;
	/**总大小*/
	private  Long    		total_size;
	private  Boolean    	seq_dl;
	private  Long    		downloaded_session;
	/**已下载大小*/
	private  Long    		completed;
	private  Boolean    	f_l_piece_prio;
	private  Long    		priority;
	private  Boolean    	super_seeding;
	private  Long    		upspeed;
	private  Long    		downloaded;
	private  String    		tags;
	private  Long    		uploaded_session;
	private  Long    		size;
	private  Long    		up_limit;
	private  String    		magnet_uri;
	private  Long    		max_seeding_time;
	private  String    		name;
	private  String    		content_path;
	private  Long    		progress;
	private  String    		category;
	private  Long    		dlspeed;
	private  BigDecimal    	ratio;
	
	//字段太多，重新放一个类，只放需要的
//	private Date 			addDate;
	
	
	public Long getAmount_left() {
		return amount_left;
	}

	public void setAmount_left(Long amount_left) {
		this.amount_left = amount_left;
	}

	public Long getMax_ratio() {
		return max_ratio;
	}

	public void setMax_ratio(Long max_ratio) {
		this.max_ratio = max_ratio;
	}

	public Boolean getAuto_tmm() {
		return auto_tmm;
	}

	public void setAuto_tmm(Boolean auto_tmm) {
		this.auto_tmm = auto_tmm;
	}

	public Long getSeeding_time() {
		return seeding_time;
	}

	public void setSeeding_time(Long seeding_time) {
		this.seeding_time = seeding_time;
	}

	public Long getTrackers_count() {
		return trackers_count;
	}

	public void setTrackers_count(Long trackers_count) {
		this.trackers_count = trackers_count;
	}

	public Long getAvailability() {
		return availability;
	}

	public void setAvailability(Long availability) {
		this.availability = availability;
	}

	public Long getNum_incomplete() {
		return num_incomplete;
	}

	public void setNum_incomplete(Long num_incomplete) {
		this.num_incomplete = num_incomplete;
	}

	public Long getSeeding_time_limit() {
		return seeding_time_limit;
	}

	public void setSeeding_time_limit(Long seeding_time_limit) {
		this.seeding_time_limit = seeding_time_limit;
	}

	public Boolean getForce_start() {
		return force_start;
	}

	public void setForce_start(Boolean force_start) {
		this.force_start = force_start;
	}

	public String getSave_path() {
		return save_path;
	}

	public void setSave_path(String save_path) throws UnsupportedEncodingException {
		String pathGBK = new String(save_path.getBytes("ISO-8859-1"),"UTF-8");
		this.save_path = pathGBK;
	}

	public Long getNum_seeds() {
		return num_seeds;
	}

	public void setNum_seeds(Long num_seeds) {
		this.num_seeds = num_seeds;
	}

	public Long getDl_limit() {
		return dl_limit;
	}

	public void setDl_limit(Long dl_limit) {
		this.dl_limit = dl_limit;
	}

	public Long getEta() {
		return eta;
	}

	public void setEta(Long eta) {
		this.eta = eta;
	}

	public Long getLast_activity() {
		return last_activity;
	}

	public void setLast_activity(Long last_activity) {
		this.last_activity = last_activity;
	}

	public Long getNum_leechs() {
		return num_leechs;
	}

	public void setNum_leechs(Long num_leechs) {
		this.num_leechs = num_leechs;
	}

	public Long getNum_complete() {
		return num_complete;
	}

	public void setNum_complete(Long num_complete) {
		this.num_complete = num_complete;
	}

	public Long getSeen_complete() {
		return seen_complete;
	}

	public void setSeen_complete(Long seen_complete) {
		this.seen_complete = seen_complete;
	}

	public String getTracker() {
		return tracker;
	}

	public void setTracker(String tracker) {
		this.tracker = tracker;
	}

	public Long getUploaded() {
		return uploaded;
	}

	public void setUploaded(Long uploaded) {
		this.uploaded = uploaded;
	}

	public Long getCompletion_on() {
		return completion_on;
	}

	public void setCompletion_on(Long completion_on) {
		this.completion_on = completion_on;
	}

	public Long getRatio_limit() {
		return ratio_limit;
	}

	public void setRatio_limit(Long ratio_limit) {
		this.ratio_limit = ratio_limit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getAdded_on() {
		return added_on;
	}

	public void setAdded_on(Long added_on) {
		this.added_on = added_on;
	}

	public Long getTime_active() {
		return time_active;
	}

	public void setTime_active(Long time_active) {
		this.time_active = time_active;
	}

	public Long getTotal_size() {
		return total_size;
	}

	public void setTotal_size(Long total_size) {
		this.total_size = total_size;
	}

	public Boolean getSeq_dl() {
		return seq_dl;
	}

	public void setSeq_dl(Boolean seq_dl) {
		this.seq_dl = seq_dl;
	}

	public Long getDownloaded_session() {
		return downloaded_session;
	}

	public void setDownloaded_session(Long downloaded_session) {
		this.downloaded_session = downloaded_session;
	}

	public Long getCompleted() {
		return completed;
	}

	public void setCompleted(Long completed) {
		this.completed = completed;
	}

	public Boolean getF_l_piece_prio() {
		return f_l_piece_prio;
	}

	public void setF_l_piece_prio(Boolean f_l_piece_prio) {
		this.f_l_piece_prio = f_l_piece_prio;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Boolean getSuper_seeding() {
		return super_seeding;
	}

	public void setSuper_seeding(Boolean super_seeding) {
		this.super_seeding = super_seeding;
	}

	public Long getUpspeed() {
		return upspeed;
	}

	public void setUpspeed(Long upspeed) {
		this.upspeed = upspeed;
	}

	public Long getDownloaded() {
		return downloaded;
	}

	public void setDownloaded(Long downloaded) {
		this.downloaded = downloaded;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Long getUploaded_session() {
		return uploaded_session;
	}

	public void setUploaded_session(Long uploaded_session) {
		this.uploaded_session = uploaded_session;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getUp_limit() {
		return up_limit;
	}

	public void setUp_limit(Long up_limit) {
		this.up_limit = up_limit;
	}

	public String getMagnet_uri() {
		return magnet_uri;
	}

	public void setMagnet_uri(String magnet_uri) {
		this.magnet_uri = magnet_uri;
	}

	public Long getMax_seeding_time() {
		return max_seeding_time;
	}

	public void setMax_seeding_time(Long max_seeding_time) {
		this.max_seeding_time = max_seeding_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws UnsupportedEncodingException {
		String nameGBK = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		this.name = nameGBK;
	}

	public String getContent_path() {
		return content_path;
	}

	public void setContent_path(String content_path) throws UnsupportedEncodingException {
		String pathGBK = new String(content_path.getBytes("ISO-8859-1"),"UTF-8");
		this.content_path = pathGBK;
	}

	public Long getProgress() {
		return progress;
	}

	public void setProgress(Long progress) {
		this.progress = progress;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getDlspeed() {
		return dlspeed;
	}

	public void setDlspeed(Long dlspeed) {
		this.dlspeed = dlspeed;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	

	@Override
	public String toString() {
		return "Torrent [content_path=" + content_path + "]";
	}
	
	
}
