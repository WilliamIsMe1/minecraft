package net.minecraft.item;

import net.minecraft.block.Block;

public class RecipesCrafting {
	public void addRecipes(CraftingManager var1) {
		var1.addRecipe(new net.minecraft.item.ItemStack(net.minecraft.block.Block.chest), new Object[]{"###", "# #", "###", Character.valueOf('#'), net.minecraft.block.Block.planks});
		var1.addRecipe(new net.minecraft.item.ItemStack(net.minecraft.block.Block.stoneOvenIdle), new Object[]{"###", "# #", "###", Character.valueOf('#'), net.minecraft.block.Block.cobblestone});
		var1.addRecipe(new net.minecraft.item.ItemStack(net.minecraft.block.Block.workbench), new Object[]{"##", "##", Character.valueOf('#'), net.minecraft.block.Block.planks});
		var1.addRecipe(new ItemStack(net.minecraft.block.Block.sandStone), new Object[]{"##", "##", Character.valueOf('#'), Block.sand});
	}
}
