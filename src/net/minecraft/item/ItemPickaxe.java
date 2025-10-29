package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.src.EnumToolMaterial;

public class ItemPickaxe extends ItemTool {
	private static net.minecraft.block.Block[] blocksEffectiveAgainst = new net.minecraft.block.Block[]{net.minecraft.block.Block.cobblestone, net.minecraft.block.Block.stairDouble, net.minecraft.block.Block.stairSingle, net.minecraft.block.Block.stone, net.minecraft.block.Block.sandStone, net.minecraft.block.Block.cobblestoneMossy, net.minecraft.block.Block.oreIron, net.minecraft.block.Block.blockSteel, net.minecraft.block.Block.oreCoal, net.minecraft.block.Block.blockGold, net.minecraft.block.Block.oreGold, net.minecraft.block.Block.oreDiamond, net.minecraft.block.Block.blockDiamond, net.minecraft.block.Block.ice, net.minecraft.block.Block.netherrack, net.minecraft.block.Block.oreLapis, net.minecraft.block.Block.blockLapis};

	protected ItemPickaxe(int var1, EnumToolMaterial var2) {
		super(var1, 2, var2, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(net.minecraft.block.Block var1) {
		return var1 == net.minecraft.block.Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (var1 != net.minecraft.block.Block.blockDiamond && var1 != net.minecraft.block.Block.oreDiamond ? (var1 != net.minecraft.block.Block.blockGold && var1 != net.minecraft.block.Block.oreGold ? (var1 != net.minecraft.block.Block.blockSteel && var1 != net.minecraft.block.Block.oreIron ? (var1 != net.minecraft.block.Block.blockLapis && var1 != net.minecraft.block.Block.oreLapis ? (var1 != net.minecraft.block.Block.oreRedstone && var1 != Block.oreRedstoneGlowing ? (var1.blockMaterial == net.minecraft.block.Material.rock ? true : var1.blockMaterial == Material.iron) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
	}
}
