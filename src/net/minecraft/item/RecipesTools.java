package net.minecraft.item;

import net.minecraft.block.Block;

public class RecipesTools {
	private String[][] recipePatterns = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
	private Object[][] recipeItems = new Object[][]{{net.minecraft.block.Block.planks, Block.cobblestone, net.minecraft.item.Item.ingotIron, net.minecraft.item.Item.diamond, net.minecraft.item.Item.ingotGold}, {net.minecraft.item.Item.pickaxeWood, net.minecraft.item.Item.pickaxeStone, net.minecraft.item.Item.pickaxeSteel, net.minecraft.item.Item.pickaxeDiamond, net.minecraft.item.Item.pickaxeGold}, {net.minecraft.item.Item.shovelWood, net.minecraft.item.Item.shovelStone, net.minecraft.item.Item.shovelSteel, net.minecraft.item.Item.shovelDiamond, net.minecraft.item.Item.shovelGold}, {net.minecraft.item.Item.axeWood, net.minecraft.item.Item.axeStone, net.minecraft.item.Item.axeSteel, net.minecraft.item.Item.axeDiamond, net.minecraft.item.Item.axeGold}, {net.minecraft.item.Item.hoeWood, net.minecraft.item.Item.hoeStone, net.minecraft.item.Item.hoeSteel, net.minecraft.item.Item.hoeDiamond, net.minecraft.item.Item.hoeGold}};

	public void addRecipes(CraftingManager var1) {
		for(int var2 = 0; var2 < this.recipeItems[0].length; ++var2) {
			Object var3 = this.recipeItems[0][var2];

			for(int var4 = 0; var4 < this.recipeItems.length - 1; ++var4) {
				net.minecraft.item.Item var5 = (net.minecraft.item.Item)this.recipeItems[var4 + 1][var2];
				var1.addRecipe(new net.minecraft.item.ItemStack(var5), new Object[]{this.recipePatterns[var4], Character.valueOf('#'), net.minecraft.item.Item.stick, Character.valueOf('X'), var3});
			}
		}

		var1.addRecipe(new ItemStack(net.minecraft.item.Item.shears), new Object[]{" #", "# ", Character.valueOf('#'), Item.ingotIron});
	}
}
