package net.solace.hacks;

import net.minecraft.src.Entity;
import net.solace.main.Hack;
import net.solace.main.Variables;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

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

	public boolean isEnabled() {
		return Variables.tracer;
	}

	public void toggle() {
		Variables.tracer = !Variables.tracer;
	}

	public static void tracerLine(boolean flag) {
		try {
			GL11.glBlendFunc(770, 771);
			GL11.glLineWidth(3.0F);
			GL11.glDisable(2929 /* GL_DEPTH_TEST */);
			GL11.glDepthMask(false);

			double size = 0.45;
			double ytSize = 0.35;
			GL11.glBegin(GL11.GL_LINES);
			GL11.glColor3f(0, 5, 0);
			for (int x = 0; x < mc.theWorld.playerEntities.size(); x++) {
				Entity entity = (Entity) mc.theWorld.playerEntities.get(x);
				double X = entity.posX;
				double Y = entity.posY;
				double Z = entity.posZ;
				double mX = mc.thePlayer.posX;
				double mY = mc.thePlayer.posY;
				double mZ = mc.thePlayer.posZ;
				double dX = (mX - X);
				double dY = (mY - Y);
				double dZ = (mZ - Z);

				if (X != mX && Y != mY && Z != mZ) {
					GL11.glVertex3d(0, 0, 0);
					GL11.glVertex3d((-dX + size) - 0.5, (ytSize - dY) + 1.0,
							(-dZ - size) + 0.5);
				}
			}

			GL11.glEnd();
			GL11.glDepthMask(true);
			GL11.glEnable(2929 /* GL_DEPTH_TEST */);
		} catch (Exception e) {
		}
	}

}
