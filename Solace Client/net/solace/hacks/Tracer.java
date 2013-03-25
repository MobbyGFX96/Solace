package net.solace.hacks;

import org.lwjgl.input.Keyboard;

import net.solace.main.Hack;
import net.solace.main.Variables;

public class Tracer extends Hack {

	public String getName() {
		return "Tracer ESP";
	}

	public int getColour() {
		return 0xffff00;
	}

	public int getKeybind() {
		return Keyboard.KEY_T;
	}

	public void onEnabled() {
		mc.thePlayer.addChatMessage("[Solace] - Enabled " + getName());
	}

	public void onDisable() {
		mc.thePlayer.addChatMessage("[Solace] - Disabled " + getName());
	}

	public boolean isEnabled() {
		return Variables.tracer;
	}

	public void toggle() {
		Variables.tracer = !Variables.tracer;
	}

}
