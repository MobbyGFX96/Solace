package net.solace.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Gui;

public class SolaceButton extends Gui {
	
	protected int width;
	protected int height;
	public int xPosition;
	public int yPosition;
	public String displayString;
	public int id;
	public boolean enabled;
	public boolean drawButton;
	private boolean enabledisable;

	public SolaceButton(int i, int j, int k, boolean flag) {
		this(i, j, k, 37, 10, flag, flag ? "Disable" : "Enable");
	}

	public SolaceButton(int i, int j, int k, int l, int i1, boolean flag,
			String s) {
		width = 50;
		height = 20;
		enabled = true;
		drawButton = true;
		id = i;
		xPosition = j;
		yPosition = k;
		width = l;
		height = i1;
		displayString = s;
		enabledisable = flag;
	}

	protected int getHoverState(boolean flag) {
		byte byte0 = 1;

		if (!enabled) {
			byte0 = 0;
		} else if (flag) {
			byte0 = 2;
		}

		return byte0;
	}

	public void drawButton(Minecraft minecraft, int i, int j, int k, int l) {
		if (!drawButton) {
			return;
		} else {
			boolean flag = i >= xPosition && j >= yPosition
					&& i < xPosition + width && j < yPosition + height;
			// net.minecraft.src.FontRenderer fontrenderer =
			// minecraft.fontRenderer;
			SolaceArt.drawButton(k + xPosition, l + yPosition, k + xPosition
					+ width, l + yPosition + height, 0x70585858, 0xff5e5e5e,
					SolaceGuiWindow.font5, displayString);
			mouseDragged(minecraft, i, j, k, l);
			return;
		}
	}

	protected void mouseDragged(Minecraft minecraft, int i, int j, int k, int l) {
	}

	public void mouseReleased(int i, int j) {
	}

	public boolean mousePressed(Minecraft minecraft, int i, int j, int k, int l) {
		return i >= k + xPosition && i <= k + xPosition + width
				&& j >= l + yPosition && j <= l + yPosition + height;
	}
}
