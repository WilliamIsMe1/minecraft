package net.minecraft.client.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityChicken;
import net.minecraft.entity.EntityLiving;
import net.minecraft.src.MathHelper;

public class RenderChicken extends RenderLiving {
	public RenderChicken(ModelBase var1, float var2) {
		super(var1, var2);
	}

	public void renderChicken(net.minecraft.entity.EntityChicken var1, double var2, double var4, double var6, float var8, float var9) {
		super.doRenderLiving(var1, var2, var4, var6, var8, var9);
	}

	protected float getWingRotation(net.minecraft.entity.EntityChicken var1, float var2) {
		float var3 = var1.field_756_e + (var1.field_752_b - var1.field_756_e) * var2;
		float var4 = var1.field_757_d + (var1.destPos - var1.field_757_d) * var2;
		return (MathHelper.sin(var3) + 1.0F) * var4;
	}

	protected float func_170_d(net.minecraft.entity.EntityLiving var1, float var2) {
		return this.getWingRotation((net.minecraft.entity.EntityChicken)var1, var2);
	}

	public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderChicken((net.minecraft.entity.EntityChicken)var1, var2, var4, var6, var8, var9);
	}

	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderChicken((EntityChicken)var1, var2, var4, var6, var8, var9);
	}
}
