package net.solace.gui.windows;

import net.minecraft.client.Minecraft;
import net.solace.gui.SolaceArt;
import net.solace.gui.SolaceButton;
import net.solace.gui.SolaceGuiWindow;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class WindowInfo extends SolaceGuiWindow {

	public WindowInfo(int i, int j) {
		super(i, j, "Info");
	}

	public void drawPanel(TrueTypeFont truetypefont) {
		buttonList.clear();
		super.drawPanel(truetypefont);
		int i = posX + 2;
		int j = posY + 16;
		SolaceArt.drawString(infoFont, "" + Minecraft.debugFPS + " FPS", i, j,
				Color.white);
		double playerX = Math.round(Minecraft.thePlayer.posX);
		double playerY = Math.round(Minecraft.thePlayer.posY);
		double playerZ = Math.round(Minecraft.thePlayer.posZ);
		SolaceArt.drawString(infoFont, "X: " + (int) playerX, i, j += 12,
				Color.white);
		SolaceArt.drawString(infoFont, "Y: " + (int) playerY, i, j += 12,
				Color.white);
		SolaceArt.drawString(infoFont, "Z: " + (int) playerZ, i, j += 12,
				Color.white);
		SolaceArt.drawString(infoFont, ""
				+ Minecraft.getMinecraft().session.username, i, j += 12,
				Color.blue);
	}

	protected void actionPerformed(SolaceButton solaceButton) {
	}

	public int getWidth() {
		return 100;
	}

	public int getHeight() {
		return 75;
	}

}
