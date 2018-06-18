package org.yogiyo.app.service.domain;

public class UserVO {
	private int userId;
	private String userAddress;
	private String userPassword;
	private String userPhone;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userAddress=" + userAddress + ", userPassword=" + userPassword
				+ ", userPhone=" + userPhone + "]";
	}
}
