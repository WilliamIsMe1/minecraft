package net.minecraft.entity;

import net.minecraft.achievement.AchievementList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.Material;
import net.minecraft.block.TileEntityDispenser;
import net.minecraft.block.TileEntityFurnace;
import net.minecraft.block.TileEntitySign;
import net.minecraft.core.EnumStatus;
import net.minecraft.core.MathHelper;
import net.minecraft.item.IInventory;
import net.minecraft.item.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.container.Container;
import net.minecraft.item.container.ContainerPlayer;
import net.minecraft.misc.AxisAlignedBB;
import net.minecraft.achievement.stats.StatList;
import net.minecraft.util.nbt.NBTTagList;
import net.minecraft.world.ChunkCoordinates;
import net.minecraft.world.IChunkProvider;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public abstract class EntityPlayer extends EntityLiving {
	public net.minecraft.item.InventoryPlayer inventory = new InventoryPlayer(this);
	public net.minecraft.item.container.Container inventorySlots;
	public Container craftingInventory;
	public byte field_9371_f = 0;
	public int score = 0;
	public float field_775_e;
	public float field_774_f;
	public boolean isSwinging = false;
	public int swingProgressInt = 0;
	public String username;
	public int dimension;
	public String playerCloakUrl;
	public double field_20066_r;
	public double field_20065_s;
	public double field_20064_t;
	public double field_20063_u;
	public double field_20062_v;
	public double field_20061_w;
	protected boolean sleeping;
	public net.minecraft.world.ChunkCoordinates bedChunkCoordinates;
	private int sleepTimer;
	public float field_22063_x;
	public float field_22062_y;
	public float field_22061_z;
	private net.minecraft.world.ChunkCoordinates playerSpawnCoordinate;
	private net.minecraft.world.ChunkCoordinates startMinecartRidingCoordinate;
	public int timeUntilPortal = 20;
	protected boolean inPortal = false;
	public float timeInPortal;
	public float prevTimeInPortal;
	private int damageRemainder = 0;
	public EntityFish fishEntity = null;

	public EntityPlayer(net.minecraft.world.World var1) {
		super(var1);
		this.inventorySlots = new ContainerPlayer(this.inventory, !var1.multiplayerWorld);
		this.craftingInventory = this.inventorySlots;
		this.yOffset = 1.62F;
		net.minecraft.world.ChunkCoordinates var2 = var1.getSpawnPoint();
		this.setLocationAndAngles((double)var2.x + 0.5D, (double)(var2.y + 1), (double)var2.z + 0.5D, 0.0F, 0.0F);
		this.health = 20;
		this.field_9351_C = "humanoid";
		this.field_9353_B = 180.0F;
		this.fireResistance = 20;
		this.texture = "/mob/char.png";
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	public void onUpdate() {
		if(this.isPlayerSleeping()) {
			++this.sleepTimer;
			if(this.sleepTimer > 100) {
				this.sleepTimer = 100;
			}

			if(!this.worldObj.multiplayerWorld) {
				if(!this.isInBed()) {
					this.wakeUpPlayer(true, true, false);
				} else if(this.worldObj.isDaytime()) {
					this.wakeUpPlayer(false, true, true);
				}
			}
		} else if(this.sleepTimer > 0) {
			++this.sleepTimer;
			if(this.sleepTimer >= 110) {
				this.sleepTimer = 0;
			}
		}

		super.onUpdate();
		if(!this.worldObj.multiplayerWorld && this.craftingInventory != null && !this.craftingInventory.isUsableByPlayer(this)) {
			this.closeScreen();
			this.craftingInventory = this.inventorySlots;
		}

		this.field_20066_r = this.field_20063_u;
		this.field_20065_s = this.field_20062_v;
		this.field_20064_t = this.field_20061_w;
		double var1 = this.posX - this.field_20063_u;
		double var3 = this.posY - this.field_20062_v;
		double var5 = this.posZ - this.field_20061_w;
		double var7 = 10.0D;
		if(var1 > var7) {
			this.field_20066_r = this.field_20063_u = this.posX;
		}

		if(var5 > var7) {
			this.field_20064_t = this.field_20061_w = this.posZ;
		}

		if(var3 > var7) {
			this.field_20065_s = this.field_20062_v = this.posY;
		}

		if(var1 < -var7) {
			this.field_20066_r = this.field_20063_u = this.posX;
		}

		if(var5 < -var7) {
			this.field_20064_t = this.field_20061_w = this.posZ;
		}

		if(var3 < -var7) {
			this.field_20065_s = this.field_20062_v = this.posY;
		}

		this.field_20063_u += var1 * 0.25D;
		this.field_20061_w += var5 * 0.25D;
		this.field_20062_v += var3 * 0.25D;
		this.addStat(net.minecraft.achievement.stats.StatList.minutesPlayedStat, 1);
		if(this.ridingEntity == null) {
			this.startMinecartRidingCoordinate = null;
		}

	}

	protected boolean isMovementBlocked() {
		return this.health <= 0 || this.isPlayerSleeping();
	}

	protected void closeScreen() {
		this.craftingInventory = this.inventorySlots;
	}

	public void updateCloak() {
		this.playerCloakUrl = "http://s3.amazonaws.com/MinecraftCloaks/" + this.username + ".png";
		this.cloakUrl = this.playerCloakUrl;
	}

	public void updateRidden() {
		double var1 = this.posX;
		double var3 = this.posY;
		double var5 = this.posZ;
		super.updateRidden();
		this.field_775_e = this.field_774_f;
		this.field_774_f = 0.0F;
		this.addMountedMovementStat(this.posX - var1, this.posY - var3, this.posZ - var5);
	}

	public void preparePlayerToSpawn() {
		this.yOffset = 1.62F;
		this.setSize(0.6F, 1.8F);
		super.preparePlayerToSpawn();
		this.health = 20;
		this.deathTime = 0;
	}

	protected void updatePlayerActionState() {
		if(this.isSwinging) {
			++this.swingProgressInt;
			if(this.swingProgressInt >= 8) {
				this.swingProgressInt = 0;
				this.isSwinging = false;
			}
		} else {
			this.swingProgressInt = 0;
		}

		this.swingProgress = (float)this.swingProgressInt / 8.0F;
	}

	public void onLivingUpdate() {
		if(this.worldObj.difficultySetting == 0 && this.health < 20 && this.ticksExisted % 20 * 12 == 0) {
			this.heal(1);
		}

		this.inventory.decrementAnimations();
		this.field_775_e = this.field_774_f;
		super.onLivingUpdate();
		float var1 = net.minecraft.core.MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
		float var2 = (float)Math.atan(-this.motionY * (double)0.2F) * 15.0F;
		if(var1 > 0.1F) {
			var1 = 0.1F;
		}

		if(!this.onGround || this.health <= 0) {
			var1 = 0.0F;
		}

		if(this.onGround || this.health <= 0) {
			var2 = 0.0F;
		}

		this.field_774_f += (var1 - this.field_774_f) * 0.4F;
		this.field_9328_R += (var2 - this.field_9328_R) * 0.8F;
		if(this.health > 0) {
			List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.0D, 0.0D, 1.0D));
			if(var3 != null) {
				for(int var4 = 0; var4 < var3.size(); ++var4) {
					Entity var5 = (Entity)var3.get(var4);
					if(!var5.isDead) {
						this.collideWithPlayer(var5);
					}
				}
			}
		}

	}

	private void collideWithPlayer(Entity var1) {
		var1.onCollideWithPlayer(this);
	}

	public int getScore() {
		return this.score;
	}

	public void onDeath(Entity var1) {
		super.onDeath(var1);
		this.setSize(0.2F, 0.2F);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.motionY = (double)0.1F;
		if(this.username.equals("Notch")) {
			this.dropPlayerItemWithRandomChoice(new net.minecraft.item.ItemStack(net.minecraft.item.Item.appleRed, 1), true);
		}

		this.inventory.dropAllItems();
		if(var1 != null) {
			this.motionX = (double)(-net.minecraft.core.MathHelper.cos((this.attackedAtYaw + this.rotationYaw) * (float)Math.PI / 180.0F) * 0.1F);
			this.motionZ = (double)(-net.minecraft.core.MathHelper.sin((this.attackedAtYaw + this.rotationYaw) * (float)Math.PI / 180.0F) * 0.1F);
		} else {
			this.motionX = this.motionZ = 0.0D;
		}

		this.yOffset = 0.1F;
		this.addStat(net.minecraft.achievement.stats.StatList.deathsStat, 1);
	}

	public void addToPlayerScore(Entity var1, int var2) {
		this.score += var2;
		if(var1 instanceof EntityPlayer) {
			this.addStat(net.minecraft.achievement.stats.StatList.playerKillsStat, 1);
		} else {
			this.addStat(net.minecraft.achievement.stats.StatList.mobKillsStat, 1);
		}

	}

	public void dropCurrentItem() {
		this.dropPlayerItemWithRandomChoice(this.inventory.decrStackSize(this.inventory.currentItem, 1), false);
	}

	public void dropPlayerItem(net.minecraft.item.ItemStack var1) {
		this.dropPlayerItemWithRandomChoice(var1, false);
	}

	public void dropPlayerItemWithRandomChoice(net.minecraft.item.ItemStack var1, boolean var2) {
		if(var1 != null) {
			EntityItem var3 = new EntityItem(this.worldObj, this.posX, this.posY - (double)0.3F + (double)this.getEyeHeight(), this.posZ, var1);
			var3.delayBeforeCanPickup = 40;
			float var4 = 0.1F;
			float var5;
			if(var2) {
				var5 = this.rand.nextFloat() * 0.5F;
				float var6 = this.rand.nextFloat() * (float)Math.PI * 2.0F;
				var3.motionX = (double)(-net.minecraft.core.MathHelper.sin(var6) * var5);
				var3.motionZ = (double)(net.minecraft.core.MathHelper.cos(var6) * var5);
				var3.motionY = (double)0.2F;
			} else {
				var4 = 0.3F;
				var3.motionX = (double)(-net.minecraft.core.MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * net.minecraft.core.MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * var4);
				var3.motionZ = (double)(net.minecraft.core.MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * net.minecraft.core.MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * var4);
				var3.motionY = (double)(-net.minecraft.core.MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI) * var4 + 0.1F);
				var4 = 0.02F;
				var5 = this.rand.nextFloat() * (float)Math.PI * 2.0F;
				var4 *= this.rand.nextFloat();
				var3.motionX += Math.cos((double)var5) * (double)var4;
				var3.motionY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
				var3.motionZ += Math.sin((double)var5) * (double)var4;
			}

			this.joinEntityItemWithWorld(var3);
			this.addStat(net.minecraft.achievement.stats.StatList.dropStat, 1);
		}
	}

	protected void joinEntityItemWithWorld(EntityItem var1) {
		this.worldObj.entityJoinedWorld(var1);
	}

	public float getCurrentPlayerStrVsBlock(net.minecraft.block.Block var1) {
		float var2 = this.inventory.getStrVsBlock(var1);
		if(this.isInsideOfMaterial(net.minecraft.block.Material.water)) {
			var2 /= 5.0F;
		}

		if(!this.onGround) {
			var2 /= 5.0F;
		}

		return var2;
	}

	public boolean canHarvestBlock(net.minecraft.block.Block var1) {
		return this.inventory.canHarvestBlock(var1);
	}

	public void readEntityFromNBT(net.minecraft.util.nbt.NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
		net.minecraft.util.nbt.NBTTagList var2 = var1.getTagList("Inventory");
		this.inventory.readFromNBT(var2);
		this.dimension = var1.getInteger("Dimension");
		this.sleeping = var1.getBoolean("Sleeping");
		this.sleepTimer = var1.getShort("SleepTimer");
		if(this.sleeping) {
			this.bedChunkCoordinates = new net.minecraft.world.ChunkCoordinates(net.minecraft.core.MathHelper.floor_double(this.posX), net.minecraft.core.MathHelper.floor_double(this.posY), net.minecraft.core.MathHelper.floor_double(this.posZ));
			this.wakeUpPlayer(true, true, false);
		}

		if(var1.hasKey("SpawnX") && var1.hasKey("SpawnY") && var1.hasKey("SpawnZ")) {
			this.playerSpawnCoordinate = new net.minecraft.world.ChunkCoordinates(var1.getInteger("SpawnX"), var1.getInteger("SpawnY"), var1.getInteger("SpawnZ"));
		}

	}

	public void writeEntityToNBT(net.minecraft.util.nbt.NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
		var1.setTag("Inventory", this.inventory.writeToNBT(new NBTTagList()));
		var1.setInteger("Dimension", this.dimension);
		var1.setBoolean("Sleeping", this.sleeping);
		var1.setShort("SleepTimer", (short)this.sleepTimer);
		if(this.playerSpawnCoordinate != null) {
			var1.setInteger("SpawnX", this.playerSpawnCoordinate.x);
			var1.setInteger("SpawnY", this.playerSpawnCoordinate.y);
			var1.setInteger("SpawnZ", this.playerSpawnCoordinate.z);
		}

	}

	public void displayGUIChest(IInventory var1) {
	}

	public void displayWorkbenchGUI(int var1, int var2, int var3) {
	}

	public void onItemPickup(Entity var1, int var2) {
	}

	public float getEyeHeight() {
		return 0.12F;
	}

	protected void resetHeight() {
		this.yOffset = 1.62F;
	}

	public boolean attackEntityFrom(Entity var1, int var2) {
		this.entityAge = 0;
		if(this.health <= 0) {
			return false;
		} else {
			if(this.isPlayerSleeping() && !this.worldObj.multiplayerWorld) {
				this.wakeUpPlayer(true, true, false);
			}

			if(var1 instanceof EntityMob || var1 instanceof EntityArrow) {
				if(this.worldObj.difficultySetting == 0) {
					var2 = 0;
				}

				if(this.worldObj.difficultySetting == 1) {
					var2 = var2 / 3 + 1;
				}

				if(this.worldObj.difficultySetting == 3) {
					var2 = var2 * 3 / 2;
				}
			}

			if(var2 == 0) {
				return false;
			} else {
				Object var3 = var1;
				if(var1 instanceof EntityArrow && ((EntityArrow)var1).owner != null) {
					var3 = ((EntityArrow)var1).owner;
				}

				if(var3 instanceof EntityLiving) {
					this.alertWolves((EntityLiving)var3, false);
				}

				this.addStat(net.minecraft.achievement.stats.StatList.damageTakenStat, var2);
				return super.attackEntityFrom(var1, var2);
			}
		}
	}

	protected boolean func_27025_G() {
		return false;
	}

	protected void alertWolves(EntityLiving var1, boolean var2) {
		if(!(var1 instanceof EntityCreeper) && !(var1 instanceof EntityGhast)) {
			if(var1 instanceof EntityWolf) {
				EntityWolf var3 = (EntityWolf)var1;
				if(var3.isWolfTamed() && this.username.equals(var3.getWolfOwner())) {
					return;
				}
			}

			if(!(var1 instanceof EntityPlayer) || this.func_27025_G()) {
				List var7 = this.worldObj.getEntitiesWithinAABB(EntityWolf.class, AxisAlignedBB.getBoundingBoxFromPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(16.0D, 4.0D, 16.0D));
				Iterator var4 = var7.iterator();

				while(true) {
					EntityWolf var6;
					do {
						do {
							do {
								do {
									if(!var4.hasNext()) {
										return;
									}

									Entity var5 = (Entity)var4.next();
									var6 = (EntityWolf)var5;
								} while(!var6.isWolfTamed());
							} while(var6.getTarget() != null);
						} while(!this.username.equals(var6.getWolfOwner()));
					} while(var2 && var6.isWolfSitting());

					var6.setWolfSitting(false);
					var6.setTarget(var1);
				}
			}
		}
	}

	protected void damageEntity(int var1) {
		int var2 = 25 - this.inventory.getTotalArmorValue();
		int var3 = var1 * var2 + this.damageRemainder;
		this.inventory.damageArmor(var1);
		var1 = var3 / 25;
		this.damageRemainder = var3 % 25;
		super.damageEntity(var1);
	}

	public void displayGUIFurnace(TileEntityFurnace var1) {
	}

	public void displayGUIDispenser(TileEntityDispenser var1) {
	}

	public void displayGUIEditSign(TileEntitySign var1) {
	}

	public void useCurrentItemOnEntity(Entity var1) {
		if(!var1.interact(this)) {
			net.minecraft.item.ItemStack var2 = this.getCurrentEquippedItem();
			if(var2 != null && var1 instanceof EntityLiving) {
				var2.useItemOnEntity((EntityLiving)var1);
				if(var2.stackSize <= 0) {
					var2.func_1097_a(this);
					this.destroyCurrentEquippedItem();
				}
			}

		}
	}

	public net.minecraft.item.ItemStack getCurrentEquippedItem() {
		return this.inventory.getCurrentItem();
	}

	public void destroyCurrentEquippedItem() {
		this.inventory.setInventorySlotContents(this.inventory.currentItem, (net.minecraft.item.ItemStack)null);
	}

	public double getYOffset() {
		return (double)(this.yOffset - 0.5F);
	}

	public void swingItem() {
		this.swingProgressInt = -1;
		this.isSwinging = true;
	}

	public void attackTargetEntityWithCurrentItem(Entity var1) {
		int var2 = this.inventory.getDamageVsEntity(var1);
		if(var2 > 0) {
			if(this.motionY < 0.0D) {
				++var2;
			}

			var1.attackEntityFrom(this, var2);
			net.minecraft.item.ItemStack var3 = this.getCurrentEquippedItem();
			if(var3 != null && var1 instanceof EntityLiving) {
				var3.hitEntity((EntityLiving)var1, this);
				if(var3.stackSize <= 0) {
					var3.func_1097_a(this);
					this.destroyCurrentEquippedItem();
				}
			}

			if(var1 instanceof EntityLiving) {
				if(var1.isEntityAlive()) {
					this.alertWolves((EntityLiving)var1, true);
				}

				this.addStat(net.minecraft.achievement.stats.StatList.damageDealtStat, var2);
			}
		}

	}

	public void respawnPlayer() {
	}

	public abstract void func_6420_o();

	public void onItemStackChanged(net.minecraft.item.ItemStack var1) {
	}

	public void setEntityDead() {
		super.setEntityDead();
		this.inventorySlots.onCraftGuiClosed(this);
		if(this.craftingInventory != null) {
			this.craftingInventory.onCraftGuiClosed(this);
		}

	}

	public boolean isEntityInsideOpaqueBlock() {
		return !this.sleeping && super.isEntityInsideOpaqueBlock();
	}

	public net.minecraft.core.EnumStatus sleepInBedAt(int var1, int var2, int var3) {
		if(!this.worldObj.multiplayerWorld) {
			if(this.isPlayerSleeping() || !this.isEntityAlive()) {
				return net.minecraft.core.EnumStatus.OTHER_PROBLEM;
			}

			if(this.worldObj.worldProvider.isNether) {
				return net.minecraft.core.EnumStatus.NOT_POSSIBLE_HERE;
			}

			if(this.worldObj.isDaytime()) {
				return net.minecraft.core.EnumStatus.NOT_POSSIBLE_NOW;
			}

			if(Math.abs(this.posX - (double)var1) > 3.0D || Math.abs(this.posY - (double)var2) > 2.0D || Math.abs(this.posZ - (double)var3) > 3.0D) {
				return net.minecraft.core.EnumStatus.TOO_FAR_AWAY;
			}
		}

		this.setSize(0.2F, 0.2F);
		this.yOffset = 0.2F;
		if(this.worldObj.blockExists(var1, var2, var3)) {
			int var4 = this.worldObj.getBlockMetadata(var1, var2, var3);
			int var5 = net.minecraft.block.BlockBed.getDirectionFromMetadata(var4);
			float var6 = 0.5F;
			float var7 = 0.5F;
			switch(var5) {
			case 0:
				var7 = 0.9F;
				break;
			case 1:
				var6 = 0.1F;
				break;
			case 2:
				var7 = 0.1F;
				break;
			case 3:
				var6 = 0.9F;
			}

			this.func_22052_e(var5);
			this.setPosition((double)((float)var1 + var6), (double)((float)var2 + 15.0F / 16.0F), (double)((float)var3 + var7));
		} else {
			this.setPosition((double)((float)var1 + 0.5F), (double)((float)var2 + 15.0F / 16.0F), (double)((float)var3 + 0.5F));
		}

		this.sleeping = true;
		this.sleepTimer = 0;
		this.bedChunkCoordinates = new net.minecraft.world.ChunkCoordinates(var1, var2, var3);
		this.motionX = this.motionZ = this.motionY = 0.0D;
		if(!this.worldObj.multiplayerWorld) {
			this.worldObj.updateAllPlayersSleepingFlag();
		}

		return EnumStatus.OK;
	}

	private void func_22052_e(int var1) {
		this.field_22063_x = 0.0F;
		this.field_22061_z = 0.0F;
		switch(var1) {
		case 0:
			this.field_22061_z = -1.8F;
			break;
		case 1:
			this.field_22063_x = 1.8F;
			break;
		case 2:
			this.field_22061_z = 1.8F;
			break;
		case 3:
			this.field_22063_x = -1.8F;
		}

	}

	public void wakeUpPlayer(boolean var1, boolean var2, boolean var3) {
		this.setSize(0.6F, 1.8F);
		this.resetHeight();
		net.minecraft.world.ChunkCoordinates var4 = this.bedChunkCoordinates;
		net.minecraft.world.ChunkCoordinates var5 = this.bedChunkCoordinates;
		if(var4 != null && this.worldObj.getBlockId(var4.x, var4.y, var4.z) == net.minecraft.block.Block.blockBed.blockID) {
			net.minecraft.block.BlockBed.setBedOccupied(this.worldObj, var4.x, var4.y, var4.z, false);
			var5 = net.minecraft.block.BlockBed.getNearestEmptyChunkCoordinates(this.worldObj, var4.x, var4.y, var4.z, 0);
			if(var5 == null) {
				var5 = new net.minecraft.world.ChunkCoordinates(var4.x, var4.y + 1, var4.z);
			}

			this.setPosition((double)((float)var5.x + 0.5F), (double)((float)var5.y + this.yOffset + 0.1F), (double)((float)var5.z + 0.5F));
		}

		this.sleeping = false;
		if(!this.worldObj.multiplayerWorld && var2) {
			this.worldObj.updateAllPlayersSleepingFlag();
		}

		if(var1) {
			this.sleepTimer = 0;
		} else {
			this.sleepTimer = 100;
		}

		if(var3) {
			this.setPlayerSpawnCoordinate(this.bedChunkCoordinates);
		}

	}

	private boolean isInBed() {
		return this.worldObj.getBlockId(this.bedChunkCoordinates.x, this.bedChunkCoordinates.y, this.bedChunkCoordinates.z) == net.minecraft.block.Block.blockBed.blockID;
	}

	public static net.minecraft.world.ChunkCoordinates func_25060_a(World var0, net.minecraft.world.ChunkCoordinates var1) {
		IChunkProvider var2 = var0.getIChunkProvider();
		var2.prepareChunk(var1.x - 3 >> 4, var1.z - 3 >> 4);
		var2.prepareChunk(var1.x + 3 >> 4, var1.z - 3 >> 4);
		var2.prepareChunk(var1.x - 3 >> 4, var1.z + 3 >> 4);
		var2.prepareChunk(var1.x + 3 >> 4, var1.z + 3 >> 4);
		if(var0.getBlockId(var1.x, var1.y, var1.z) != Block.blockBed.blockID) {
			return null;
		} else {
			net.minecraft.world.ChunkCoordinates var3 = net.minecraft.block.BlockBed.getNearestEmptyChunkCoordinates(var0, var1.x, var1.y, var1.z, 0);
			return var3;
		}
	}

	public float getBedOrientationInDegrees() {
		if(this.bedChunkCoordinates != null) {
			int var1 = this.worldObj.getBlockMetadata(this.bedChunkCoordinates.x, this.bedChunkCoordinates.y, this.bedChunkCoordinates.z);
			int var2 = BlockBed.getDirectionFromMetadata(var1);
			switch(var2) {
			case 0:
				return 90.0F;
			case 1:
				return 0.0F;
			case 2:
				return 270.0F;
			case 3:
				return 180.0F;
			}
		}

		return 0.0F;
	}

	public boolean isPlayerSleeping() {
		return this.sleeping;
	}

	public boolean isPlayerFullyAsleep() {
		return this.sleeping && this.sleepTimer >= 100;
	}

	public int func_22060_M() {
		return this.sleepTimer;
	}

	public void addChatMessage(String var1) {
	}

	public net.minecraft.world.ChunkCoordinates getPlayerSpawnCoordinate() {
		return this.playerSpawnCoordinate;
	}

	public void setPlayerSpawnCoordinate(net.minecraft.world.ChunkCoordinates var1) {
		if(var1 != null) {
			this.playerSpawnCoordinate = new net.minecraft.world.ChunkCoordinates(var1);
		} else {
			this.playerSpawnCoordinate = null;
		}

	}

	public void triggerAchievement(net.minecraft.achievement.stats.StatBase var1) {
		this.addStat(var1, 1);
	}

	public void addStat(net.minecraft.achievement.stats.StatBase var1, int var2) {
	}

	protected void jump() {
		super.jump();
		this.addStat(net.minecraft.achievement.stats.StatList.jumpStat, 1);
	}

	public void moveEntityWithHeading(float var1, float var2) {
		double var3 = this.posX;
		double var5 = this.posY;
		double var7 = this.posZ;
		super.moveEntityWithHeading(var1, var2);
		this.addMovementStat(this.posX - var3, this.posY - var5, this.posZ - var7);
	}

	private void addMovementStat(double var1, double var3, double var5) {
		if(this.ridingEntity == null) {
			int var7;
			if(this.isInsideOfMaterial(Material.water)) {
				var7 = Math.round(net.minecraft.core.MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
				if(var7 > 0) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceDoveStat, var7);
				}
			} else if(this.isInWater()) {
				var7 = Math.round(net.minecraft.core.MathHelper.sqrt_double(var1 * var1 + var5 * var5) * 100.0F);
				if(var7 > 0) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceSwumStat, var7);
				}
			} else if(this.isOnLadder()) {
				if(var3 > 0.0D) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceClimbedStat, (int)Math.round(var3 * 100.0D));
				}
			} else if(this.onGround) {
				var7 = Math.round(net.minecraft.core.MathHelper.sqrt_double(var1 * var1 + var5 * var5) * 100.0F);
				if(var7 > 0) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceWalkedStat, var7);
				}
			} else {
				var7 = Math.round(net.minecraft.core.MathHelper.sqrt_double(var1 * var1 + var5 * var5) * 100.0F);
				if(var7 > 25) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceFlownStat, var7);
				}
			}

		}
	}

	private void addMountedMovementStat(double var1, double var3, double var5) {
		if(this.ridingEntity != null) {
			int var7 = Math.round(net.minecraft.core.MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
			if(var7 > 0) {
				if(this.ridingEntity instanceof EntityMinecart) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceByMinecartStat, var7);
					if(this.startMinecartRidingCoordinate == null) {
						this.startMinecartRidingCoordinate = new ChunkCoordinates(net.minecraft.core.MathHelper.floor_double(this.posX), net.minecraft.core.MathHelper.floor_double(this.posY), net.minecraft.core.MathHelper.floor_double(this.posZ));
					} else if(this.startMinecartRidingCoordinate.getSqDistanceTo(net.minecraft.core.MathHelper.floor_double(this.posX), net.minecraft.core.MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) >= 1000.0D) {
						this.addStat(net.minecraft.achievement.AchievementList.onARail, 1);
					}
				} else if(this.ridingEntity instanceof EntityBoat) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceByBoatStat, var7);
				} else if(this.ridingEntity instanceof EntityPig) {
					this.addStat(net.minecraft.achievement.stats.StatList.distanceByPigStat, var7);
				}
			}
		}

	}

	protected void fall(float var1) {
		if(var1 >= 2.0F) {
			this.addStat(StatList.distanceFallenStat, (int)Math.round((double)var1 * 100.0D));
		}

		super.fall(var1);
	}

	public void onKillEntity(EntityLiving var1) {
		if(var1 instanceof EntityMob) {
			this.triggerAchievement(AchievementList.killEnemy);
		}

	}

	public int getItemIcon(ItemStack var1) {
		int var2 = super.getItemIcon(var1);
		if(var1.itemID == Item.fishingRod.shiftedIndex && this.fishEntity != null) {
			var2 = var1.getIconIndex() + 16;
		}

		return var2;
	}

	public void setInPortal() {
		if(this.timeUntilPortal > 0) {
			this.timeUntilPortal = 10;
		} else {
			this.inPortal = true;
		}
	}
}
