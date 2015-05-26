package com.GameEngine.Core;

public class Random extends java.util.Random{

	private static final long serialVersionUID = 1L;

	public int nextInt(int min, int max){
		return (nextInt((max - min) + 1) + min);
	}
	
	public boolean chance(int precentage){
		if(nextInt(100) < precentage)
			return true;
		else
			return false;
	}
}
