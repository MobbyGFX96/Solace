package net.solace.main;

import net.minecraft.client.Minecraft;

public abstract class Hack {

    public static Minecraft mc = Minecraft.getMinecraft();

    /**
     * Gets the name of the Hack.
     *
     * @return - name of the hack
     */
    public abstract String getName();

    /**
     * Get the ArrayList Colour
     *
     * @return - the colour
     */
    public abstract int getColour();

    /**
     * Gets the keybind used with the hack.
     *
     * @return - the keybind.
     */
    public abstract int getKeybind();

    /**
     * What to do when the hack is enabled.
     */
    public void onEnabled() {
    }

    /**
     * What to do when the hack is disabled.
     */
    public void onDisable() {
    }

    /**
     * Is the hack enabled? true : false.
     *
     * @return
     */
    public abstract boolean isEnabled();

    /**
     * Toggle the hack on or off.
     */
    public abstract void toggle();

}
