package com.GameEngine.Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.GameEngine.Components.Clickable;
import com.GameEngine.Core.Input;

public class Button extends GameObject{
	public int x, y, width, height, mouseCode;
	public BufferedImage def, hover, pressed;
	
	public Button(String name, int x, int y, int width, int height, int mouseCode, BufferedImage def, BufferedImage hover, BufferedImage pressed){
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.def = def;
		this.hover = hover;
		this.pressed = pressed;
		this.mouseCode = mouseCode;
		addComponent(new Clickable("button", x, y, width, height, mouseCode));
	}
	
	public void render(Graphics g){
		if(Input.MousePos() != null && Input.MousePos().x > x && Input.MousePos().x < (x + width) && Input.MousePos().y > y && Input.MousePos().y < (y + height)){
			if(Input.getInstance().isMouseDown(mouseCode)){
				if(pressed != null)
					g.drawImage(pressed, x, y, width, height, null);
				else
					g.drawImage(def, x, y, width, height, null);
			}else if(hover != null){
				g.drawImage(hover, x, y, width, height, null);
			}else{
				g.drawImage(def, x, y, width, height, null);
			}
		}else{
			g.drawImage(def, x, y, width, height, null);
		}
	}
	
	public void callBack(String name, String... string){
		getParent().callBack(this.name);
	}
}
