package acervir.glass.block;

import acervir.glass.lib.Ids;
import acervir.glass.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LightBlock extends Block
{
    public LightBlock(int par1)
    {
        super(Ids.LightBlock, Material.air);
        this.setLightValue(0.8F);
        this.setUnlocalizedName(Names.LightBlock_unlocalizedName);
    }
    
    public boolean isAirBlock()
    {
        return true;
    }
}