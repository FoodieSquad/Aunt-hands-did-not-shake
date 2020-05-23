package com.niit.pojo;

public class Window {
    private Integer windowId;

    private String windowName;

    private String windowDescription;

    private Integer canteenId;

    public Integer getWindowId() {
        return windowId;
    }

    public void setWindowId(Integer windowId) {
        this.windowId = windowId;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }

    public String getWindowDescription() {
        return windowDescription;
    }

    public void setWindowDescription(String windowDescription) {
        this.windowDescription = windowDescription;
    }

    public Window(Integer windowId, String windowName, String windowDescription, Integer canteenId) {
		super();
		this.windowId = windowId;
		this.windowName = windowName;
		this.windowDescription = windowDescription;
		this.canteenId = canteenId;
	}

	public Window() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
    }
}