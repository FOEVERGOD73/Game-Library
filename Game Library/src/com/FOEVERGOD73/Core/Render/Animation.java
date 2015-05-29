package com.FOEVERGOD73.Core.Render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.FOEVERGOD73.Core.Base.CoreEngine;
import com.FOEVERGOD73.Objects.GameObject;

public class Animation {
	private int speed;
	private int frames;
	
	private int index = 0;
	private int count = 0;
	
	private boolean running = false;
	
	private GameObject obj;
	
	private BufferedImage[] images;
	private BufferedImage currentImg;
	
	private boolean first = true;
	
	public Animation(int speed, GameObject obj, BufferedImage... args) {
		this.setSpeed(speed);
		images = new BufferedImage[args.length];
		for (int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
		this.obj = obj;
		nextFrame();
	}
	
	public Animation(int speed, BufferedImage... args) {
		this.setSpeed(speed);
		images = new BufferedImage[args.length];
		for (int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
		nextFrame();
	}
	
	public Animation(int speed, boolean flip, GameObject obj, BufferedImage... args) {
		if (flip) {
			this.setSpeed(speed);
			images = new BufferedImage[(args.length * 2) - 2];
			for (int i = 0; i < args.length; i++) {
				images[i] = args[i];
			}
			BufferedImage[] temp = new BufferedImage[args.length - 2];
			for (int i = args.length - 2; i > 0; i--) {
				temp[args.length - i - 2] = images[i];
			}
			for (int i = args.length; i < images.length; i++) {
				images[i] = temp[i - args.length];
			}
			frames = images.length;
		} else {
			this.setSpeed(speed);
			images = new BufferedImage[args.length];
			for (int i = 0; i < args.length; i++) {
				images[i] = args[i];
			}
			frames = args.length;
		}
		this.obj = obj;
		nextFrame();
	}
	public Animation(int speed, boolean flip, BufferedImage... args) {
		if (flip) {
			this.setSpeed(speed);
			images = new BufferedImage[(args.length * 2) - 2];
			for (int i = 0; i < args.length; i++) {
				images[i] = args[i];
			}
			BufferedImage[] temp = new BufferedImage[args.length - 2];
			for (int i = args.length - 2; i > 0; i--) {
				temp[args.length - i - 2] = images[i];
			}
			for (int i = args.length; i < images.length; i++) {
				images[i] = temp[i - args.length];
			}
			frames = images.length;
		} else {
			this.setSpeed(speed);
			images = new BufferedImage[args.length];
			for (int i = 0; i < args.length; i++) {
				images[i] = args[i];
			}
			frames = args.length;
		}
		nextFrame();
	}
	
	public void runAnimation() {
		if (running) {
			index++;
			if (index > getSpeed()) {
				index = 0;
				nextFrame();
			}
		}else{
			index = 0;
		}
	}
	
	private void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i)
				currentImg = images[i];
		}
		
		count++;
		
		if (count >= frames)
			count = 0;
		
		if(!first)
		obj.callBack("frame");
		else
			first = false;
	}
	
	public void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(currentImg, x, y, currentImg.getWidth() * CoreEngine.multiplier, currentImg.getHeight() * CoreEngine.multiplier, null);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void start() {
		running = true;
	}
	
	public void stop() {
		running = false;
	}
}
