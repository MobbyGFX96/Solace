package net.solace.main;

import net.minecraft.client.Minecraft;

public class CommandManager {

    private static Minecraft mc;

    public static void processCommand(String s) {
        if (s.startsWith(".chest")) {
            mc.thePlayer.sendChatMessage(Variables.chestESP ? "�9[Solace]�f Chest Mode enabled." : "�9[Solace]�f Chest Mode disabled.");
        }
    }

}
