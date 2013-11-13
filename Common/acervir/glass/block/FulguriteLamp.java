package acervir.glass.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import acervir.glass.lib.Ids;
import acervir.glass.lib.Names;
import acervir.glass.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class FulguriteLamp extends Block
{

    public FulguriteLamp(int par1)
    {
        super(Ids.FulguriteLamp, Material.redstoneLight);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3F);
        this.setResistance(2F);
        this.setLightValue(1F);
        this.setUnlocalizedName(Names.FulguriteLamp_unlocalizedName);
        this.setStepSound(Block.soundGlassFootstep);
    }
    
    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffest)
    {
        
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon)
    {
        blockIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.FulguriteLamp_unlocalizedName);
    }
}
