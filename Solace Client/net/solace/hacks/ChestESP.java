package net.solace.hacks;

import net.solace.main.Hack;
import net.solace.main.Variables;

import org.lwjgl.input.Keyboard;

public class ChestESP extends Hack {

	public String getName() {
		return "Chest ESP";
	}

	public int getColour() {
		return 0x00ff00;
	}

	public int getKeybind() {
		return Keyboard.KEY_C;
	}

	public void onEnabled() {
		mc.thePlayer.addChatMessage("[Solace] - Enabled "+getName());
	}

	public boolean isEnabled() {
		return Variables.chestESP;
	}

	public void onDisable() {
		mc.thePlayer.addChatMessage("[Solace] - Disabled "+getName());
	}

	public void toggle() {
		Variables.chestESP = !Variables.chestESP;
	}

}
