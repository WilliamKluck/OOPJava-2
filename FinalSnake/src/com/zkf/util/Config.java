/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.util;

public class Config {
	
	public static final int ROWS = 22; 
	public static final int CLOS = 35;
	public static final int SPAN = 20; 
	
	public static final String UP = "u";
	public static final String DOWN = "d";
	public static final String LEFT = "l";
	public static final String RIGHT = "r";
	
	public static boolean isLive = true;
	public static boolean isGone = true;
	
	public static void reload() {
		isLive = true;
		isGone = true;
	}
	
	public static int SleepTime = 200;
	public static int score = 0;
	
	public static void reSleeptime() {
		SleepTime = 200;
	}

	public static void rescore() {
		score = 0;
	}
	
}	
