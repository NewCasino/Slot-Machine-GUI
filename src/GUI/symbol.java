package src.GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class symbol implements Isymbol {

	ImageIcon img = new ImageIcon();
	int value = 0;

	@Override
	public void setImage(String location, String name) {
		img = createImageIcon(location, name);

	}

	public ImageIcon createImageIcon(String location, String name) {
		java.net.URL imgURL = getClass().getResource(location);
		if (imgURL != null) {
			return new ImageIcon(imgURL, name);
		} else {
			System.err.println("Couldn't find file: " + location);
			return null;
		}

	}

	@Override
	public ImageIcon getImage() {
		return img;
	}

	@Override
	public void setValue(int value1) {
		value = value1;

	}

	@Override
	public int getValue() {
		return value;
	}

}
