package acervir.glass;

import acervir.glass.block.Blocks;
import acervir.glass.items.Items;
import acervir.glass.lib.Recipes;
import acervir.glass.lib.Reference;
import acervir.glass.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod( channels = {Reference.CHANNEL}, clientSideRequired = true, serverSideRequired = true)

public class glass {
    
    @Instance(Reference.MOD_ID)
    public static glass instance;
    
    @SidedProxy(clientSide = "acervir.glass.proxy.ClientProxy", serverSide = "avervir.glass.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
        proxy.initRenderers();
        proxy.initSounds();
        
        Blocks.init();
        Blocks.addNames();
        
        Items.init();
        Items.addNames();
        
        Recipes.init();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}