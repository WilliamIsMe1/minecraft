package net.minecraft.item.food;

import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.item.core.Item;
import net.minecraft.item.core.ItemStack;
import net.minecraft.world.World;

public class ItemFood extends Item {
	private final int healAmount;
	private final boolean isWolfsFavoriteMeat;

	public ItemFood(int var1, int var2, boolean var3) {
		super(var1);
		this.healAmount = var2;
		this.isWolfsFavoriteMeat = var3;
		this.maxStackSize = 1;
	}

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		var1.stackSize--;
		var3.heal(this.healAmount);
		return var1;
	}

	public int getHealAmount() {
		return this.healAmount;
	}

	public boolean getIsWolfsFavoriteMeat() {
		return this.isWolfsFavoriteMeat;
	}
}
