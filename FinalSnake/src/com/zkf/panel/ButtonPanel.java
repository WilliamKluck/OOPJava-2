/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.zkf.panel.SnakePanel.SnakeThread;
import com.zkf.po.Food;
import com.zkf.po.Snake;
import com.zkf.util.Config;

//game page
public class ButtonPanel extends JPanel implements ActionListener{
	
	//key attribute
	JButton btn_pause;//pause
	JButton btn_continue;//continuue
	JButton btn_restart;//restart
	
	SnakePanel snakePanel;
	public ButtonPanel(SnakePanel snakePanel) {
		this.snakePanel = snakePanel;
		//panel information
		initpanel();
		
		initComponents();
		
		addComponents();
		
	}
	private void initComponents() {
		//3 keys
		btn_pause = new JButton("Pause Game");
		btn_continue = new JButton("Continue");
		btn_restart = new JButton("Restart ");
		//follow key
		btn_pause.addActionListener(this);
		btn_continue.addActionListener(this);
		btn_restart.addActionListener(this);
	}
	private void addComponents() {
		this.add(btn_pause);
		this.add(btn_continue);
		this.add(btn_restart);
	}
	
	private void initpanel() {
		this.setBounds(0, 440, 700, 60);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn_pause) {
			gamePause();
		}
		if(e.getSource() == btn_continue) {
			gameContinue();
		}
		if(e.getSource() == btn_restart) {
			gameRestart();
		}
	}
	
	private void gameRestart() {
		//How to restart 
		//1.Stop the current Snake thread
		snakePanel.snakeThread.flag = false;
		
		Config.rescore();
		Config.reSleeptime();
		
		//2.The original snake and food disappear, create new food
		Food food = new Food();
		snakePanel.food = food;
		snakePanel.snake = new Snake(food);
		Config.reload();
		
		//Create a new Snake moving thread
		SnakeThread snakeThread =snakePanel. new SnakeThread();
		snakeThread.start();
		snakePanel.snakeThread = snakeThread;
		
		snakePanel.setFocusable(true);
		snakePanel.requestFocus();
		
		
	}
	private void gameContinue() {
		Config.isGone = true;
		snakePanel.setFocusable(true);
		snakePanel.requestFocus();
	}
	private void gamePause() {
		Config.isGone = false;
	}
}
