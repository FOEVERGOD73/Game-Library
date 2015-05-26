package com.GameEngine.Components;

import com.GameEngine.Core.Input;

public class Clickable extends GameComponent {
	
	private int x, y, width, height;
	private int mouseCode;
	
	
	public Clickable(String name, int x, int y, int width, int height, int mouseCode) {
		super(name);
		this.x = x;
		this.y = y;
		this.mouseCode = mouseCode;
		this.width = width;
		this.height = height;
	}
	
	public void tick() {
		if(Input.getInstance().mouseReleased(mouseCode))
			if(Input.MousePos() != null)
				if(Input.MousePos().x > x && Input.MousePos().x < (x + width) && Input.MousePos().y > y && Input.MousePos().y < (y + height))
					parent.callBack(name, Input.Mouse_Left_Release);
	}
}
