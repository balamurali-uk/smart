package com.ofs.model;

public class AdvertisedInfo {
	
	private String uuid;
	private String min;
	private String max;
	private byte[] mediaData;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public byte[] getMediaData() {
		return mediaData;
	}
	public void setMediaData(byte[] mediaData) {
		this.mediaData = mediaData;
	}
}
