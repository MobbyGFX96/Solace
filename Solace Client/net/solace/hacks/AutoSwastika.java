package net.solace.hacks;

import net.minecraft.src.Packet12PlayerLook;
import net.minecraft.src.Packet15Place;
import net.solace.main.Hack;
import net.solace.main.Variables;

import org.lwjgl.input.Keyboard;

public class AutoSwastika extends Hack {
	
	public String getName() {
		return "Auto Swastika";
	}

	public int getColour() {
		return 0x00ff00;
	}

	public int getKeybind() {
		return Keyboard.KEY_L;
	}

	public void onEnabled() {
		
	}

	public void onDisable() {
		
	}

	public boolean isEnabled() {
		return Variables.autoSwas;
	}

	public void toggle() {
		Variables.autoSwas = !Variables.autoSwas;
	}

}
