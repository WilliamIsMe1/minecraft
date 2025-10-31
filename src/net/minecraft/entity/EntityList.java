package net.minecraft.entity;

import net.minecraft.entity.living.EntityLiving;
import net.minecraft.entity.living.creature.animal.EntityChicken;
import net.minecraft.entity.living.creature.animal.EntityCow;
import net.minecraft.entity.living.creature.animal.EntityPig;
import net.minecraft.entity.living.creature.animal.EntitySheep;
import net.minecraft.entity.living.creature.animal.EntitySquid;
import net.minecraft.entity.living.creature.mob.EntityCreeper;
import net.minecraft.entity.living.creature.mob.EntityGhast;
import net.minecraft.entity.living.creature.mob.EntityGiantZombie;
import net.minecraft.entity.living.creature.mob.EntityMob;
import net.minecraft.entity.living.creature.mob.EntityPigZombie;
import net.minecraft.entity.living.creature.mob.EntitySkeleton;
import net.minecraft.entity.living.creature.mob.EntitySlime;
import net.minecraft.entity.living.creature.mob.EntitySpider;
import net.minecraft.entity.living.creature.mob.EntityWolf;
import net.minecraft.entity.living.creature.mob.EntityZombie;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class EntityList {
	private static Map stringToClassMapping = new HashMap();
	private static Map classToStringMapping = new HashMap();
	private static Map IDtoClassMapping = new HashMap();
	private static Map classToIDMapping = new HashMap();

	private static void addMapping(Class var0, String var1, int var2) {
		stringToClassMapping.put(var1, var0);
		classToStringMapping.put(var0, var1);
		IDtoClassMapping.put(Integer.valueOf(var2), var0);
		classToIDMapping.put(var0, Integer.valueOf(var2));
	}

	public static net.minecraft.entity.Entity createEntityInWorld(String var0, World var1) {
		net.minecraft.entity.Entity var2 = null;

		try {
			Class var3 = (Class)stringToClassMapping.get(var0);
			if(var3 != null) {
				var2 = (net.minecraft.entity.Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		return var2;
	}

	public static net.minecraft.entity.Entity createEntityFromNBT(NBTTagCompound var0, World var1) {
		net.minecraft.entity.Entity var2 = null;

		try {
			Class var3 = (Class)stringToClassMapping.get(var0.getString("id"));
			if(var3 != null) {
				var2 = (net.minecraft.entity.Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if(var2 != null) {
			var2.readFromNBT(var0);
		} else {
			System.out.println("Skipping Entity with id " + var0.getString("id"));
		}

		return var2;
	}

	public static net.minecraft.entity.Entity createEntity(int var0, World var1) {
		net.minecraft.entity.Entity var2 = null;

		try {
			Class var3 = (Class)IDtoClassMapping.get(Integer.valueOf(var0));
			if(var3 != null) {
				var2 = (net.minecraft.entity.Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if(var2 == null) {
			System.out.println("Skipping Entity with id " + var0);
		}

		return var2;
	}

	public static int getEntityID(net.minecraft.entity.Entity var0) {
		return ((Integer)classToIDMapping.get(var0.getClass())).intValue();
	}

	public static String getEntityString(Entity var0) {
		return (String)classToStringMapping.get(var0.getClass());
	}

	static {
		addMapping(EntityArrow.class, "Arrow", 10);
		addMapping(EntitySnowball.class, "Snowball", 11);
		addMapping(EntityItem.class, "Item", 1);
		addMapping(EntityPainting.class, "Painting", 9);
		addMapping(EntityLiving.class, "Mob", 48);
		addMapping(EntityMob.class, "Monster", 49);
		addMapping(EntityCreeper.class, "Creeper", 50);
		addMapping(EntitySkeleton.class, "Skeleton", 51);
		addMapping(EntitySpider.class, "Spider", 52);
		addMapping(EntityGiantZombie.class, "Giant", 53);
		addMapping(EntityZombie.class, "Zombie", 54);
		addMapping(EntitySlime.class, "Slime", 55);
		addMapping(EntityGhast.class, "Ghost", 56);
		addMapping(EntityPigZombie.class, "PigZombie", 57);
		addMapping(EntityPig.class, "Pig", 90);
		addMapping(EntitySheep.class, "Sheep", 91);
		addMapping(EntityCow.class, "Cow", 92);
		addMapping(EntityChicken.class, "Chicken", 93);
		addMapping(EntitySquid.class, "Squid", 94);
		addMapping(EntityWolf.class, "Wolf", 95);
		addMapping(EntityTNTPrimed.class, "PrimedTnt", 20);
		addMapping(EntityFallingSand.class, "FallingSand", 21);
		addMapping(EntityMinecart.class, "Minecart", 40);
		addMapping(EntityBoat.class, "Boat", 41);
	}
}
