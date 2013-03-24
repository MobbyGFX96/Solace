package net.solace.hacks;

import org.lwjgl.input.Keyboard;

import net.solace.main.Hack;

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
		
	}

	public boolean isEnabled() {
		return vars.ChestESP;
	}

}
