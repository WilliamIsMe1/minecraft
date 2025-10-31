package net.minecraft.item.recipe;

import net.minecraft.item.container.inventory.InventoryCrafting;
import net.minecraft.item.core.ItemStack;

public interface IRecipe {
	boolean matches(InventoryCrafting var1);

	ItemStack getCraftingResult(InventoryCrafting var1);

	int getRecipeSize();

	ItemStack getRecipeOutput();
}
