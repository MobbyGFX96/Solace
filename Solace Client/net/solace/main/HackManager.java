package net.solace.main;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.solace.hacks.ChestESP;
import net.solace.hacks.KillAura;

import org.lwjgl.input.Keyboard;

public class HackManager {

	public Main main = new Main();
	public Minecraft mc = Minecraft.getMinecraft();
	private boolean keyStates[] = new boolean[256];
	public List<String> hackArray = new ArrayList<String>();

	public HackManager() {
		main.getHacks().add(new KillAura());
		main.getHacks().add(new ChestESP());
	}
	
	private void toggleArray(String s) {
		if (hackArray.contains(s))
			hackArray.remove(s);
		else
			hackArray.add(s);
	}

	public void loadHacks() {
		for (Hack h : main.getHacks()) {
			if (checkKey(h.getKeybind())) {
				h.toggle();
				if (h.isEnabled())
					h.onEnabled();
				else
					h.onDisable();
				toggleArray(h.getName());
			}
		}
	}

	public boolean checkKey(int i) {
		if (Keyboard.isKeyDown(i) != keyStates[i]) {
			return keyStates[i] = !keyStates[i];
		} else {
			return false;
		}
	}

}
