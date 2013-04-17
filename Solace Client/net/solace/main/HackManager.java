package net.solace.main;

import net.minecraft.client.Minecraft;
import net.solace.hacks.*;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class HackManager {

    public Main main = new Main();
    public Minecraft mc = Minecraft.getMinecraft();
    private boolean keyStates[] = new boolean[256];
    public List<String> hackArray = new ArrayList<String>();

    public HackManager() {
        main.getHacks().add(new KillAura());
        main.getHacks().add(new ChestESP());
        main.getHacks().add(new Tracer());
        main.getHacks().add(new FullBright());
        main.getHacks().add(new Opacity());
    }

    private void toggleArray(String s) {
        if (hackArray.contains(s))
            hackArray.remove(s);
        else
            hackArray.add(s);
    }

    public void loadHacks() {
        for (Hack h : main.getHacks()) {
            if (checkKey(h.getKeybind())) {
                h.toggle();
                toggleArray(h.getName());
            }
            if (h.isEnabled())
                h.onEnabled();
            else
                h.onDisable();
        }
    }

    public boolean checkKey(int i) {
        if (mc.currentScreen != null) {
            return false;
        }
        if (Keyboard.isKeyDown(i) != keyStates[i]) {
            return keyStates[i] = !keyStates[i];
        } else {
            return false;
        }
    }

}
