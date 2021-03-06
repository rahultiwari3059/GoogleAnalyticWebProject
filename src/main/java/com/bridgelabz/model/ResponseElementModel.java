package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ResponseElementModel {
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
	public String mGaId=null;
	@Column
	public String mGAdiscription=null;
	
	public int mMetricSize;
	@Column
	public String mDate=null;
	@Column
	public String mAndroidId=null;
	
	public String mConnectionType=null;
	@Column
	public String mEventCategory=null;
	@Column
	public String mTotalEvents=null;
	public String mSessions=null;
	public String mScreenViews=null;
	public String mExit=null;
	public String mExitRate=null;
	
	public int mrowArraySize;
	 
	public String getmGAdiscription() {
		return mGAdiscription;
	}
	public void setmGAdiscription(String mGAdiscription) {
		this.mGAdiscription = mGAdiscription;
	}
	public int mDimensionSize;
	public int getmDimensionSize() {
		return mDimensionSize;
	}
	public void setmDimensionSize(int mDimensionSize) {
		this.mDimensionSize = mDimensionSize;
	}
	public int getmMetricSize() {
		return mMetricSize;
	}
	public void setmMetricSize(int mMetricSize) {
		this.mMetricSize = mMetricSize;
	}
	
	public int getMrowArraySize() {
		return mrowArraySize;
	}
	public void setMrowArraySize(int mrowArraySize) {
		this.mrowArraySize = mrowArraySize;
	}
	public String getmGaId() {
		return mGaId;
	}
	public void setmGaId(String mGaId) {
		this.mGaId = mGaId;
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
	

}
