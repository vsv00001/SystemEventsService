package com.example.sysevents.entity;

import java.util.Date;

public class SysEvent {
	String id;
	Date createdAt;
	String type;
	String source;
	String details;

	public SysEvent() {

	}

	public SysEvent(String id, Date createdAt, String type, String source, String details) {
		this.id = id;
		this.createdAt = createdAt;
		this.type = type;
		this.source = source;
		this.details = details;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
