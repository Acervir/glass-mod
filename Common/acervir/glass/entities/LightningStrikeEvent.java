package acervir.glass.entities;

import java.util.List;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import acervir.glass.lib.Ids;

public class LightningStrikeEvent extends EntityWeatherEffect
{   
    public int lightningState;
    public long boltVertex;
    public int boltLivingTime;
        
    public LightningStrikeEvent(World par1World, double par2, double par4,
            double par6)
    {
        super(par1World);
        this.setLocationAndAngles(par2, par4, par6, 0.0F, 0.0F);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
        
        if (!par1World.isRemote && par1World.difficultySetting >= 2 && par1World.doChunksNearChunkExist(MathHelper.floor_double(par2), MathHelper.floor_double(par4), MathHelper.floor_double(par6), 10))
        {
            int i = MathHelper.floor_double(par2);
            int j = MathHelper.floor_double(par4);
            int k = MathHelper.floor_double(par6);
            
            if (par1World.getBlockId(i, j, k) == 0 && Block.fire.canPlaceBlockAt(par1World, i, j, k))
            {
                par1World.setBlock(i, j - 1, k, Ids.Fulgurite);
            }
            
            for (i = 0; i < 4; ++i)
            {
                j = MathHelper.floor_double(par2) + this.rand.nextInt(3) - 1;
                k = MathHelper.floor_double(par4) + this.rand.nextInt(3) - 1;
                int l = MathHelper.floor_double(par6) + this.rand.nextInt(3) - 1;
                
                if (par1World.getBlockId(j, k, l) == 0 && Block.fire.canPlaceBlockAt(par1World, j, k, l))
                {
                    par1World.setBlock(j, k - 1, l, Ids.Fulgurite);
                }
            }
        }
    }
    public void onUpdate()
    {
        super.onUpdate();

        if (this.lightningState == 2)
        {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0F, 0.5F + this.rand.nextFloat() * 0.2F);
        }

        --this.lightningState;

        if (this.lightningState < 0)
        {
            if (this.boltLivingTime == 0)
            {
                this.setDead();
            }
            else if (this.lightningState < -this.rand.nextInt(10))
            {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.rand.nextLong();

                if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doFireTick") && this.worldObj.doChunksNearChunkExist(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 10))
                {
                    int i = MathHelper.floor_double(this.posX);
                    int j = MathHelper.floor_double(this.posY);
                    int k = MathHelper.floor_double(this.posZ);

                    if (this.worldObj.getBlockId(i, j, k) == 0 && Block.fire.canPlaceBlockAt(this.worldObj, i, j, k))
                    {
                        this.worldObj.setBlock(i, j, k, Block.fire.blockID);
                    }
                }
            }
        }

        if (this.lightningState >= 0)
        {
            if (this.worldObj.isRemote)
            {
                this.worldObj.lastLightningBolt = 2;
            }
            else
            {
                double d0 = 3.0D;
                @SuppressWarnings({ "rawtypes", "unused" })
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getAABBPool().getAABB(this.posX - d0, this.posY - d0, this.posZ - d0, this.posX + d0, this.posY + 6.0D + d0, this.posZ + d0));
            }
        }
    }
    

    public void entityInit()
    {
        
        EntityRegistry.registerModEntity(null, null, boltLivingTime, getEntityRiderPitchDelta(), boltLivingTime, boltLivingTime, addedToChunk);
        {
            
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {

    }
    
    public boolean isInRangeToRenderVec3D(Vec3 par1Vec3)
    {
        return this.lightningState >= 0;
    }
}
