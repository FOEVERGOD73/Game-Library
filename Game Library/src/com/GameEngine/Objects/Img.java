package com.GameEngine.Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Img extends GameObject{
	private BufferedImage img;

	public Img(int x, int y, int width, int height, BufferedImage img) {
		super(x, y, width, height);
		this.img = img;
	}
	
	public void render(Graphics g){
		g.drawImage(img, (int)x, (int)y, (int)width, (int)height, null);
	}
}
