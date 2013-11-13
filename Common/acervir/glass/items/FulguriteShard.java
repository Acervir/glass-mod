package acervir.glass.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import acervir.glass.lib.Ids;
import acervir.glass.lib.Names;
import acervir.glass.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FulguriteShard extends Item
{

    public FulguriteShard(int par1)
    {
        super(Ids.FulguriteShard);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.MOD_ID + ":" + Names.FulguriteShard_unlocalizedName);
    }

}
