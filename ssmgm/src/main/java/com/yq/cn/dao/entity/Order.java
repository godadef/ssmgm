package com.yq.cn.dao.entity;

public class Order {
    private Long id;

    private String address;

    private String phone;

    private Long userId;
    
    private String code;
    
    private String telnumber;
    
    private String branchnumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getBranchnumber() {
		return branchnumber;
	}

	public void setBranchnumber(String branchnumber) {
		this.branchnumber = branchnumber;
	}
    
    
}