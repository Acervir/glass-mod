package acervir.glass.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import acervir.glass.lib.Names;
import acervir.glass.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class blockVitrifiedSoil extends Block 
{
       
    public blockVitrifiedSoil(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2F);
        this.setResistance(5F);
        this.setUnlocalizedName(Names.blockVitrifiedSoil_unlocalizedName);
        this.setStepSound(Block.soundGravelFootstep);
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
        topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.blockVitrifiedSoil_unlocalizedName + "_top");
        bottomIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.blockVitrifiedSoil_unlocalizedName + "_bottom");
        sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.blockVitrifiedSoil_unlocalizedName+ "_side");
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