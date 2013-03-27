package net.solace.hacks;

import net.solace.main.Hack;
import net.solace.main.Variables;

import org.lwjgl.input.Keyboard;

public class FullBright extends Hack {

	public String getName() {
		return "Brightness";
	}

	public int getColour() {
		return 0xFF8C00;
	}

	public int getKeybind() {
		return Keyboard.KEY_B;
	}

	public void onEnabled() {
		
	}

	public void onDisable() {
		
	}

	public boolean isEnabled() {
		return Variables.fullBright;
	}

	public void toggle() {
		Variables.fullBright = !Variables.fullBright;
	}

}
