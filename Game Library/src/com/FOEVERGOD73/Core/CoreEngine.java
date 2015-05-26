package com.FOEVERGOD73.Core;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.FOEVERGOD73.Util.FrameInfo;

public class CoreEngine extends Canvas implements Runnable  {

	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	
	private Game game;
	private BufferStrategy bufferStrategy;
	private Thread thread;
	private FPS fps;
	private Window window;
	public static int WIDTH, HEIGHT;
	public static int multiplier;
	
	public CoreEngine(FrameInfo info, String name, int multiplier, Game game){	
		WIDTH = info.width * multiplier;
		HEIGHT = info.height * multiplier;
		CoreEngine.multiplier = multiplier;
		setWindow(new Window(info.width * multiplier, info.height * multiplier, name, info.autostart, this));
		
		this.setGame(game);
		
		fps = new FPS();
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() throws InterruptedException{
		if(!running)
			return;
		running = false;
		thread.join();
	}
	
	public void run() {
		init();
		this.requestFocus();
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
				getGame().tickh();
				Input.getInstance().tick();
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
		addMouseListener(Input.getInstance());
		addKeyListener(Input.getInstance());
		game.init();
	}
	
	private void render(){
		bufferStrategy = this.getBufferStrategy();
		if (bufferStrategy == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bufferStrategy.getDrawGraphics();
		// //////////////////////////////////////////////////////////////////
		getGame().renderh(g);
		// //////////////////////////////////////////////////////////////////
		g.dispose();
		bufferStrategy.show();
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
