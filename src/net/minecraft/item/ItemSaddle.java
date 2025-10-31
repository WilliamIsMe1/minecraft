package net.minecraft.item;

import net.minecraft.entity.living.EntityLiving;
import net.minecraft.entity.living.creature.animal.EntityPig;
import net.minecraft.item.core.Item;
import net.minecraft.item.core.ItemStack;

public class ItemSaddle extends Item {
	public ItemSaddle(int var1) {
		super(var1);
		this.maxStackSize = 1;
	}

	public void saddleEntity(ItemStack var1, EntityLiving var2) {
		if(var2 instanceof EntityPig) {
			EntityPig var3 = (EntityPig)var2;
			if(!var3.getSaddled()) {
				var3.setSaddled(true);
				--var1.stackSize;
			}
		}

	}

	public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
		this.saddleEntity(var1, var2);
		return true;
	}
}
