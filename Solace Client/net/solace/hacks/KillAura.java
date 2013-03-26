package net.solace.hacks;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Packet12PlayerLook;
import net.solace.main.Hack;
import net.solace.main.Variables;

import org.lwjgl.input.Keyboard;

public class KillAura extends Hack {

	public String getName() {
		return "Kill Aura";
	}

	public int getColour() {
		return 0xff00ff;
	}

	public int getKeybind() {
		return Keyboard.KEY_K;
	}

	public void onEnabled() {
		KillAuraPlayer();
		KillAuraAnimal();
	}

	// TODO: Make improvements.
	public boolean isEnabled() {
		return Variables.killAura;
	}

	public void onDisable() {
		
	}

	public void toggle() {
		Variables.killAura = !Variables.killAura;
	}

	public static void KillAuraPlayer() {
		try {
			for (int i = 0; i < mc.theWorld.loadedEntityList.size(); i++) {
				Entity e = (Entity) mc.theWorld.getLoadedEntityList().get(i);
				if (e instanceof EntityPlayer) {
					if (e != mc.thePlayer && !e.isDead
							&& mc.thePlayer.canEntityBeSeen(e)
							&& mc.thePlayer.getDistanceSqToEntity(e) < 25D
							&& e instanceof EntityLiving) {
						mc.playerController.attackEntity(mc.thePlayer, e);
						mc.thePlayer.swingItem();
						{
							double x = e.posX - mc.thePlayer.posX;
							double y = e.posY - mc.thePlayer.posY;
							double z = e.posZ - mc.thePlayer.posZ;
							double d1 = (mc.thePlayer.posY + (double) mc.thePlayer
									.getEyeHeight())
									- (e.posY + (double) e.getEyeHeight());
							double d3 = MathHelper.sqrt_double(x * x + z * z);
							float f = (float) ((Math.atan2(z, x) * 180D) / Math.PI) - 90F;
							float f1 = (float) (((Math.atan2(d1, d3) * 180D) / Math.PI));
							mc.thePlayer.sendQueue
									.addToSendQueue(new Packet12PlayerLook(f,
											f1, true));
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}

	public void angle(Entity entity) {
		double Yaw = 0;
		double distancex = entity.posX - mc.thePlayer.posX;
		double distancez = entity.posZ - mc.thePlayer.posZ;
		double distancey = (entity.posY - mc.thePlayer.posY) + 1.2D;
		if (distancez > 0.0D && distancex > 0.0D) {
			Yaw = Math.toDegrees(-Math.atan(distancex / distancez));
		} else if (distancez > 0.0D && distancex < 0.0D) {
			Yaw = Math.toDegrees(-Math.atan(distancex / distancez));
		} else if (distancez < 0.0D && distancex > 0.0D) {
			Yaw = -90D + Math.toDegrees(Math.atan(distancez / distancex));
		} else if (distancez < 0.0D && distancex < 0.0D) {
			Yaw = 90D + Math.toDegrees(Math.atan(distancez / distancex));
		}
		double d = Math.sqrt(distancez * distancez + distancex * distancex);
		double Pitch = -Math.toDegrees(Math.atan(distancey / d));
		mc.thePlayer.sendQueue
				.addToSendQueue(new net.minecraft.src.Packet13PlayerLookMove(
						mc.thePlayer.posX, mc.thePlayer.boundingBox.minY,
						mc.thePlayer.posY, mc.thePlayer.posZ, (int) Yaw,
						(int) Pitch, mc.thePlayer.onGround));
	}

	public static void KillAuraAnimal() {
		if (Variables.killAura) {
			try {
				for (int i = 0; i < mc.theWorld.loadedEntityList.size(); i++) {
					Entity e = (Entity) mc.theWorld.getLoadedEntityList()
							.get(i);
					if (e instanceof EntityAnimal) {
						if (e != mc.thePlayer && !e.isDead
								&& mc.thePlayer.canEntityBeSeen(e)
								&& mc.thePlayer.getDistanceSqToEntity(e) < 25D
								&& e instanceof EntityLiving) {
							mc.playerController.attackEntity(mc.thePlayer, e);
							mc.thePlayer.swingItem();
							double x = e.posX - mc.thePlayer.posX;
							double y = e.posY - mc.thePlayer.posY;
							double z = e.posZ - mc.thePlayer.posZ;
							double d1 = (mc.thePlayer.posY + (double) mc.thePlayer
									.getEyeHeight())
									- (e.posY + (double) e.getEyeHeight());
							double d3 = MathHelper.sqrt_double(x * x + z * z);
							float f = (float) ((Math.atan2(z, x) * 180D) / Math.PI) - 90F;
							float f1 = (float) (((Math.atan2(d1, d3) * 180D) / Math.PI));
							mc.thePlayer.sendQueue
									.addToSendQueue(new Packet12PlayerLook(f,
											f1, true));
						}
					}
				}
			} catch (Exception e) {

			}
		}
	}

}
