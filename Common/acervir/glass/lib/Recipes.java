package acervir.glass.lib;

import acervir.glass.block.Blocks;
import acervir.glass.items.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class Recipes
{
    
    public static void init()
    {
        CraftingManager.getInstance().addRecipe(new ItemStack(Blocks.FulguriteLamp, 1),
        "FFF",
        "FFF",
        "FFF",
        Character.valueOf('F'), Items.FulguriteShard);
    }
}
