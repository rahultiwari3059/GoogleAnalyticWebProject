package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AppOpenModel {
	@Id
	@GeneratedValue
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	private String mGaId=null;
	@Column
	private String mGAdiscription=null;
	private int mMetricSize;
	@Column
	private String mDate=null;
	@Column
	private String mAndroidId=null;
	@Column
	private String mConnectionType=null;
	@Column
	private String mEventCategory=null;
	@Column
	private String mTotalEvents=null;
	private String mSessions=null;
	private String mScreenViews=null;

	public String getmGaId() {
		return mGaId;
	}
	public void setmGaId(String mGaId) {
		this.mGaId = mGaId;
	}
	public String getmGAdiscription() {
		return mGAdiscription;
	}
	public void setmGAdiscription(String mGAdiscription) {
		this.mGAdiscription = mGAdiscription;
	}
	public int getmMetricSize() {
		return mMetricSize;
	}
	public void setmMetricSize(int mMetricSize) {
		this.mMetricSize = mMetricSize;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public String getmAndroidId() {
		return mAndroidId;
	}
	public void setmAndroidId(String mAndroidId) {
		this.mAndroidId = mAndroidId;
	}
	public String getmConnectionType() {
		return mConnectionType;
	}
	public void setmConnectionType(String mConnectionType) {
		this.mConnectionType = mConnectionType;
	}
	public String getmEventCategory() {
		return mEventCategory;
	}
	public void setmEventCategory(String mEventCategory) {
		this.mEventCategory = mEventCategory;
	}
	public String getmTotalEvents() {
		return mTotalEvents;
	}
	public void setmTotalEvents(String mTotalEvents) {
		this.mTotalEvents = mTotalEvents;
	}
	public String getmSessions() {
		return mSessions;
	}
	public void setmSessions(String mSessions) {
		this.mSessions = mSessions;
	}
	public String getmScreenViews() {
		return mScreenViews;
	}
	public void setmScreenViews(String mScreenViews) {
		this.mScreenViews = mScreenViews;
	}
	public String getmExit() {
		return mExit;
	}
	public void setmExit(String mExit) {
		this.mExit = mExit;
	}
	public String getmExitRate() {
		return mExitRate;
	}
	public void setmExitRate(String mExitRate) {
		this.mExitRate = mExitRate;
	}
	public int getMrowArraySize() {
		return mrowArraySize;
	}
	public void setMrowArraySize(int mrowArraySize) {
		this.mrowArraySize = mrowArraySize;
	}
	private	 String mExit=null;
	private String mExitRate=null;
	private int mrowArraySize;

}
