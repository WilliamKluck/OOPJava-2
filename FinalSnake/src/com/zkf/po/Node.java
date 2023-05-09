/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.po;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import com.zkf.util.Config;
import com.zkf.util.ImageUtil;

//Snake's Split Node
public class Node implements ImageObserver {
	
	Image bg_headl;
	Image bg_headr;
	Image bg_headu;
	Image bg_headd;
	Image bg_body;
	
	
	Image bg_game=ImageUtil.getImage("img/bg_game.jpg");
	int row;//Row
	int col;//List
	String dir;//forward
	
	
	
	Node next;//next node
	Node pre;//last node

	
	
	//Construction of basic information
	public Node(int row, int col, String dir) {
		super();
		this.row = row;
		this.col = col;
		this.dir = dir;
		
		initComponents();
		
	}


	private void initComponents() {
		bg_headl=ImageUtil.getImage("img/left.jpg");
		bg_headr=ImageUtil.getImage("img/right.jpg");
		bg_headu=ImageUtil.getImage("img/up.jpg");
		bg_headd=ImageUtil.getImage("img/down.jpg");
		bg_body=ImageUtil.getImage("img/food.jpg");
	}


	public void draw(Graphics g) {
		
		//Color and background matching of snake head and body
		g.setColor(Color.blue);
		g.fillOval(col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN);
		if(pre==null&&dir.equals( Config.LEFT)) {
			//head
		g.drawImage(bg_headl,col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN, this);}
		if(pre==null&&dir.equals( Config.RIGHT)) {
			//head
		g.drawImage(bg_headr,col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN, this);}
		if(pre==null&&dir.equals( Config.UP)) {
		//head
		g.drawImage(bg_headu,col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN, this);}
	if(pre==null&&dir.equals( Config.DOWN)) {
			//head
		g.drawImage(bg_headd,col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN, this);}
	}
		

	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}