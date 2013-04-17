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

    public boolean isEnabled() {
        return Variables.chestESP;
    }

    public void toggle() {
        Variables.chestESP = !Variables.chestESP;
    }

    public static void chestESP(double d, double d1, double d2, float f) {
        GL11.glEnable(3042 /* GL_BLEND */);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(0.1F);
        GL11.glColor4d(255, 255, 0, 0.15);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(2929 /* GL_DEPTH_TEST */);
        GL11.glDepthMask(false);
        drawBoundingBox(new AxisAlignedBB(d, d1, d2, d + 1.0, d1 + 1.0,
                d2 + 1.0));
        GL11.glColor4d(255, 255, 0, 1);
        RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(d, d1, d2,
                d + 1.0, d1 + 1.0, d2 + 1.0));
        GL11.glLineWidth(0.3F);
        chestLines(new AxisAlignedBB(d, d1, d2, d + 1.0, d1 + 1.0, d2 + 1.0));
        tracerLine(d, d1, d2, f);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(2929 /* GL_DEPTH_TEST */);
        GL11.glDepthMask(true);
        GL11.glDisable(3042 /* GL_BLEND */);
    }

    public static void tracerLine(double d, double d1, double d2, float f) {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2d(0D, 0D);
        GL11.glVertex3d(d + 0.5, d1 + 0.5, d2 + 0.5);
        GL11.glEnd();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(2929 /* GL_DEPTH_TEST */);
        GL11.glDepthMask(true);
        GL11.glDisable(3042 /* GL_BLEND */);
    }

    public static void chestLines(AxisAlignedBB ax) {
        GL11.glLineWidth(0.1F);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(ax.minX, ax.maxY, ax.minZ);
        GL11.glVertex3d(ax.minX, ax.minY, ax.maxZ);
        GL11.glEnd();
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
        tessellator.startDrawingQuads();
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
        tessellator.draw();
        tessellator.startDrawingQuads();
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
        tessellator.draw();
        tessellator.startDrawingQuads();
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
        tessellator.draw();
    }

    public static void drawOutlinedBoundingBoxdday(AxisAlignedBB ax) {
        GL11.glLineWidth(1F);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(ax.minX, ax.minY, ax.minZ);
        GL11.glVertex3d(ax.maxX, ax.minY, ax.maxZ);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(ax.maxX, ax.minY, ax.maxZ);
        GL11.glVertex3d(ax.maxX, ax.maxY, ax.minZ);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(ax.minX, ax.maxY, ax.minZ);
        GL11.glVertex3d(ax.maxX, ax.maxY, ax.maxZ);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(ax.minX, ax.minY, ax.maxZ);
        GL11.glVertex3d(ax.minX, ax.maxY, ax.minZ);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(ax.minX, ax.maxY, ax.maxZ);
        GL11.glVertex3d(ax.maxX, ax.minY, ax.maxZ);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(ax.minX, ax.maxY, ax.minZ);
        GL11.glVertex3d(ax.maxX, ax.minY, ax.minZ);
        GL11.glEnd();
        RenderGlobal.drawOutlinedBoundingBox(ax);
    }

}
