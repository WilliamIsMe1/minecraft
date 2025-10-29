package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCloth;

public class RecipesDyes {
	public void addRecipes(CraftingManager var1) {
		for(int var2 = 0; var2 < 16; ++var2) {
			var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.block.Block.cloth, 1, BlockCloth.func_21035_d(var2)), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, var2), new net.minecraft.item.ItemStack(net.minecraft.item.Item.itemsList[net.minecraft.block.Block.cloth.blockID], 1, 0)});
		}

		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 11), new Object[]{net.minecraft.block.Block.plantYellow});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 1), new Object[]{Block.plantRed});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 3, 15), new Object[]{net.minecraft.item.Item.bone});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 9), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 1), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 15)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 14), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 1), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 11)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 10), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 2), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 15)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 8), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 0), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 15)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 7), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 8), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 15)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 3, 7), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 0), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 15), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 15)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 12), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 4), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 15)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 6), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 4), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 2)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 5), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 4), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 1)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 2, 13), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 5), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 9)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 3, 13), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 4), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 1), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 9)});
		var1.addShapelessRecipe(new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 4, 13), new Object[]{new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 4), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 1), new net.minecraft.item.ItemStack(net.minecraft.item.Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 15)});
	}
}
