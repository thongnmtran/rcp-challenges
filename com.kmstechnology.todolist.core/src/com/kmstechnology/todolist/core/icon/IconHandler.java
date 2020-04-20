package com.kmstechnology.todolist.core.icon;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class IconHandler {
	private static Path path;
	static {
		try {
			URL location = IconHandler.class.getProtectionDomain().getCodeSource().getLocation();
			path = Paths.get(location.toURI()).resolve("../com.kmstechnology.todolist.core/icons");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public static Image getIcon(String icon) {
		String imageName = icon + ".png";
		return new Image(Display.getDefault(), path.resolve(imageName).toString());
	}
}
