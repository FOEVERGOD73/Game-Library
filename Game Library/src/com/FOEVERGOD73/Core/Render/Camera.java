package com.FOEVERGOD73.Core.Render;

import com.FOEVERGOD73.Core.Base.CoreEngine;
import com.FOEVERGOD73.Objects.GameObject;

/**
 * Set the target of the Camera instance with the setCameraTarget method.
 * Also use the xOffset and yOffset to specify the offset of the target from the center of the screen
 */
public class Camera {
	public static final Camera instance = new Camera();

	private double x = 0, y = 0;
	private double xoffset, yoffset;
	private boolean xlock, ylock;
	private GameObject cameraTarget = null;

	private Camera() {
	}

	public void tick() {
		if (cameraTarget != null) {
			if (!xlock)
				x = (-cameraTarget.getX() + CoreEngine.WIDTH / 2) + xoffset;
			if (!ylock)
				y = (-cameraTarget.getY() + CoreEngine.HEIGHT / 2) + yoffset;
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
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

	public double getXoffset() {
		return xoffset;
	}

	public void setXoffset(double xoffset) {
		this.xoffset = xoffset;
	}

	public double getYoffset() {
		return yoffset;
	}

	public void setYoffset(double yoffset) {
		this.yoffset = yoffset;
	}
}
