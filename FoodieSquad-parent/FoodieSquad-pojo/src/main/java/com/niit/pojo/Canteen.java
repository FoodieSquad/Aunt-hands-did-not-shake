package com.niit.pojo;

public class Canteen {
    private Integer canteenId;

    private String canteenName;

    private String canteenTele;

    private String canteenAddress;

    public Integer getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }

    public Canteen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Canteen(Integer canteenId, String canteenName, String canteenTele, String canteenAddress) {
		super();
		this.canteenId = canteenId;
		this.canteenName = canteenName;
		this.canteenTele = canteenTele;
		this.canteenAddress = canteenAddress;
	}

	public String getCanteenTele() {
        return canteenTele;
    }

    public void setCanteenTele(String canteenTele) {
        this.canteenTele = canteenTele;
    }

    public String getCanteenAddress() {
        return canteenAddress;
    }

    public void setCanteenAddress(String canteenAddress) {
        this.canteenAddress = canteenAddress;
    }
}