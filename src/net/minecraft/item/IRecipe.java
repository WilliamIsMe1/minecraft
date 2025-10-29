package net.minecraft.item;

public interface IRecipe {
	boolean matches(InventoryCrafting var1);

	ItemStack getCraftingResult(InventoryCrafting var1);

	int getRecipeSize();

	ItemStack getRecipeOutput();
}
