package com.comingo.domain;

public class OrgInfo {
	private String orgId;
	
	private UserInfo userInfo;

	private String orgDesc;
	private String leader;
	private String leaderMobile;
	private String authImg1;
	private String authImg2;
	private int activateState;
	private int verifyState;

	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getLeaderMobile() {
		return leaderMobile;
	}

	public void setLeaderMobile(String leaderMobile) {
		this.leaderMobile = leaderMobile;
	}

	public String getAuthImg1() {
		return authImg1;
	}

	public void setAuthImg1(String authImg1) {
		this.authImg1 = authImg1;
	}

	public String getAuthImg2() {
		return authImg2;
	}

	public void setAuthImg2(String authImg2) {
		this.authImg2 = authImg2;
	}

	public int getActivateState() {
		return activateState;
	}

	public void setActivateState(int activateState) {
		this.activateState = activateState;
	}

	public int getVerifyState() {
		return verifyState;
	}

	public void setVerifyState(int verifyState) {
		this.verifyState = verifyState;
	}

}
