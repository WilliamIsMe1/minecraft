package net.minecraft.item;

import net.minecraft.block.Block;

public class RecipesFood {
	public void addRecipes(CraftingManager var1) {
		var1.addRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.bowlSoup), new Object[]{"Y", "X", "#", Character.valueOf('X'), net.minecraft.block.Block.mushroomBrown, Character.valueOf('Y'), net.minecraft.block.Block.mushroomRed, Character.valueOf('#'), net.minecraft.item.Item.bowlEmpty});
		var1.addRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.bowlSoup), new Object[]{"Y", "X", "#", Character.valueOf('X'), net.minecraft.block.Block.mushroomRed, Character.valueOf('Y'), Block.mushroomBrown, Character.valueOf('#'), net.minecraft.item.Item.bowlEmpty});
		var1.addRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.cookie, 8), new Object[]{"#X#", Character.valueOf('X'), new ItemStack(net.minecraft.item.Item.dyePowder, 1, 3), Character.valueOf('#'), Item.wheat});
	}
}
