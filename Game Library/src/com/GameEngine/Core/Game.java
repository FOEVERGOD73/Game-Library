package com.GameEngine.Core;

import java.awt.Graphics;

import com.GameEngine.Objects.GameObject;

public abstract class Game {
	private GameObject rootObject;
	
	public Game(){
		setRootObject(new GameObject());
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics g);
	public void renderForeground(Graphics g){}
	
	public void tickh(){
		rootObject.tickh();
		tick();
	}
	public void renderh(Graphics g){
		render(g);
		rootObject.renderh(g);
		renderForeground(g);
	}

	public GameObject getRootObject() {
		return rootObject;
	}

	public void setRootObject(GameObject rootObject) {
		this.rootObject = rootObject;
	}
}
