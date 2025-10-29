package net.minecraft.item;

import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipes {
	private static final FurnaceRecipes smeltingBase = new FurnaceRecipes();
	private Map smeltingList = new HashMap();

	public static final FurnaceRecipes smelting() {
		return smeltingBase;
	}

	private FurnaceRecipes() {
		this.addSmelting(net.minecraft.block.Block.oreIron.blockID, new ItemStack(Item.ingotIron));
		this.addSmelting(net.minecraft.block.Block.oreGold.blockID, new ItemStack(Item.ingotGold));
		this.addSmelting(net.minecraft.block.Block.oreDiamond.blockID, new ItemStack(Item.diamond));
		this.addSmelting(net.minecraft.block.Block.sand.blockID, new ItemStack(net.minecraft.block.Block.glass));
		this.addSmelting(Item.porkRaw.shiftedIndex, new ItemStack(Item.porkCooked));
		this.addSmelting(Item.fishRaw.shiftedIndex, new ItemStack(Item.fishCooked));
		this.addSmelting(net.minecraft.block.Block.cobblestone.blockID, new ItemStack(net.minecraft.block.Block.stone));
		this.addSmelting(Item.clay.shiftedIndex, new ItemStack(Item.brick));
		this.addSmelting(net.minecraft.block.Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2));
		this.addSmelting(Block.wood.blockID, new ItemStack(Item.coal, 1, 1));
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
