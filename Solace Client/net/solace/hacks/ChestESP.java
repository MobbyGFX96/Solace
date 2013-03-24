package net.solace.hacks;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.Tessellator;
import net.solace.main.Hack;
import net.solace.main.Variables;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

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
		return Variables.chestESP;
	}

	public void onDisable() {

	}

	public void toggle() {
		Variables.chestESP = !Variables.chestESP;
	}

	public static void chestESP(double d, double d1, double d2, float f) {
		GL11.glEnable(3042 /* GL_BLEND */);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(2.0F); // Changes width
		GL11.glColor4d(0, 255, 100, 0.15F); // Changes color of line
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH); // enables anti-antialising
		GL11.glDisable(2929 /* GL_DEPTH_TEST */); // Disables the check that
													// tests if there is
													// something in front of the
													// player
		GL11.glDepthMask(false);
		drawBoundingBox(new AxisAlignedBB(d, d1, d2, d + 1.0, d1 + 1.0,
				d2 + 1.0)); // makes the colored bounding box
		GL11.glColor4d(0, 255, 100, 1F); // sets the color to non opaque
		RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(d, d1, d2, d + 1.0, d1 + 1.0,
				d2 + 1.0)); // makes the outlined bounding box
		GL11.glLineWidth(2.0F); // sets line width to two
		chestLines(new AxisAlignedBB(d, d1, d2, d + 1.0, d1 + 1.0, d2 + 1.0)); // renders
																				// the
																				// chest
																				// lines
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(2929 /* GL_DEPTH_TEST */); // Re-enables
		GL11.glDepthMask(true);
		GL11.glDisable(3042 /* GL_BLEND */); // disables teh mix
	}

	public static void chestLines(AxisAlignedBB ax) {
		GL11.glLineWidth(2F);
		GL11.glBegin(GL11.GL_LINES); // starts lines
		GL11.glVertex3d(ax.minX, ax.maxY, ax.minZ); // first point
		GL11.glVertex3d(ax.minX, ax.minY, ax.maxZ); // second point
		GL11.glEnd(); // ends lines
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex3d(ax.maxX, ax.maxY, ax.minZ);
		GL11.glVertex3d(ax.maxX, ax.minY, ax.maxZ);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex3d(ax.minX, ax.maxY, ax.minZ);
		GL11.glVertex3d(ax.maxX, ax.maxY, ax.maxZ);
		GL11.glEnd();
	}

	private static void drawBoundingBox(AxisAlignedBB axisalignedbb) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads(); // starts x
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.draw(); // ends x
		tessellator.startDrawingQuads(); // starts y
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.draw(); // ends y
		tessellator.startDrawingQuads(); // starts z
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.minZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY,
				axisalignedbb.maxZ);
		tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY,
				axisalignedbb.maxZ);
		tessellator.draw(); // ends z
	}

}
