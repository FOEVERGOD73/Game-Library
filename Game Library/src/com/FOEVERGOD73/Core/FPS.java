package com.FOEVERGOD73.Core;

public class FPS {
	private int updates, frames;

	public FPS(int updates, int frames) {
		this.updates = updates;
		this.frames = frames;
	}

	public FPS() {
	}

	public int getFrames() {
		return frames;
	}

	public void setFrames(int frames) {
		this.frames = frames;
	}

	public int getUpdates() {
		return updates;
	}

	public void setUpdates(int updates) {
		this.updates = updates;
	}
	
	
	public void set(int updates, int frames){
		this.updates = updates;
		this.frames = frames;
	}
}
