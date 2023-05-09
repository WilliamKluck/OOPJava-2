/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.zkf.po.Barrier;
import com.zkf.po.Food;
import com.zkf.po.Snake;
import com.zkf.util.Config;
import com.zkf.util.ImageUtil;

//game panel ; 
public class SnakePanel extends JPanel implements KeyListener{
	Image bg_game = ImageUtil.getImage("img/bg_game.jpg");
	//create food
	Food food = new Food();
	//create object
	Snake snake = new Snake(food);
	//Create Snake Thread Object
	SnakeThread snakeThread = new SnakeThread();
	//food
	Barrier barrier1=new Barrier(3,5);//row 3-6 col 5-8
	Barrier barrier2=new Barrier(16,5);//row 16-19 col 5-8 
	Barrier barrier3=new Barrier(3,27);//row 3-6 col 27-30
	Barrier barrier4=new Barrier(16,27);//row16-19  col 27-30
	

	
	public SnakePanel() {
		
		initpanel();
	
		this.addKeyListener(this);
		//Start Snake Thread
		snakeThread.start();
	}

	
	private void initpanel() {
		//setting position 
		this.setBounds(0, 0, 700, 440);
		//setting background color 
		this.setBackground(Color.YELLOW);
	}
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	
		g.drawImage(bg_game, 0, 0, this);
		
		food.draw(g);
		
		snake.draw(g);
		
		barrier1.draw(g);
		barrier2.draw(g);
		barrier3.draw(g);
		barrier4.draw(g);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString("SCORE:"+Config.score, 10, 30);
	}
	
	class SnakeThread extends Thread{
		boolean flag = true;
		public void run() {
			super.run();
		while(Config.isLive && flag) {
			try {
		
			Thread.sleep(Config.SleepTime);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(Config.isGone) {
				snake.move();
				repaint();
			}
	
		}
		if(!Config.isLive) {
			JOptionPane.showMessageDialog(SnakePanel.this, "Game over, do it again");
			
		}
		}
	}

	public void keyTyped(KeyEvent e) {
		System.out.println(1);
	}
	
	public void keyPressed(KeyEvent e) {

		snake.dirControl(e);
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	
}
