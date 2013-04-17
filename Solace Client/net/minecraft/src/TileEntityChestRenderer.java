package net.minecraft.src;

import net.solace.hacks.ChestESP;
import net.solace.main.Variables;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Calendar;

public class TileEntityChestRenderer extends TileEntitySpecialRenderer {
    /**
     * The normal small chest model.
     */
    private ModelChest chestModel = new ModelChest();

    /**
     * The large double chest model.
     */
    private ModelChest largeChestModel = new ModelLargeChest();

    /**
     * If true, chests will be rendered with the Christmas present textures.
     */
    private boolean isChristmas;

    public TileEntityChestRenderer() {
        Calendar var1 = Calendar.getInstance();

        if (var1.get(2) + 1 == 12 && var1.get(5) >= 24 && var1.get(5) <= 26) {
            this.isChristmas = true;
        }
    }

    /**
     * Renders the TileEntity for the chest at a position.
     */
    public void renderTileEntityChestAt(TileEntityChest par1TileEntityChest,
                                        double par2, double par4, double par6, float par8) {
        int var9;

        if (!par1TileEntityChest.func_70309_m()) {
            var9 = 0;
        } else {
            Block var10 = par1TileEntityChest.getBlockType();
            var9 = par1TileEntityChest.getBlockMetadata();

            if (var10 instanceof BlockChest && var9 == 0) {
                ((BlockChest) var10).unifyAdjacentChests(
                        par1TileEntityChest.getWorldObj(),
                        par1TileEntityChest.xCoord, par1TileEntityChest.yCoord,
                        par1TileEntityChest.zCoord);
                var9 = par1TileEntityChest.getBlockMetadata();
            }

            par1TileEntityChest.checkForAdjacentChests();
        }

        if (par1TileEntityChest.adjacentChestZNeg == null
                && par1TileEntityChest.adjacentChestXNeg == null) {
            ModelChest var14;

            if (par1TileEntityChest.adjacentChestXPos == null
                    && par1TileEntityChest.adjacentChestZPosition == null) {
                var14 = this.chestModel;

                if (par1TileEntityChest.func_98041_l() == 1) {
                    this.bindTextureByName("/item/chests/trap_small.png");
                } else if (this.isChristmas) {
                    this.bindTextureByName("/item/xmaschest.png");
                } else {
                    this.bindTextureByName("/item/chest.png");
                }
            } else {
                var14 = this.largeChestModel;

                if (par1TileEntityChest.func_98041_l() == 1) {
                    this.bindTextureByName("/item/chests/trap_large.png");
                } else if (this.isChristmas) {
                    this.bindTextureByName("/item/largexmaschest.png");
                } else {
                    this.bindTextureByName("/item/largechest.png");
                }
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) par2, (float) par4 + 1.0F,
                    (float) par6 + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short var11 = 0;

            if (var9 == 2) {
                var11 = 180;
            }

            if (var9 == 3) {
                var11 = 0;
            }

            if (var9 == 4) {
                var11 = 90;
            }

            if (var9 == 5) {
                var11 = -90;
            }

            if (var9 == 2 && par1TileEntityChest.adjacentChestXPos != null) {
                GL11.glTranslatef(1.0F, 0.0F, 0.0F);
            }

            if (var9 == 5 && par1TileEntityChest.adjacentChestZPosition != null) {
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            }

            GL11.glRotatef((float) var11, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float var12 = par1TileEntityChest.prevLidAngle
                    + (par1TileEntityChest.lidAngle - par1TileEntityChest.prevLidAngle)
                    * par8;
            float var13;

            if (par1TileEntityChest.adjacentChestZNeg != null) {
                var13 = par1TileEntityChest.adjacentChestZNeg.prevLidAngle
                        + (par1TileEntityChest.adjacentChestZNeg.lidAngle - par1TileEntityChest.adjacentChestZNeg.prevLidAngle)
                        * par8;

                if (var13 > var12) {
                    var12 = var13;
                }
            }

            if (par1TileEntityChest.adjacentChestXNeg != null) {
                var13 = par1TileEntityChest.adjacentChestXNeg.prevLidAngle
                        + (par1TileEntityChest.adjacentChestXNeg.lidAngle - par1TileEntityChest.adjacentChestXNeg.prevLidAngle)
                        * par8;

                if (var13 > var12) {
                    var12 = var13;
                }
            }

            var12 = 1.0F - var12;
            var12 = 1.0F - var12 * var12 * var12;
            var14.chestLid.rotateAngleX = -(var12 * (float) Math.PI / 2.0F);
            var14.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean PosiX = par1TileEntityChest.adjacentChestXPos != null;
            boolean NegX = par1TileEntityChest.adjacentChestXNeg != null;
            boolean PosiZ = par1TileEntityChest.adjacentChestZPosition != null;
            boolean NegZ = par1TileEntityChest.adjacentChestZNeg != null;
            if (Variables.chestESP) {
                if (PosiX)
                    ChestESP.chestESP(par2 + 1, par4, par6, 1F);
                else if (NegX)
                    ChestESP.chestESP(par2 - 1, par4, par6, 1F);
                else if (PosiZ)
                    ChestESP.chestESP(par2, par4, par6 + 1, 1F);
                else if (NegZ)
                    ChestESP.chestESP(par2, par4, par6 - 1, 1F);

                ChestESP.chestESP(par2, par4, par6, 1F);
            }
        }
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2,
                                   double par4, double par6, float par8) {
        this.renderTileEntityChestAt((TileEntityChest) par1TileEntity, par2,
                par4, par6, par8);
    }
}
