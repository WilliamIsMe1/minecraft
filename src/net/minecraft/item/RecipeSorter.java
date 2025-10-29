package net.minecraft.item;

import java.util.Comparator;

public class RecipeSorter implements Comparator<IRecipe> {
	final net.minecraft.item.CraftingManager craftingManager;

	public RecipeSorter(CraftingManager var1) {
		this.craftingManager = var1;
	}

	public int compareRecipes(net.minecraft.item.IRecipe var1, net.minecraft.item.IRecipe var2) {
		return var1 instanceof ShapelessRecipes && var2 instanceof ShapedRecipes ? 1 : (var2 instanceof ShapelessRecipes && var1 instanceof ShapedRecipes ? -1 : (Integer.compare(var2.getRecipeSize(), var1.getRecipeSize())));
	}

	public int compare(IRecipe var1, IRecipe var2) {
		return this.compareRecipes(var1, var2);
	}
}
