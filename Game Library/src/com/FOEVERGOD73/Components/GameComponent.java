package com.FOEVERGOD73.Components;

import java.awt.Graphics;

import com.FOEVERGOD73.Core.Nameable;
import com.FOEVERGOD73.Objects.GameObject;

public abstract class GameComponent extends Nameable{
	protected GameObject parent;
	
	public GameComponent(String name){
		this.name = name;
	}

	public abstract void tick();
	public void render(Graphics[] g){}
	
	
	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
	}
}
