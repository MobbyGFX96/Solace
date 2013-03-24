package net.solace.main;

import net.minecraft.client.Minecraft;

public abstract class Hack {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public abstract String getName();
	public abstract int getColour();
	public abstract int getKeybind();
	public abstract void onEnabled();
	public abstract void onDisable();
	public abstract boolean isEnabled();
	public abstract void toggle();

	
	
}
