package net.solace.gui;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.src.GuiScreen;
import net.solace.gui.windows.WindowInfo;
import net.solace.gui.windows.WindowKillAura;
import net.solace.gui.windows.WindowValues;

public class SolaceGui extends GuiScreen {
	
	public static ArrayList<SolaceGuiWindow> windows;

	public SolaceGui() {
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int i, int j, float f) {
		drawDefaultBackground();
		for (int k = windows.size(); k > 0; k--) {
			if (((SolaceGuiWindow) windows.get(k - 1)).isOpen()) {
				((SolaceGuiWindow) windows.get(k - 1)).drawScreen(i, j, f);
			}
		}
		SolaceArt.drawRect(2, 2, 200, 200, 0xffffff);
		super.drawScreen(i, j, f);
	}

	/**
	 * Called when the mouse is clicked.
	 */
	protected void mouseClicked(int i, int j, int k) {
		label0: {
			super.mouseClicked(i, j, k);

			if (k != 0) {
				break label0;
			}

			Iterator iterator = windows.iterator();
			SolaceGuiWindow SolaceGuiWindow;

			do {
				if (!iterator.hasNext()) {
					break label0;
				}

				SolaceGuiWindow = (SolaceGuiWindow) iterator.next();
			} while (!SolaceGuiWindow.mouseClick(i, j, k));

			windows.remove(SolaceGuiWindow);
			windows.add(0, SolaceGuiWindow);
		}
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	public void updateScreen() {
		SolaceGuiWindow SolaceGuiWindow;

		for (Iterator iterator = windows.iterator(); iterator.hasNext(); SolaceGuiWindow
				.updateScreen()) {
			SolaceGuiWindow = (SolaceGuiWindow) iterator.next();
		}
	}

	/**
	 * Called when the mouse is moved or a mouse button is released. Signature:
	 * (mouseX, mouseY, which) which==-1 is mouseMove, which==0 or which==1 is
	 * mouseUp
	 */
	public void initGui() {
	}

	public void mouseMovedOrUp(int i, int j, int k) {
		super.mouseMovedOrUp(i, j, k);
		SolaceGuiWindow SolaceGuiWindow;

		for (Iterator iterator = windows.iterator(); iterator.hasNext(); SolaceGuiWindow
				.mouseMovedOrUp(i, j, k)) {
			SolaceGuiWindow = (SolaceGuiWindow) iterator.next();
		}
	}

	/**
	 * Fired when a key is typed. This is the equivalent of
	 * KeyListener.keyTyped(KeyEvent e).
	 */
	protected void keyTyped(char c, int i) {
		SolaceGuiWindow SolaceGuiWindow;

		for (Iterator iterator = windows.iterator(); iterator.hasNext(); SolaceGuiWindow
				.keyTyped(c, i)) {
			SolaceGuiWindow = (SolaceGuiWindow) iterator.next();
		}

		if (i == 1) {
			mc.displayGuiScreen(null);
		}
	}

	static {
		windows = new ArrayList<SolaceGuiWindow>();
		windows.add(new WindowKillAura(2, 2));
		windows.add(new WindowInfo(110, 2));
		windows.add(new WindowValues(110 + 108, 2));
	}
}
