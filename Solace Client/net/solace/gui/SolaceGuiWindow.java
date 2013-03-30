package net.solace.gui;

import java.awt.Font;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiScreen;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public abstract class SolaceGuiWindow extends GuiScreen {
	public String title;
	public boolean enabled;
	public static boolean stuck;
	public boolean open;
	public boolean focused;
	public boolean dragging;
	public int posX;
	public int posY;
	public int pointX;
	public int pointY;
	protected java.util.List<SolaceButton> buttonList;
	protected java.util.List<GuiCustomSlider> sliderList;
	private SolaceButton selectedButton;
	public TrueTypeFont font3;
	public TrueTypeFont font1;
	public static TrueTypeFont font4 = new TrueTypeFont(new Font(
			"Lucida Console", Font.TRUETYPE_FONT, 18), true); // - and +#
	public static TrueTypeFont infoFont = new TrueTypeFont(new Font("Verdana",
			Font.BOLD, 18), true); // - and +
	public static TrueTypeFont font2 = new TrueTypeFont(new Font(
			"Lucida Console", Font.PLAIN, 19), true); // title
	public static TrueTypeFont font5 = new TrueTypeFont(new Font(
			"Lucida Sans Typewriter", Font.PLAIN, 16), true); // buttons
	private Minecraft mc;

	public SolaceGuiWindow(int i, int j, String s) {
		font3 = new TrueTypeFont(new Font("Lucida Console", Font.PLAIN, 20),
				true);
		font1 = new TrueTypeFont(new Font("Lucida Sans Typewriter", Font.PLAIN,
				16), true);
		posX = i;
		posY = j;
		title = s;
		buttonList = new ArrayList<SolaceButton>();
		sliderList = new ArrayList<GuiCustomSlider>();
		open = true;
	}

	public void drawScreen(int i, int j, float k) {
		mouseDragged(i, j);
		if (open) {
			draw(font2);
			if (enabled) {
				for (int k1 = 0; k1 < buttonList.size(); k1++) {
					SolaceButton solaceButton = buttonList.get(k1);
					solaceButton.drawButton(mc, posX + i, posY + j, posX,
							posY + 12);
				}
				for (int l = 0; l < sliderList.size(); l++) {
					GuiCustomSlider slider = sliderList.get(l);
					slider.mouseDragged(mc, i, j);
				}
			}
		}
	}

	public void draw(TrueTypeFont ttf) {
		drawHeader(ttf);
		if (enabled) {
			drawPanel(font1);
		}
	}

	public void drawHeader(TrueTypeFont truetypefont) {
		SolaceArt.drawString(font3, "", posX + 1, posY + 1, Color.white);
		SolaceArt.drawBRect(posX, posY, posX + getWidth(), posY + 13,
				0xbb363636, 0xff5e5e5e);
		SolaceArt.drawString(truetypefont, title, posX + 3, posY + 2,
				Color.white);
		SolaceArt.drawBRect(posX + getWidth() - 11, posY + 2, posX + getWidth()
				- 2, posY + 11, 0xbb585858, 0xff5e5e5e);
		//SolaceArt.drawBRect(posX + getWidth() - 23, posY + 2, posX + getWidth()
		//		- 14, posY + 11, 0xbb585858, 0xff5e5e5e);
		SolaceArt.drawButtonString(font3, enabled ? "-" : "+", (float) posX
				+ getWidth() - 9.65F, posY + 1.25F, Color.white);
	}

	public void drawPanel(TrueTypeFont truetypefont) {
		SolaceArt.drawBRect(posX, posY + 15, posX + getWidth(), posY + 15
				+ getHeight() - 12, 0xcc363636, 0xff5e5e5e);
	}

	public boolean mouseClick(int i, int j, int k) {
		if (checkBounds(posX + i, posY + j, posX + getWidth() - 12, posY + 1,
				posX + getWidth() - 2, posY + 10)) {
			enabled = !enabled;
			return true;
		}

		//if (checkBounds(posX + i, posY + j, posX + getWidth() - 23, posY + 2,
		//		posX + getWidth() - 14, posY + 11)) {
		//	stuck = !stuck;
		//}

		if (checkBounds(posX + i, posY + j, posX, posY, posX + getWidth(),
				posY + 11)) {
			dragging = true;
			pointX = i;
			pointY = j;
		}

		for (int l = 0; l < buttonList.size(); l++) {
			SolaceButton solaceButton = (SolaceButton) buttonList.get(l);

			if (solaceButton.mousePressed(mc, i, j, posX, posY + 12)) {
				selectedButton = solaceButton;
				actionPerformed(solaceButton);
			}
		}

		buttonClick(posX + i, posY + j, k);
		return checkBounds(posX + i, posY + j, posX, posY, posX + getWidth(),
				enabled ? posY + getHeight() : posY + 11);
	}

	public void updateScreen() {
	}

	public void buttonClick(int i, int j, int k) {
	}

	public void mouseMovedOrUp(int i, int j, int k) {
		if (k == 0) {
			dragging = false;
		}

		if (selectedButton != null && k == 0) {
			selectedButton.mouseReleased(i + posX, j + posY);
			selectedButton = null;
		}
	}

	public void mouseDragged(int i, int j) {
		if (dragging) {
			posX += i - pointX;
			posY += j - pointY;
			pointX = i;
			pointY = j;
		}
	}

	public void keyTyped(char c, int i) {
	}

	public boolean isOpen() {
		return open;
	}

	public void toggle() {
		open = !open;
	}

	protected void actionPerformed(SolaceButton solaceButton) {
	}

	public boolean checkBounds(int i, int j, int k, int l, int i1, int j1) {
		return i >= posX + k && i <= posX + i1 && j >= posY + l
				&& j <= posY + j1;
	}

	public abstract int getWidth();

	public abstract int getHeight();

}
