package net.minecraft.client.render;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySheep;
import org.lwjgl.opengl.GL11;

public class RenderSheep extends RenderLiving {
	public RenderSheep(net.minecraft.client.render.ModelBase var1, ModelBase var2, float var3) {
		super(var1, var3);
		this.setRenderPassModel(var2);
	}

	protected boolean setWoolColorAndRender(net.minecraft.entity.EntitySheep var1, int var2, float var3) {
		if(var2 == 0 && !var1.getSheared()) {
			this.loadTexture("/mob/sheep_fur.png");
			float var4 = var1.getEntityBrightness(var3);
			int var5 = var1.getFleeceColor();
			GL11.glColor3f(var4 * net.minecraft.entity.EntitySheep.fleeceColorTable[var5][0], var4 * net.minecraft.entity.EntitySheep.fleeceColorTable[var5][1], var4 * net.minecraft.entity.EntitySheep.fleeceColorTable[var5][2]);
			return true;
		} else {
			return false;
		}
	}

	protected boolean shouldRenderPass(EntityLiving var1, int var2, float var3) {
		return this.setWoolColorAndRender((EntitySheep)var1, var2, var3);
	}
}
