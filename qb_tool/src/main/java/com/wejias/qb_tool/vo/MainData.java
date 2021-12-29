package com.wejias.qb_tool.vo;

import java.util.List;
import java.util.Map;

public class MainData {
	private int 										rid;
	private boolean 									full_update;
	private List<Map<String, Category>> 				categories;
	private List<Map<String, Object>> 					server_state;
	private List<Map<String, Object>> 					tags; 							// 暂时不用,不进一步解析
	private List<Map<String, Object>> 					trackers; 						// 暂时不用,不进一步解析
	private List<Map<String, TorrentDto>> 					torrents;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public boolean isFull_update() {
		return full_update;
	}

	public void setFull_update(boolean full_update) {
		this.full_update = full_update;
	}

	public List<Map<String, Category>> getCategories() {
		return categories;
	}

	public void setCategories(List<Map<String, Category>> categories) {
		this.categories = categories;
	}

	public List<Map<String, Object>> getServer_state() {
		return server_state;
	}

	public void setServer_state(List<Map<String, Object>> server_state) {
		this.server_state = server_state;
	}

	public List<Map<String, Object>> getTags() {
		return tags;
	}

	public void setTags(List<Map<String, Object>> tags) {
		this.tags = tags;
	}

	public List<Map<String, TorrentDto>> getTorrents() {
		return torrents;
	}

	public void setTorrents(List<Map<String, TorrentDto>> torrents) {
		this.torrents = torrents;
	}

	public List<Map<String, Object>> getTrackers() {
		return trackers;
	}

	public void setTrackers(List<Map<String, Object>> trackers) {
		this.trackers = trackers;
	}

}
