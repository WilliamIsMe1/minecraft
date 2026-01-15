package net.minecraft.client.render;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.core.Block;
import net.minecraft.client.GameSettings;
import net.minecraft.client.render.entity.model.ModelBiped;
import net.minecraft.client.render.entity.model.ModelChicken;
import net.minecraft.client.render.entity.model.ModelCow;
import net.minecraft.client.render.entity.model.ModelPig;
import net.minecraft.client.render.entity.model.ModelSheep1;
import net.minecraft.client.render.entity.model.ModelSheep2;
import net.minecraft.client.render.entity.model.ModelSkeleton;
import net.minecraft.client.render.entity.model.ModelSlime;
import net.minecraft.client.render.entity.model.ModelSquid;
import net.minecraft.client.render.entity.model.ModelWolf;
import net.minecraft.client.render.entity.model.ModelZombie;
import net.minecraft.client.render.entity.render.*;
import net.minecraft.client.render.item.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.EntityBoat;
import net.minecraft.entity.living.creature.animal.EntityChicken;
import net.minecraft.entity.living.creature.animal.EntityCow;
import net.minecraft.entity.living.creature.mob.EntityCreeper;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.EntityFallingSand;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.living.creature.animal.EntityFish;
import net.minecraft.entity.living.creature.mob.EntityGhast;
import net.minecraft.entity.living.creature.mob.EntityGiantZombie;
import net.minecraft.entity.EntityItem;
import net.minecraft.entity.EntityLightningBolt;
import net.minecraft.entity.living.EntityLiving;
import net.minecraft.entity.EntityMinecart;
import net.minecraft.entity.EntityPainting;
import net.minecraft.entity.living.creature.animal.EntityPig;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.entity.living.creature.animal.EntitySheep;
import net.minecraft.entity.living.creature.mob.EntitySkeleton;
import net.minecraft.entity.living.creature.mob.EntitySlime;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.living.creature.mob.EntitySpider;
import net.minecraft.entity.living.creature.animal.EntitySquid;
import net.minecraft.entity.EntityTNTPrimed;
import net.minecraft.entity.living.creature.mob.EntityWolf;
import net.minecraft.entity.living.creature.mob.EntityZombie;
import net.minecraft.item.core.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderManager {
	private final Map<Class<?>, Render> entityRenderMap = new HashMap<>();
	public static RenderManager instance = new RenderManager();
	private FontRenderer fontRenderer;
	public static double renderPosX;
	public static double renderPosY;
	public static double renderPosZ;
	public RenderEngine renderEngine;
	public ItemRenderer itemRenderer;
	public net.minecraft.world.World worldObj;
	public EntityLiving livingPlayer;
	public float playerViewY;
	public float playerViewX;
	public net.minecraft.client.GameSettings options;
	public double field_1222_l;
	public double field_1221_m;
	public double field_1220_n;

	private RenderManager() {
		this.entityRenderMap.put(EntitySpider.class, new RenderSpider());
		this.entityRenderMap.put(EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
		this.entityRenderMap.put(EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
		this.entityRenderMap.put(EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
		this.entityRenderMap.put(EntityWolf.class, new RenderWolf(new ModelWolf(), 0.5F));
		this.entityRenderMap.put(EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
		this.entityRenderMap.put(EntityCreeper.class, new RenderCreeper());
		this.entityRenderMap.put(EntitySkeleton.class, new RenderBiped(new ModelSkeleton(), 0.5F));
		this.entityRenderMap.put(EntityZombie.class, new RenderBiped(new ModelZombie(), 0.5F));
		this.entityRenderMap.put(EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
		this.entityRenderMap.put(EntityPlayer.class, new RenderPlayer());
		this.entityRenderMap.put(EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6.0F));
		this.entityRenderMap.put(EntityGhast.class, new RenderGhast());
		this.entityRenderMap.put(EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
		this.entityRenderMap.put(EntityLiving.class, new RenderLiving(new ModelBiped(), 0.5F));
		this.entityRenderMap.put(net.minecraft.entity.Entity.class, new RenderEntity());
		this.entityRenderMap.put(EntityPainting.class, new RenderPainting());
		this.entityRenderMap.put(EntityArrow.class, new RenderArrow());
		this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball(Item.snowball.getIconFromDamage(0)));
		this.entityRenderMap.put(EntityEgg.class, new RenderSnowball(Item.egg.getIconFromDamage(0)));
		this.entityRenderMap.put(EntityFireball.class, new RenderFireball());
		this.entityRenderMap.put(EntityItem.class, new RenderItem());
		this.entityRenderMap.put(EntityTNTPrimed.class, new RenderTNTPrimed());
		this.entityRenderMap.put(EntityFallingSand.class, new RenderFallingSand());
		this.entityRenderMap.put(EntityMinecart.class, new RenderMinecart());
		this.entityRenderMap.put(EntityBoat.class, new RenderBoat());
		this.entityRenderMap.put(EntityFish.class, new RenderFish());
		this.entityRenderMap.put(EntityLightningBolt.class, new RenderLightningBolt());

		for (Render var2 : this.entityRenderMap.values()) {
			var2.setRenderManager(this);
		}

	}

	public net.minecraft.client.render.Render getEntityClassRenderObject(Class var1) {
		net.minecraft.client.render.Render var2 = (net.minecraft.client.render.Render)this.entityRenderMap.get(var1);
		if(var2 == null && var1 != net.minecraft.entity.Entity.class) {
			var2 = this.getEntityClassRenderObject(var1.getSuperclass());
			this.entityRenderMap.put(var1, var2);
		}

		return var2;
	}

	public net.minecraft.client.render.Render getEntityRenderObject(net.minecraft.entity.Entity var1) {
		return this.getEntityClassRenderObject(var1.getClass());
	}

	public void cacheActiveRenderInfo(net.minecraft.world.World var1, RenderEngine var2, FontRenderer var3, EntityLiving var4, GameSettings var5, float var6) {
		this.worldObj = var1;
		this.renderEngine = var2;
		this.options = var5;
		this.livingPlayer = var4;
		this.fontRenderer = var3;
		if(var4.isPlayerSleeping()) {
			int var7 = var1.getBlockId(MathHelper.floor_double(var4.posX), MathHelper.floor_double(var4.posY), MathHelper.floor_double(var4.posZ));
			if(var7 == Block.blockBed.blockID) {
				int var8 = var1.getBlockMetadata(MathHelper.floor_double(var4.posX), MathHelper.floor_double(var4.posY), MathHelper.floor_double(var4.posZ));
				int var9 = var8 & 3;
				this.playerViewY = (float)(var9 * 90 + 180);
				this.playerViewX = 0.0F;
			}
		} else {
			this.playerViewY = var4.prevRotationYaw + (var4.rotationYaw - var4.prevRotationYaw) * var6;
			this.playerViewX = var4.prevRotationPitch + (var4.rotationPitch - var4.prevRotationPitch) * var6;
		}

		this.field_1222_l = var4.lastTickPosX + (var4.posX - var4.lastTickPosX) * (double)var6;
		this.field_1221_m = var4.lastTickPosY + (var4.posY - var4.lastTickPosY) * (double)var6;
		this.field_1220_n = var4.lastTickPosZ + (var4.posZ - var4.lastTickPosZ) * (double)var6;
	}

	public void renderEntity(net.minecraft.entity.Entity var1, float var2) {
		double var3 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double)var2;
		double var5 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double)var2;
		double var7 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double)var2;
		float var9 = var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var2;
		float var10 = var1.getEntityBrightness(var2);
		GL11.glColor3f(var10, var10, var10);
		this.renderEntityWithPosYaw(var1, var3 - renderPosX, var5 - renderPosY, var7 - renderPosZ, var9, var2);
	}

	public void renderEntityWithPosYaw(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		Render var10 = this.getEntityRenderObject(var1);
		if(var10 != null) {
			var10.doRender(var1, var2, var4, var6, var8, var9);
			var10.doRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
		}

	}

	public void func_852_a(World var1) {
		this.worldObj = var1;
	}

	public double func_851_a(double var1, double var3, double var5) {
		double var7 = var1 - this.field_1222_l;
		double var9 = var3 - this.field_1221_m;
		double var11 = var5 - this.field_1220_n;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public FontRenderer getFontRenderer() {
		return this.fontRenderer;
	}
}
