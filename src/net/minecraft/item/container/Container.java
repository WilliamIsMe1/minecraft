package net.minecraft.item.container;

import net.minecraft.item.container.inventory.Slot;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.item.recipe.ICrafting;
import net.minecraft.item.container.inventory.IInventory;
import net.minecraft.item.container.inventory.InventoryPlayer;
import net.minecraft.item.core.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Container {
	public List<ItemStack> inventoryItemStacks = new ArrayList<>();
	public List<Slot> inventorySlots = new ArrayList<>();
	public int windowId = 0;
	private short field_20132_a = 0;
	protected List<ICrafting> crafters = new ArrayList<>();
	private Set<EntityPlayer> field_20131_b = new HashSet<>();

	protected void addSlot(Slot var1) {
		var1.slotNumber = this.inventorySlots.size();
		this.inventorySlots.add(var1);
		this.inventoryItemStacks.add(null);
	}

	public void updateCraftingResults() {
		for(int var1 = 0; var1 < this.inventorySlots.size(); var1++) {
			ItemStack var2 = this.inventorySlots.get(var1).getStack();
			ItemStack var3 = this.inventoryItemStacks.get(var1);
			if(!ItemStack.areItemStacksEqual(var3, var2)) {
				var3 = var2 == null ? null : var2.copy();
				this.inventoryItemStacks.set(var1, var3);

				for (ICrafting o : this.crafters) {
					o.updateCraftingInventorySlot(this, var1, var3);
				}
			}
		}

	}

	public void onCraftGuiOpened(ICrafting var1) {
		if(this.crafters.contains(var1)) {
			throw new IllegalArgumentException("Listener already listening");
		} else {
			this.crafters.add(var1);
			var1.updateCraftingInventory(this, this.getItemStacks());
			this.updateCraftingResults();
		}
	}

	public List<ItemStack> getItemStacks() {
		ArrayList<ItemStack> var1 = new ArrayList<>();

		for (Slot inventorySlot : this.inventorySlots) {
			var1.add(inventorySlot.getStack());
		}

		return var1;
	}

	public Slot getSlot(int var1) {
		return this.inventorySlots.get(var1);
	}

	public ItemStack getStackInSlot(int var1) {
		Slot var2 = this.inventorySlots.get(var1);
		return var2 != null ? var2.getStack() : null;
	}

	public ItemStack somethingToDoWithDroppingItems(int slotToDrop, int someItemTagThing, boolean var3, EntityPlayer player) {
		ItemStack var5 = null;
		if(someItemTagThing == 0 || someItemTagThing == 1) {
			InventoryPlayer inventory = player.inventory;
			if(inventory.getItemStack() != null && slotToDrop == -999) {
				if(someItemTagThing == 0) {
					player.dropPlayerItem(inventory.getItemStack());
					inventory.setItemStack(null);
				}

				if(someItemTagThing == 1) {
					player.dropPlayerItem(inventory.getItemStack().splitStack(1));
					if(inventory.getItemStack().stackSize == 0) {
						inventory.setItemStack(null);
					}
				}
			} else {
				int var10;
				if(var3) {
					ItemStack stack = this.getStackInSlot(slotToDrop);
					if(stack != null) {
						int currentStackSize = stack.stackSize;
						var5 = stack.copy();
						Slot slotWeReDropping = this.inventorySlots.get(slotToDrop);
						if(slotWeReDropping != null && slotWeReDropping.getStack() != null) {
							var10 = slotWeReDropping.getStack().stackSize;
							if(var10 < currentStackSize) {
								this.somethingToDoWithDroppingItems(slotToDrop, someItemTagThing, true, player);
							}
						}
					}
				} else {
					Slot var12 = this.inventorySlots.get(slotToDrop);
					if(var12 != null) {
						var12.onSlotChanged();
						ItemStack var13 = var12.getStack();
						ItemStack var14 = inventory.getItemStack();
						if(var13 != null) {
							var5 = var13.copy();
						}

						if(var13 == null) {
							if(var14 != null && var12.isItemValid(var14)) {
								var10 = someItemTagThing == 0 ? var14.stackSize : 1;
								if(var10 > var12.getSlotStackLimit()) {
									var10 = var12.getSlotStackLimit();
								}

								var12.putStack(var14.splitStack(var10));
								if(var14.stackSize == 0) {
									inventory.setItemStack((ItemStack)null);
								}
							}
						} else if(var14 == null) {
							var10 = someItemTagThing == 0 ? var13.stackSize : (var13.stackSize + 1) / 2;
							ItemStack var11 = var12.decrStackSize(var10);
							inventory.setItemStack(var11);
							if(var13.stackSize == 0) {
								var12.putStack((ItemStack)null);
							}

							var12.onPickupFromSlot(inventory.getItemStack());
						} else if(var12.isItemValid(var14)) {
							if(var13.itemID != var14.itemID || var13.getHasSubtypes() && var13.getItemDamage() != var14.getItemDamage()) {
								if(var14.stackSize <= var12.getSlotStackLimit()) {
									var12.putStack(var14);
									inventory.setItemStack(var13);
								}
							} else {
								var10 = someItemTagThing == 0 ? var14.stackSize : 1;
								if(var10 > var12.getSlotStackLimit() - var13.stackSize) {
									var10 = var12.getSlotStackLimit() - var13.stackSize;
								}

								if(var10 > var14.getMaxStackSize() - var13.stackSize) {
									var10 = var14.getMaxStackSize() - var13.stackSize;
								}

								var14.splitStack(var10);
								if(var14.stackSize == 0) {
									inventory.setItemStack((ItemStack)null);
								}

								var13.stackSize += var10;
							}
						} else if(var13.itemID == var14.itemID && var14.getMaxStackSize() > 1 && (!var13.getHasSubtypes() || var13.getItemDamage() == var14.getItemDamage())) {
							var10 = var13.stackSize;
							if(var10 > 0 && var10 + var14.stackSize <= var14.getMaxStackSize()) {
								var14.stackSize += var10;
								var13.splitStack(var10);
								if(var13.stackSize == 0) {
									var12.putStack((ItemStack)null);
								}

								var12.onPickupFromSlot(inventory.getItemStack());
							}
						}
					}
				}
			}
		}

		return var5;
	}

	public void onCraftGuiClosed(EntityPlayer var1) {
		InventoryPlayer var2 = var1.inventory;
		if(var2.getItemStack() != null) {
			var1.dropPlayerItem(var2.getItemStack());
			var2.setItemStack(null);
		}

	}

	public void onCraftMatrixChanged(IInventory var1) {
		this.updateCraftingResults();
	}

	public void putStackInSlot(int var1, ItemStack var2) {
		this.getSlot(var1).putStack(var2);
	}

	public void putStacksInSlots(ItemStack[] var1) {
		for(int var2 = 0; var2 < var1.length; ++var2) {
			this.getSlot(var2).putStack(var1[var2]);
		}

	}

	public void func_20112_a(int var1, int var2) {
	}

	public short func_20111_a(InventoryPlayer var1) {
		++this.field_20132_a;
		return this.field_20132_a;
	}

	public void func_20113_a(short var1) {
	}

	public void func_20110_b(short var1) {
	}

	public Slot func_20127_a(IInventory var1, int var2) {
		for (Slot var4 : this.inventorySlots) {
			if (var4.isHere(var1, var2)) {
				return var4;
			}
		}

		return null;
	}

	public boolean getCanCraft(EntityPlayer var1) {
		return !this.field_20131_b.contains(var1);
	}

	public void setCanCraft(EntityPlayer var1, boolean var2) {
		if(var2) {
			this.field_20131_b.remove(var1);
		} else {
			this.field_20131_b.add(var1);
		}

	}

	public abstract boolean canInteractWith(EntityPlayer var1);

	protected void func_28125_a(ItemStack var1, int var2, int var3, boolean var4) {
		int var5 = var2;
		if(var4) {
			var5 = var3 - 1;
		}

		Slot slot;
		ItemStack currentStack;
		if(var1.isStackable()) {
			while(var1.stackSize > 0 && (!var4 && var5 < var3 || var4 && var5 >= var2)) {
				slot = this.inventorySlots.get(var5);
				currentStack = slot.getStack();
				if(currentStack != null && currentStack.itemID == var1.itemID && (!var1.getHasSubtypes() || var1.getItemDamage() == currentStack.getItemDamage())) {
					int var8 = currentStack.stackSize + var1.stackSize;
					if(var8 <= var1.getMaxStackSize()) {
						var1.stackSize = 0;
						currentStack.stackSize = var8;
						slot.onSlotChanged();
					} else if(currentStack.stackSize < var1.getMaxStackSize()) {
						var1.stackSize -= var1.getMaxStackSize() - currentStack.stackSize;
						currentStack.stackSize = var1.getMaxStackSize();
						slot.onSlotChanged();
					}
				}

				if(var4) {
					--var5;
				} else {
					++var5;
				}
			}
		}

		if(var1.stackSize > 0) {
			if(var4) {
				var5 = var3 - 1;
			} else {
				var5 = var2;
			}

			while(!var4 && var5 < var3 || var4 && var5 >= var2) {
				slot = this.inventorySlots.get(var5);
				currentStack = slot.getStack();
				if(currentStack == null) {
					slot.putStack(var1.copy());
					slot.onSlotChanged();
					var1.stackSize = 0;
					break;
				}

				if(var4) {
					--var5;
				} else {
					++var5;
				}
			}
		}

	}
}
