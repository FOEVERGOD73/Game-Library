package com.FOEVERGOD73.Core;

import com.FOEVERGOD73.Util.FrameInfo;

public class CoreEngine implements Runnable  {
	
	private boolean running = false;
	
	private Game game;
	private Thread thread;
	private FPS fps;
	private Window window;
	public static int WIDTH, HEIGHT;
	public static int multiplier;
	private RenderEngine renderEngine;
	private TickEngine tickEngine;
	private int layers;
	
	public CoreEngine(FrameInfo info, String name, int multiplier, Game game, int layers){	
		WIDTH = info.width;
		HEIGHT = info.height;
		CoreEngine.multiplier = multiplier;
		
		this.setGame(game);
		this.layers = layers;
		
		fps = new FPS();
		
		renderEngine = new RenderEngine(this.layers, game);
		tickEngine = new TickEngine(game);
		setWindow(new Window(info.width, info.height, name, info.autostart, renderEngine, this));
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		renderEngine.start();
		tickEngine.start();
	}
	
	public synchronized void stop() throws InterruptedException{
		if(!running)
			return;
		running = false;
		thread.join();
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				render();
				updates++;
				delta--;
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				getFps().set(updates, frames);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void init(){
		Input.window = window;
		game.init();
	}
	
	private void tick(){
		Semaphores.tickFrames.release();

	}
	
	private void render(){
		Semaphores.renderFrames.release();
	}

	public FPS getFps() {
		return fps;
	}

	public void setFps(FPS fps) {
		this.fps = fps;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
