package com.niit.pojo;

public class Deliver {
    private Integer deliverId;

    private String deliverName;

    private String deliverTele;

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public Deliver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deliver(Integer deliverId, String deliverName, String deliverTele) {
		super();
		this.deliverId = deliverId;
		this.deliverName = deliverName;
		this.deliverTele = deliverTele;
	}

	public String getDeliverTele() {
        return deliverTele;
    }

    public void setDeliverTele(String deliverTele) {
        this.deliverTele = deliverTele;
    }
}