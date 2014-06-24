package com.example.hello;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
	private PongGame pongGame;
	private int x, y;
	private int vx, vy;
	private int radius;

	public Ball(PongGame pongGame, int x, int y, int vx, int vy, int radius) {
		this.pongGame = pongGame;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.radius = radius;
	}

	public void update() {
		move();
		checkBorder();
	}

	public void move() {
		x += vx;
		y += vy;
	}

	public void draw(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.fillOval(x, y, this.radius * 2, this.radius * 2);
	}

	private void checkBorder() {
		if (x < radius) {
			x = radius;
			vx = -vx;
		} else if (x + radius > pongGame.getWidth()) {
			x = pongGame.getWidth() - radius;
			vx = -vx;
		}

		if (y < radius) {
			y = radius;
			vy = -vy;
		} else if (y + radius > pongGame.getHeight()) {
			y = pongGame.getHeight() - radius;
			vy = -vy;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVx() {
		return vx;
	}

	public int getVy() {
		return vy;
	}

	public int getRadius() {
		return radius;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
