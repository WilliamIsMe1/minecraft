package net.minecraft.item;

import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.item.core.Item;
import net.minecraft.item.core.ItemStack;
import net.minecraft.world.World;

public class ItemEgg extends Item {
	public ItemEgg(int var1) {
		super(var1);
		this.maxStackSize = 16;
	}

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		--var1.stackSize;
		var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!var2.multiplayerWorld) {
			var2.entityJoinedWorld(new EntityEgg(var2, var3));
		}

		return var1;
	}
}
