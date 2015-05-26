package com.FOEVERGOD73.Core;

import java.awt.Graphics;

import com.FOEVERGOD73.Objects.GameObject;

public abstract class Game {
	private GameObject rootObject;
	
	public Game(){
		setRootObject(new GameObject());
	}
	
	public abstract void init();
	public abstract void preTick();
	public abstract void postTick();
	public abstract void preRender(Graphics[] g);
	public abstract void postRender(Graphics[] g);
	
	public void tick(){
		preTick();
		rootObject.tick();
		postTick();
	}
	public void render(Graphics[] g){
		preRender(g);
		rootObject.render(g);
		postRender(g);
	}

	public GameObject getRootObject() {
		return rootObject;
	}

	public void setRootObject(GameObject rootObject) {
		this.rootObject = rootObject;
	}
}
