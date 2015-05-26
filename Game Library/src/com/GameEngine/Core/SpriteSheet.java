package com.GameEngine.Core;

import java.awt.image.BufferedImage;

import com.GameEngine.Util.BufferedImageLoader;

public class SpriteSheet {

	private BufferedImage img;
	private int width, height;
	private int subImgWidth, subImgHeight;
	
	public SpriteSheet(BufferedImage img){
		this(img, 1);
	}
	
	public SpriteSheet(BufferedImage img, int multiplier){
		this(img, 0, 0, 1);
	}
	
	public SpriteSheet(String fileName){
		this(fileName, 1);
	}

	public SpriteSheet(String fileName, int multiplier){
		this(new BufferedImageLoader().loadImage(fileName), 1);
	}
	
	public SpriteSheet(String fileName,  int subImgWidth, int subImgHeight){
		this(fileName, subImgWidth, subImgHeight, 1);
	}
	
	public SpriteSheet(String fileName,  int subImgWidth, int subImgHeight, int multiplier){
		this(new BufferedImageLoader().loadImage(fileName), subImgWidth, subImgHeight, multiplier);
	}
	
	public SpriteSheet(BufferedImage img, int subImgWidth, int subImgHeight){
		this(img, subImgWidth, subImgHeight, 1);
	}
	
	public SpriteSheet(BufferedImage img, int subImgWidth, int subImgHeight, int multiplier){
		this.img = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
		this.subImgWidth = subImgWidth;
		this.subImgHeight = subImgHeight;
	}
	
	public Texture[][] getAllImages(){
		Texture[][] temp = new Texture[(width/subImgWidth)][(height/subImgHeight)];
		for(int col = 0; col < (width/subImgWidth); col ++)
			for(int row = 0; row < (height/subImgHeight); row ++)
				temp[col][row] = getSubImage(col, row);
		return temp;
	}
	
	public Texture getSubImage(int col, int row){
		if(subImgWidth == 0|| subImgHeight == 0){
			Exception e = new Exception();
			System.err.println("ERROR: Width Or Height Not Initilized");
			e.printStackTrace();
			System.exit(1);
		}
		return new Texture(img.getSubimage((col *subImgWidth) - subImgWidth, (row * subImgHeight) - subImgHeight, subImgWidth, subImgHeight));
	}
	
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

	public int getSubImgWidth() {
		return subImgWidth * CoreEngine.multiplier;
	}

	public void setSubImgWidth(int subImgWidth) {
		this.subImgWidth = subImgWidth;
	}

	public int getSubImgHeight() {
		return subImgHeight * CoreEngine.multiplier;
	}

	public void setSubImgHeight(int subImgHeight) {
		this.subImgHeight = subImgHeight;
	}
}
