package net.solace.hacks;

import net.solace.main.Hack;
import net.solace.main.Variables;
import org.lwjgl.input.Keyboard;

public class Tracer extends Hack {

    public String getName() {
        return "Tracer ESP";
    }

    public int getColour() {
        return 0xffff00;
    }

    public int getKeybind() {
        return Keyboard.KEY_L;
    }

    public boolean isEnabled() {
        return Variables.tracer;
    }

    public void toggle() {
        Variables.tracer = !Variables.tracer;
    }

}
