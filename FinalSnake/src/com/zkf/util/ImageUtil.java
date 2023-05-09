/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.util;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageUtil {
	
	public static ImageIcon getImageIcon(String fileName) {
		return new ImageIcon(fileName);
	}

	public static Image getImage(String fileName) {
		return getImageIcon(fileName).getImage();
	}
}
