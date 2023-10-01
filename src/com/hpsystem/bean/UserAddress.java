package com.hpsystem.bean;

public class UserAddress {
	public int addressId;
	public String houseNumber;
	public String streetName;
	public String locality;
	public String mandal;
	public String district;
	public String state;
	public int pinCode;
	public int user_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public UserAddress(int addressId, String houseNumber, String streetName, String locality, String mandal,
			String district, String state, int pinCode) {
		super();
		this.addressId = addressId;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.locality = locality;
		this.mandal = mandal;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
	}
	public UserAddress() {
		// TODO Auto-generated constructor stub
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
}
