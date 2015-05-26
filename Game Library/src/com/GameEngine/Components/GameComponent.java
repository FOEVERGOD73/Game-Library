package com.GameEngine.Components;

import java.awt.Graphics;

import com.GameEngine.Core.Nameable;
import com.GameEngine.Objects.GameObject;

public abstract class GameComponent extends Nameable{
	protected GameObject parent;
	
	public GameComponent(String name){
		this.name = name;
	}

	public abstract void tick();
	public void render(Graphics g){}
	
	
	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
	}
}
