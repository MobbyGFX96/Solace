package net.solace.gui.windows;

import net.minecraft.src.Tessellator;
import net.solace.gui.GuiCustomSlider;
import net.solace.gui.SolaceArt;
import net.solace.gui.SolaceButton;
import net.solace.gui.SolaceGuiWindow;
import net.solace.main.Variables;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class WindowKillAura extends SolaceGuiWindow {

	public WindowKillAura(int i, int j) {
		super(i, j, "Kill Aura");
	}

	public void drawPanel(TrueTypeFont truetypefont) {
		buttonList.clear();
		super.drawPanel(truetypefont);
		int i = -7;
		int j = posY + 5;
		SolaceArt.drawString(truetypefont, "Player", posX + 3, j += 12,
				Variables.killAura ? Color.green : Color.red);
		buttonList.add(new SolaceButton(1, getWidth() - 39, i += 12,
				Variables.killAura));
		SolaceArt.drawString(truetypefont, "Animal", posX + 3, j += 12,
				Variables.killAuraAnimal ? Color.green : Color.red);
		buttonList.add(new SolaceButton(2, getWidth() - 39, i += 12,
				Variables.killAuraAnimal));
		SolaceArt.drawString(truetypefont, "Aimbot", posX + 3, j += 12,
				Variables.lookAtPlayer ? Color.green : Color.red);
		buttonList.add(new SolaceButton(3, getWidth() - 39, i += 12,
				Variables.lookAtPlayer));
	}

	protected void actionPerformed(SolaceButton solaceButton) {
		if (solaceButton.id == 1) {
			Variables.killAura = !Variables.killAura;
		}
		if (solaceButton.id == 2) {
			Variables.killAuraAnimal = !Variables.killAuraAnimal;
		}
		if (solaceButton.id == 3) {
			Variables.lookAtPlayer = !Variables.lookAtPlayer;
		}
	}

	public int getWidth() {
		return 100;
	}

	public int getHeight() {
		return 100;
	}

}
