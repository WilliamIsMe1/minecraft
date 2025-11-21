package net.minecraft.item.recipe;

import net.minecraft.item.container.Container;
import net.minecraft.item.core.ItemStack;

import java.util.List;

public interface ICrafting {
	void updateCraftingInventory(Container var1, List<ItemStack> var2);

	void updateCraftingInventorySlot(Container var1, int var2, ItemStack var3);

	void updateCraftingInventoryInfo(Container var1, int var2, int var3);
}
