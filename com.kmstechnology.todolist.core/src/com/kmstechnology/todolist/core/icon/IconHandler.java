package com.kmstechnology.todolist.core.icon;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class IconHandler {
    private static final String RESOURCES_LOCATION = "/icons";

    public static Image getIcon(String icon) {
        String imageName = RESOURCES_LOCATION + "/" + icon + ".png";

        InputStream resourceStream = IconHandler.class.getResourceAsStream(imageName);
        return new Image(Display.getDefault(), resourceStream);
    }
}
