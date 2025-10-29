package net.minecraft.item;

import net.minecraft.block.Block;

public class RecipesArmor {
	private String[][] recipePatterns = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
	private Object[][] recipeItems = new Object[][]{{net.minecraft.item.Item.leather, Block.fire, net.minecraft.item.Item.ingotIron, net.minecraft.item.Item.diamond, net.minecraft.item.Item.ingotGold}, {net.minecraft.item.Item.helmetLeather, net.minecraft.item.Item.helmetChain, net.minecraft.item.Item.helmetSteel, net.minecraft.item.Item.helmetDiamond, net.minecraft.item.Item.helmetGold}, {net.minecraft.item.Item.plateLeather, net.minecraft.item.Item.plateChain, net.minecraft.item.Item.plateSteel, net.minecraft.item.Item.plateDiamond, net.minecraft.item.Item.plateGold}, {net.minecraft.item.Item.legsLeather, net.minecraft.item.Item.legsChain, net.minecraft.item.Item.legsSteel, net.minecraft.item.Item.legsDiamond, net.minecraft.item.Item.legsGold}, {net.minecraft.item.Item.bootsLeather, net.minecraft.item.Item.bootsChain, net.minecraft.item.Item.bootsSteel, net.minecraft.item.Item.bootsDiamond, net.minecraft.item.Item.bootsGold}};

	public void addRecipes(CraftingManager var1) {
		for(int var2 = 0; var2 < this.recipeItems[0].length; ++var2) {
			Object var3 = this.recipeItems[0][var2];

			for(int var4 = 0; var4 < this.recipeItems.length - 1; ++var4) {
				net.minecraft.item.Item var5 = (Item)this.recipeItems[var4 + 1][var2];
				var1.addRecipe(new ItemStack(var5), new Object[]{this.recipePatterns[var4], Character.valueOf('X'), var3});
			}
		}

	}
}
