package net.solace.gui.windows;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Tessellator;
import net.solace.gui.SolaceArt;
import net.solace.gui.SolaceButton;
import net.solace.gui.SolaceGuiWindow;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class WindowValues extends SolaceGuiWindow {

	public WindowValues(int i, int j) {
		super(i, j, "Values");
	}

	public void drawPanel(TrueTypeFont truetypefont) {
		buttonList.clear();
		super.drawPanel(truetypefont);
		int i = -7;
		int j = posY + 5;
		SolaceArt.drawString(truetypefont, "Opacity", posX + 3, j += 13,
				Color.white);
		SolaceArt.drawString(truetypefont, "" + Tessellator.opacity, posX + 69,
				j, Color.white);
		buttonList.add(new SolaceButton(1, getWidth() - 50, i += 13, 9, 9,
				true, "<"));
		buttonList
				.add(new SolaceButton(2, getWidth() - 11, i, 9, 9, true, ">"));
	}

	protected void actionPerformed(SolaceButton solaceButton) {
		if (solaceButton.id == 1 && Tessellator.opacity > 25) {
			Tessellator.opacity -= 1;
			Minecraft.getMinecraft().sndManager.playSoundFX("random.click",
					1.0F, 1.0F);
		}
		if (solaceButton.id == 2 && Tessellator.opacity < 255) {
			Tessellator.opacity += 1;
			Minecraft.getMinecraft().sndManager.playSoundFX("random.click",
					1.0F, 1.0F);
		}
	}

	public int getWidth() {
		return 100;
	}

	public int getHeight() {
		return 86;
	}

}
