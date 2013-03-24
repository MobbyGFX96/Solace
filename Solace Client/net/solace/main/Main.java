package net.solace.main;

import java.awt.Dimension;

import org.darkstorm.minecraft.gui.GuiManagerImpl;
import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.component.basic.BasicButton;
import org.darkstorm.minecraft.gui.component.basic.BasicComboBox;
import org.darkstorm.minecraft.gui.component.basic.BasicFrame;
import org.darkstorm.minecraft.gui.component.basic.BasicLabel;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

public class Main {
	
	public static GuiManagerImpl guiManager;
	public static SimpleTheme theme = new SimpleTheme();
	
	public Main() {
		guiManager = new GuiManagerImpl();
		guiManager.setTheme(theme);
		guiManager.setup();
		initiateFrame();
	}
	
	public static void initiateFrame() {
		Frame testFrame = new BasicFrame("Test");
		testFrame.setTheme(theme);
		testFrame.add(new BasicLabel("TEST LOL"));
		testFrame.add(new BasicLabel("abcdefghijklmnopqrstuvwxyz"));
		testFrame.add(new BasicButton("This is a button, you can press it!"));
		testFrame.add(new BasicComboBox("This", "is", "a", "combo", "box"));
		Dimension defaultDimension = theme.getUIForComponent(testFrame).getDefaultSize(testFrame);
		testFrame.setWidth(defaultDimension.width);
		testFrame.setHeight(defaultDimension.height);
		testFrame.layoutChildren();
		guiManager.addFrame(testFrame);
	}
	
}
