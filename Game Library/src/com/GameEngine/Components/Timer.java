package com.GameEngine.Components;

public class Timer extends GameComponent{
	private float time, countDown;
	private boolean repeat, running = true;
	
	public Timer(String name, float time){
		this(name, time, true);
	}
	
	public Timer(String name, float time, boolean repeat){
		this(name, time, time, repeat);
	}
	
	public Timer(String name, float time, float start, boolean repeat){
		super(name);
		this.time = time;
		this.countDown = start;
		this.repeat = repeat;
	}

	public void tick() {
		if(running){
			if(countDown > 0)
				countDown --;
			else{
				parent.callBack(name);
				if(repeat)
					countDown = time;
				else
					running = false;
			}
		}
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
	
}
