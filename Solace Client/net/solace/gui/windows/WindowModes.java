package net.solace.gui.windows;

import net.solace.gui.SolaceArt;
import net.solace.gui.SolaceButton;
import net.solace.gui.SolaceGuiWindow;
import net.solace.main.Variables;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class WindowModes extends SolaceGuiWindow {

	public WindowModes(int i, int j) {
		super(i, j, "Modes");
	}
	

	public void drawPanel(TrueTypeFont truetypefont) {
		buttonList.clear();
		super.drawPanel(truetypefont);
		int i = -7;
		int j = posY + 5;
        SolaceArt.drawString(truetypefont, "Chest ESP", posX + 3, j += 12, Variables.chestESP ? Color.green : Color.red);
        buttonList.add(new SolaceButton(1, getWidth() - 39, i += 12, Variables.chestESP));
        SolaceArt.drawString(truetypefont, "Player ESP", posX + 3, j += 12, Variables.tracer ? Color.green : Color.red);
        buttonList.add(new SolaceButton(2, getWidth() - 39, i += 12, Variables.tracer));
	}

	protected void actionPerformed(SolaceButton solaceButton) {
		if (solaceButton.id == 1) {
			Variables.chestESP = !Variables.chestESP;
		}
		if (solaceButton.id == 2) {
			Variables.tracer = !Variables.tracer;
		}
	}


	public int getWidth() {
		return 100;
	}

	public int getHeight() {
		return 100;
	}

}
