package net.minecraft.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapelessRecipes implements IRecipe {
	private final net.minecraft.item.ItemStack recipeOutput;
	private final List recipeItems;

	public ShapelessRecipes(net.minecraft.item.ItemStack var1, List var2) {
		this.recipeOutput = var1;
		this.recipeItems = var2;
	}

	public net.minecraft.item.ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	public boolean matches(net.minecraft.item.InventoryCrafting var1) {
		ArrayList var2 = new ArrayList(this.recipeItems);

		for(int var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 3; ++var4) {
				net.minecraft.item.ItemStack var5 = var1.func_21103_b(var4, var3);
				if(var5 != null) {
					boolean var6 = false;
					Iterator var7 = var2.iterator();

					while(var7.hasNext()) {
						net.minecraft.item.ItemStack var8 = (net.minecraft.item.ItemStack)var7.next();
						if(var5.itemID == var8.itemID && (var8.getItemDamage() == -1 || var5.getItemDamage() == var8.getItemDamage())) {
							var6 = true;
							var2.remove(var8);
							break;
						}
					}

					if(!var6) {
						return false;
					}
				}
			}
		}

		return var2.isEmpty();
	}

	public ItemStack getCraftingResult(InventoryCrafting var1) {
		return this.recipeOutput.copy();
	}

	public int getRecipeSize() {
		return this.recipeItems.size();
	}
}
