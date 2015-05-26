package com.FOEVERGOD73.Objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.FOEVERGOD73.Core.SpriteSheet;

public class Score extends GameObject {
	SpriteSheet ss;
	StringBuilder stringBuilder;
	BufferedImage output;
	public static HashMap<Character, Point> letterPos = new HashMap<Character, Point>();
	
	public Score(int x, int y, StringBuilder text, SpriteSheet ss){
		this.x = x;
		this.y = y;
		this.stringBuilder = text;
		this.ss = ss;
		load();
	}
	
	public void render(Graphics g) {
		output = new BufferedImage(stringBuilder.length() * ss.getSubImgWidth(), ss.getSubImgHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = output.getGraphics();
		for(int i = 0; i < stringBuilder.length(); i ++){
			Point p = letterPos.get(stringBuilder.charAt(i));
			graphics.drawImage(ss.getSubImage(p.x, p.y).getImg(), i * ss.getSubImgWidth(), 0, ss.getSubImgWidth(), ss.getSubImgHeight(), null);
		}
		g.drawImage(output, (int)x, (int)y, output.getWidth(), output.getHeight(), null);
	}
	
	private static void load(){
		letterPos.put('a', new Point(1, 1));
		letterPos.put('b', new Point(2, 1));
		letterPos.put('c', new Point(3, 1));
		letterPos.put('d', new Point(4, 1));
		letterPos.put('e', new Point(5, 1));
		letterPos.put('f', new Point(6, 1));
		letterPos.put('g', new Point(1, 2));
		letterPos.put('h', new Point(2, 2));
		letterPos.put('i', new Point(3, 2));
		letterPos.put('j', new Point(4, 2));
		letterPos.put('k', new Point(5, 2));
		letterPos.put('l', new Point(6, 2));
		letterPos.put('m', new Point(1, 2));
		letterPos.put('n', new Point(2, 3));
		letterPos.put('o', new Point(3, 3));
		letterPos.put('p', new Point(4, 3));
		letterPos.put('q', new Point(5, 3));
		letterPos.put('r', new Point(6, 3));
		letterPos.put('s', new Point(1, 4));
		letterPos.put('t', new Point(2, 4));
		letterPos.put('u', new Point(3, 4));
		letterPos.put('v', new Point(4, 4));
		letterPos.put('w', new Point(5, 4));
		letterPos.put('x', new Point(6, 4));
		letterPos.put('y', new Point(1, 5));
		letterPos.put('z', new Point(2, 5));
		letterPos.put('0', new Point(3, 5));
		letterPos.put('1', new Point(4, 5));
		letterPos.put('2', new Point(5, 5));
		letterPos.put('3', new Point(6, 5));
		letterPos.put('4', new Point(1, 6));
		letterPos.put('5', new Point(2, 6));
		letterPos.put('6', new Point(3, 6));
		letterPos.put('7', new Point(4, 6));
		letterPos.put('8', new Point(5, 6));
		letterPos.put('9', new Point(6, 6));
		letterPos.put('+', new Point(1, 7));
		letterPos.put('-', new Point(2, 7));
		letterPos.put('*', new Point(3, 7));
		letterPos.put('/', new Point(4, 7));
		letterPos.put('_', new Point(5, 7));
		letterPos.put('%', new Point(6, 7));
	}
}
