package net.minecraft.item.recipe;

import net.minecraft.block.core.Block;
import net.minecraft.item.core.Item;
import net.minecraft.item.core.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipes {
	private static final FurnaceRecipes smeltingBase = new FurnaceRecipes();
	private Map smeltingList = new HashMap();

	public static final FurnaceRecipes smelting() {
		return smeltingBase;
	}

	private FurnaceRecipes() {
		this.addSmelting(Block.oreIron.getBlockID(), new ItemStack(Item.ingotIron));
		this.addSmelting(Block.oreGold.getBlockID(), new ItemStack(Item.ingotGold));
		this.addSmelting(Block.oreDiamond.getBlockID(), new ItemStack(Item.diamond));
		this.addSmelting(Block.sand.getBlockID(), new ItemStack(Block.glass));
		this.addSmelting(Item.porkRaw.shiftedIndex, new ItemStack(Item.porkCooked));
		this.addSmelting(Item.fishRaw.shiftedIndex, new ItemStack(Item.fishCooked));
		this.addSmelting(Block.cobblestone.getBlockID(), new ItemStack(Block.stone));
		this.addSmelting(Item.clay.shiftedIndex, new ItemStack(Item.brick));
		this.addSmelting(Block.cactus.getBlockID(), new ItemStack(Item.dyePowder, 1, 2));
		this.addSmelting(Block.wood.getBlockID(), new ItemStack(Item.coal, 1, 1));
	}

	public void addSmelting(int var1, ItemStack var2) {
		this.smeltingList.put(Integer.valueOf(var1), var2);
	}

	public ItemStack getSmeltingResult(int var1) {
		return (ItemStack)this.smeltingList.get(Integer.valueOf(var1));
	}

	public Map getSmeltingList() {
		return this.smeltingList;
	}
}
