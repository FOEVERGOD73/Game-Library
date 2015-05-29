package com.FOEVERGOD73.Core.Render;

import java.awt.image.BufferedImage;

import com.FOEVERGOD73.Core.Base.CoreEngine;
import com.FOEVERGOD73.Util.BufferedImageLoader;

public class Texture {
	private BufferedImage img;
	private int width, height;
	
	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Texture(BufferedImage img, int multiplier){
		this.img = img;
		this.width = img.getWidth() * CoreEngine.multiplier * multiplier;
		this.height = img.getHeight() * CoreEngine.multiplier * multiplier;
	}

	public Texture(BufferedImage img){
		this(img, 1);
	}
	
	public Texture(String fileName, int multiplier){
		this(new BufferedImageLoader().loadImage(fileName), multiplier);
	}
	
	public Texture(String fileName){
		this(fileName, 1);
	}
}
