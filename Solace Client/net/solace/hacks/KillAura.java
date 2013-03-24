package net.solace.hacks;

import net.solace.main.Hack;

import org.lwjgl.input.Keyboard;

public class KillAura extends Hack {
	
	public String getName() {
		return "Kill Aura";
	}

	public int getColour() {
		return 0xff00ff;
	}

	public int getKeybind() {
		return Keyboard.KEY_K;
	}

	public void onEnabled() {
		
	}

	public boolean isEnabled() {
		return vars.killAura;
	}

}
