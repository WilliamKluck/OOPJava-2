/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.po;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.JPanel;

import com.zkf.util.Config;
import com.zkf.util.ImageUtil;

public class Food implements ImageObserver {
	Image bg_food;
	
	private int row;
	
	private int col;
	
	public Food() {
		
		initComponents();
		repair();
	}

	private void initComponents() {
		java.util.Random rand = new java.util.Random();
		int guess = rand.nextInt(3);
		switch(guess) {
		case 1: bg_food=ImageUtil.getImage("img/food1.png"); break;
		case 2: bg_food=ImageUtil.getImage("img/food2.png"); break;
		default: bg_food=ImageUtil.getImage("img/food3.png"); break;
		}
	}


	public void repair() {
		int x=new Random().nextInt(Config.ROWS);
		int y=new Random().nextInt(Config.CLOS);
		
		if(x>=2&&x<=6&&y<=8&&y>=4) {
			return;
		}
		if(x>=14&&x<=20&&y<=8&&y>=4) {
			return;
		}
		if(x>=2&x<=6&&y<=30&&y>=25) {
			return;
		}
		if(x>=14&&x<=20&&y<=30&&y>=25) {
			return;
		}
		initComponents();
		row=x;
		col=y;
		
			
	}

	public void draw(Graphics g) {
		g.drawImage(bg_food, col*Config.SPAN,row*Config.SPAN,Config.SPAN, Config.SPAN, this);
	}
	
	public Rectangle getRect() {
		return new Rectangle(col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN);
	}
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
	

}