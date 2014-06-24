package com.example.hello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class PongGame extends JFrame {
	private Ball ball;
	private Thread gameLoop;

	public PongGame() {
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		ball = new Ball(this, getWidth() / 2, getHeight() / 2, 6, 6, 10);
		gameLoop = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					update();
					repaint();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		gameLoop.start();
	}

	public void update() {
		ball.update();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, getWidth(), getHeight());
		ball.draw(g2);
	}
}
