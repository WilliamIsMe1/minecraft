package net.minecraft.src;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Session {
	public static List registeredBlocksList = new ArrayList();
	public String username;
	public String sessionId;
	public String mpPassParameter;

	public Session(String var1, String var2) {
		this.username = var1;
		this.sessionId = var2;
	}

	static {
		registeredBlocksList.add(net.minecraft.block.Block.stone);
		registeredBlocksList.add(net.minecraft.block.Block.cobblestone);
		registeredBlocksList.add(net.minecraft.block.Block.brick);
		registeredBlocksList.add(net.minecraft.block.Block.dirt);
		registeredBlocksList.add(net.minecraft.block.Block.planks);
		registeredBlocksList.add(net.minecraft.block.Block.wood);
		registeredBlocksList.add(net.minecraft.block.Block.leaves);
		registeredBlocksList.add(net.minecraft.block.Block.torchWood);
		registeredBlocksList.add(net.minecraft.block.Block.stairSingle);
		registeredBlocksList.add(net.minecraft.block.Block.glass);
		registeredBlocksList.add(net.minecraft.block.Block.cobblestoneMossy);
		registeredBlocksList.add(net.minecraft.block.Block.sapling);
		registeredBlocksList.add(net.minecraft.block.Block.plantYellow);
		registeredBlocksList.add(net.minecraft.block.Block.plantRed);
		registeredBlocksList.add(net.minecraft.block.Block.mushroomBrown);
		registeredBlocksList.add(net.minecraft.block.Block.mushroomRed);
		registeredBlocksList.add(net.minecraft.block.Block.sand);
		registeredBlocksList.add(net.minecraft.block.Block.gravel);
		registeredBlocksList.add(net.minecraft.block.Block.sponge);
		registeredBlocksList.add(net.minecraft.block.Block.cloth);
		registeredBlocksList.add(net.minecraft.block.Block.oreCoal);
		registeredBlocksList.add(net.minecraft.block.Block.oreIron);
		registeredBlocksList.add(net.minecraft.block.Block.oreGold);
		registeredBlocksList.add(net.minecraft.block.Block.blockSteel);
		registeredBlocksList.add(net.minecraft.block.Block.blockGold);
		registeredBlocksList.add(net.minecraft.block.Block.bookShelf);
		registeredBlocksList.add(net.minecraft.block.Block.tnt);
		registeredBlocksList.add(Block.obsidian);
	}
}
