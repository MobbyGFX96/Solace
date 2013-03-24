package net.solace.main;

public abstract class Hack {
	
	public Variables vars = new Variables();
	
	public abstract String getName();
	public abstract int getColour();
	public abstract int getKeybind();
	public abstract void onEnabled();
	public abstract boolean isEnabled();
	
}
