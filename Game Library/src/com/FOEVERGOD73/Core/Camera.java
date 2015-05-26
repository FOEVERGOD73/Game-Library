package com.FOEVERGOD73.Core;

import com.FOEVERGOD73.Objects.GameObject;

public class Camera {

	private double x = 0, y = 0;
	private double xoffset, yoffset;
	private boolean xlock, ylock;
	public Camera(float xoffset, float yoffset){
	this.xoffset = xoffset;
	this.yoffset = yoffset;
	}
	
	public void tick(GameObject cameraTarget){
		if(!xlock)
			x = (-cameraTarget.getX() + CoreEngine.WIDTH/2) + xoffset;
		if(!ylock)
			y = (-cameraTarget.getY() + CoreEngine.HEIGHT/2)+ yoffset;
	}
	
	
 public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public boolean isYlock() {
		return ylock;
	}

	public void setYlock(boolean ylock) {
		this.ylock = ylock;
	}

	public boolean isXlock() {
		return xlock;
	}

	public void setXlock(boolean xlock) {
		this.xlock = xlock;
	}
}
