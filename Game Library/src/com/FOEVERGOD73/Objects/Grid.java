package com.FOEVERGOD73.Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.FOEVERGOD73.Components.Clickable;
import com.FOEVERGOD73.Util.Input;

public class Grid extends GameObject{
	public int x, y;
	public int width, height;
	public int col, row;
	public BufferedImage img;
	
	public Grid(String name, int x, int y, int width, int height, int col, int row, int cellWidth, int cellHeight) {
		this(x, y, width, height, col, row, cellWidth, cellHeight, 0, 0, 0, 0, Input.MOUSE_LEFT, null);
		this.name = name;
	}
	
	public Grid(int x, int y, int width, int height, int col, int row, int cellWidth, int cellHeight, int cellHorizontalGap, int cellVerticalGap, int mouseCode, int topEdge, int leftEdge, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.col = col;
		this.row = row;
		this.img = img;
		for(int c = 0; c < col; c ++)
			for(int r = 0; r < row; r ++)
				addComponent(new Clickable(c + " " + r, (c * (cellWidth + cellHorizontalGap)) + x + leftEdge, (r * (cellHeight + cellVerticalGap)) + y + topEdge, cellWidth, cellHeight, mouseCode));
	}
	
	public void render(Graphics g) {
		if(img != null)
			g.drawImage(img, x, y, width, height, null);
	}
	
	public void tick(){

	}
	
	public void callBack(String name, String... args){
		getParent().callBack(this.name, name);
	}
}
