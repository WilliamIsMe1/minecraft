package net.minecraft.item;

import net.minecraft.block.Block;

public class RecipesWeapons {
	private String[][] recipePatterns = new String[][]{{"X", "X", "#"}};
	private Object[][] recipeItems = new Object[][]{{net.minecraft.block.Block.planks, Block.cobblestone, net.minecraft.item.Item.ingotIron, net.minecraft.item.Item.diamond, net.minecraft.item.Item.ingotGold}, {net.minecraft.item.Item.swordWood, net.minecraft.item.Item.swordStone, net.minecraft.item.Item.swordSteel, net.minecraft.item.Item.swordDiamond, net.minecraft.item.Item.swordGold}};

	public void addRecipes(CraftingManager var1) {
		for(int var2 = 0; var2 < this.recipeItems[0].length; ++var2) {
			Object var3 = this.recipeItems[0][var2];

			for(int var4 = 0; var4 < this.recipeItems.length - 1; ++var4) {
				net.minecraft.item.Item var5 = (net.minecraft.item.Item)this.recipeItems[var4 + 1][var2];
				var1.addRecipe(new net.minecraft.item.ItemStack(var5), new Object[]{this.recipePatterns[var4], Character.valueOf('#'), net.minecraft.item.Item.stick, Character.valueOf('X'), var3});
			}
		}

		var1.addRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.bow, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), net.minecraft.item.Item.silk, Character.valueOf('#'), net.minecraft.item.Item.stick});
		var1.addRecipe(new ItemStack(net.minecraft.item.Item.arrow, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), net.minecraft.item.Item.feather, Character.valueOf('X'), net.minecraft.item.Item.flint, Character.valueOf('#'), Item.stick});
	}
}
