package net.solace.hacks;

import net.solace.main.Hack;
import net.solace.main.Variables;
import org.lwjgl.input.Keyboard;

public class Opacity extends Hack {

    public String getName() {
        return "Wallhack";
    }

    public int getColour() {
        return 0x0033ff;
    }

    public void onEnabled() {
        mc.renderGlobal.loadRenderers();
    }

    public int getKeybind() {
        return Keyboard.KEY_O;
    }

    public boolean isEnabled() {
        return Variables.opacity;
    }

    public void toggle() {
        Variables.opacity = !Variables.opacity;
    }

}
