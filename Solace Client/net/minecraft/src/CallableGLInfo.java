package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

import java.util.concurrent.Callable;

public class CallableGLInfo implements Callable {
    /**
     * The Minecraft instance.
     */
    final Minecraft mc;

    public CallableGLInfo(Minecraft par1Minecraft) {
        this.mc = par1Minecraft;
    }

    public String getTexturePack() {
        return GL11.glGetString(GL11.GL_RENDERER) + " GL version " + GL11.glGetString(GL11.GL_VERSION) + ", " + GL11.glGetString(GL11.GL_VENDOR);
    }

    public Object call() {
        return this.getTexturePack();
    }
}
