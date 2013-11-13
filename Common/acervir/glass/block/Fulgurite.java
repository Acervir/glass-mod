package acervir.glass.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import acervir.glass.lib.Ids;
import acervir.glass.lib.Names;
import acervir.glass.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class Fulgurite extends Block
    
{
        
    public Fulgurite(int par1)
    {
        super(Ids.Fulgurite, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(15F);
        this.setResistance(2F);
        this.setLightValue(0.5F);
        this.setUnlocalizedName(Names.Fulgurite_unlocalizedName);
        this.setStepSound(Block.soundGlassFootstep);
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 2;
    }
    
    public int idDropped(int par1, Random random, int zero)
    {
        return Ids.FulguriteShard + 256;
    }
    
    @SideOnly(Side.CLIENT)
    public static Icon topIcon;
    
    @SideOnly(Side.CLIENT)
    public static Icon bottomIcon;
    
    @SideOnly(Side.CLIENT)
    public static Icon sideIcon;
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon) {
        topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.Fulgurite_unlocalizedName + "_top");
        bottomIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.Fulgurite_unlocalizedName + "_bottom");
        sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.Fulgurite_unlocalizedName + "_side");
        
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
        
        if(side == 0) {
            return bottomIcon;
        } else if(side == 1) {
            return topIcon;
        } else {
            return sideIcon;
        }
    }
}
