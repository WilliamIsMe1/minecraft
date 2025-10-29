package net.minecraft.achievement;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class AchievementList {
	public static int minDisplayColumn;
	public static int minDisplayRow;
	public static int maxDisplayColumn;
	public static int maxDisplayRow;
	public static List achievementList = new ArrayList();
	public static Achievement openInventory = (new Achievement(0, "openInventory", 0, 0, net.minecraft.item.Item.book, (Achievement)null)).func_27089_a().registerAchievement();
	public static Achievement mineWood = (new Achievement(1, "mineWood", 2, 1, net.minecraft.block.Block.wood, openInventory)).registerAchievement();
	public static Achievement buildWorkBench = (new Achievement(2, "buildWorkBench", 4, -1, net.minecraft.block.Block.workbench, mineWood)).registerAchievement();
	public static Achievement buildPickaxe = (new Achievement(3, "buildPickaxe", 4, 2, net.minecraft.item.Item.pickaxeWood, buildWorkBench)).registerAchievement();
	public static Achievement buildFurnace = (new Achievement(4, "buildFurnace", 3, 4, net.minecraft.block.Block.stoneOvenActive, buildPickaxe)).registerAchievement();
	public static Achievement acquireIron = (new Achievement(5, "acquireIron", 1, 4, net.minecraft.item.Item.ingotIron, buildFurnace)).registerAchievement();
	public static Achievement buildHoe = (new Achievement(6, "buildHoe", 2, -3, net.minecraft.item.Item.hoeWood, buildWorkBench)).registerAchievement();
	public static Achievement makeBread = (new Achievement(7, "makeBread", -1, -3, net.minecraft.item.Item.bread, buildHoe)).registerAchievement();
	public static Achievement bakeCake = (new Achievement(8, "bakeCake", 0, -5, net.minecraft.item.Item.cake, buildHoe)).registerAchievement();
	public static Achievement buildBetterPickaxe = (new Achievement(9, "buildBetterPickaxe", 6, 2, net.minecraft.item.Item.pickaxeStone, buildPickaxe)).registerAchievement();
	public static Achievement cookFish = (new Achievement(10, "cookFish", 2, 6, net.minecraft.item.Item.fishCooked, buildFurnace)).registerAchievement();
	public static Achievement onARail = (new Achievement(11, "onARail", 2, 3, Block.rail, acquireIron)).setSpecial().registerAchievement();
	public static Achievement buildSword = (new Achievement(12, "buildSword", 6, -1, net.minecraft.item.Item.swordWood, buildWorkBench)).registerAchievement();
	public static Achievement killEnemy = (new Achievement(13, "killEnemy", 8, -1, net.minecraft.item.Item.bone, buildSword)).registerAchievement();
	public static Achievement killCow = (new Achievement(14, "killCow", 7, -3, net.minecraft.item.Item.leather, buildSword)).registerAchievement();
	public static Achievement flyPig = (new Achievement(15, "flyPig", 8, -4, Item.saddle, killCow)).setSpecial().registerAchievement();

	public static void func_27374_a() {
	}

	static {
		System.out.println(achievementList.size() + " achievements");
	}
}
