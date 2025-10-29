package net.minecraft.item;

import net.minecraft.block.Block;

public class RecipesIngots {
	private Object[][] recipeItems = new Object[][]{{net.minecraft.block.Block.blockGold, new net.minecraft.item.ItemStack(net.minecraft.item.Item.ingotGold, 9)}, {net.minecraft.block.Block.blockSteel, new net.minecraft.item.ItemStack(net.minecraft.item.Item.ingotIron, 9)}, {net.minecraft.block.Block.blockDiamond, new net.minecraft.item.ItemStack(net.minecraft.item.Item.diamond, 9)}, {net.minecraft.block.Block.blockLapis, new net.minecraft.item.ItemStack(Item.dyePowder, 9, 4)}};

	public void addRecipes(CraftingManager var1) {
		for(int var2 = 0; var2 < this.recipeItems.length; ++var2) {
			net.minecraft.block.Block var3 = (Block)this.recipeItems[var2][0];
			net.minecraft.item.ItemStack var4 = (net.minecraft.item.ItemStack)this.recipeItems[var2][1];
			var1.addRecipe(new ItemStack(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
			var1.addRecipe(var4, new Object[]{"#", Character.valueOf('#'), var3});
		}

	}
}
