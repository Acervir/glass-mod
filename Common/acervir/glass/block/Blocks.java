package acervir.glass.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import acervir.glass.lib.Ids;
import acervir.glass.lib.Names;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

public class Blocks
{

    public static Block block;
    public static Block Fulgurite;
    public static Block FulguriteLamp;
    
    public static void init() 
    {
        block = new blockVitrifiedSoil(Ids.blockVitrifiedSoil);
        GameRegistry.registerBlock(block, Names.blockVitrifiedSoil_name);
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 2);
        Fulgurite = new Fulgurite(Ids.Fulgurite);
        GameRegistry.registerBlock(Fulgurite, Names.Fulgurite_name);
        MinecraftForge.setBlockHarvestLevel(Fulgurite, "pickaxe", 2);
        FulguriteLamp = new FulguriteLamp(Ids.FulguriteLamp);
        GameRegistry.registerBlock(FulguriteLamp, Names.FulguriteLamp_name);
        }
    
    public static void addNames() 
    {
        LanguageRegistry.addName(block, Names.blockVitrifiedSoil_name);
        LanguageRegistry.addName(Fulgurite, Names.Fulgurite_name);
        LanguageRegistry.addName(FulguriteLamp, Names.FulguriteLamp_name);
    }
}
