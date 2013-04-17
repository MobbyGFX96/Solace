package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

import java.util.concurrent.Callable;

public class CallableLWJGLVersion implements Callable {
    /**
     * Reference to the Minecraft object.
     */
    final Minecraft mc;

    public CallableLWJGLVersion(Minecraft par1Minecraft) {
        this.mc = par1Minecraft;
    }

    public String getType() {
        return Sys.getVersion();
    }

    public Object call() {
        return this.getType();
    }
}
