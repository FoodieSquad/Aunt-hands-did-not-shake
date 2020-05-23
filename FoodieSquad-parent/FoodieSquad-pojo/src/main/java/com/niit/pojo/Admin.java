package com.niit.pojo;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminTele;

    private String adminPass;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer adminId, String adminName, String adminTele, String adminPass) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminTele = adminTele;
		this.adminPass = adminPass;
	}

	public String getAdminTele() {
        return adminTele;
    }

    public void setAdminTele(String adminTele) {
        this.adminTele = adminTele;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }
}