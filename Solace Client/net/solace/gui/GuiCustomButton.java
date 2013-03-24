package net.solace.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;

import org.lwjgl.opengl.GL11;

public class GuiCustomButton extends Gui {
	/** Button width in pixels */
	protected int width;

	/** Button height in pixels */
	protected int height;

	/** The x position of this control. */
	public int xPosition;

	/** The y position of this control. */
	public int yPosition;

	/** The string displayed on this control. */
	public String displayString;

	/** ID for this control. */
	public int id;

	/** True if this control is enabled, false to disable. */
	public boolean enabled;

	/** Hides the button completely if false. */
	public boolean drawButton;
	protected boolean isOverButton;

	public GuiCustomButton(int par1, int par2, int par3, String par4Str) {
		this(par1, par2, par3, 200, 20, par4Str);
	}

	public GuiCustomButton(int id, int x, int y, int width, int height,
			String text) {
		this.width = 200;
		this.height = 20;
		this.enabled = true;
		this.drawButton = true;
		this.id = id;
		this.xPosition = x;
		this.yPosition = y;
		this.width = width;
		this.height = height;
		this.displayString = text;
	}

	/**
	 * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over
	 * this button and 2 if it IS hovering over this button.
	 */
	protected int getHoverState(boolean par1) {
		byte var2 = 1;

		if (!this.enabled) {
			var2 = 0;
		} else if (par1) {
			var2 = 2;
		}

		return var2;
	}

	/**
	 * Draws this button to the screen.
	 */
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		if (drawButton) {
			
		}
	}

	/**
	 * Fired when the mouse button is dragged. Equivalent of
	 * MouseListener.mouseDragged(MouseEvent e).
	 */
	protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3) {
	}

	/**
	 * Fired when the mouse button is released. Equivalent of
	 * MouseListener.mouseReleased(MouseEvent e).
	 */
	public void mouseReleased(int par1, int par2) {
	}

	/**
	 * Returns true if the mouse has been pressed on this control. Equivalent of
	 * MouseListener.mousePressed(MouseEvent e).
	 */
	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {
		return this.enabled && this.drawButton && par2 >= this.xPosition
				&& par3 >= this.yPosition && par2 < this.xPosition + this.width
				&& par3 < this.yPosition + this.height;
	}

	public boolean func_82252_a() {
		return this.isOverButton;
	}

	public void func_82251_b(int par1, int par2) {
	}
}
