package acervir.glass.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import acervir.glass.lib.Ids;
import acervir.glass.lib.Names;
import net.minecraft.item.Item;

public class Items
{
    public static Item FulguriteShard;
    
    public static void init()
    {
        FulguriteShard = new FulguriteShard(Ids.FulguriteShard);
    }
    
    public static void addNames()
    {
        LanguageRegistry.addName(FulguriteShard, Names.FulguriteShard_name);
    }
}
