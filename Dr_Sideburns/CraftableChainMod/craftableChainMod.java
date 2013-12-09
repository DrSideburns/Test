package Dr_Sideburns.CraftableChainMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; 
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Dr_SideburnsCraftableChain", name="Craftable Chainmail", version="1.0.0")
@NetworkMod(clientSideRequired=true)

public class craftableChainMod {
	
	public static Item chainLink;
	public static Item chainMail;
	
	@Instance(value = "Dr_SideburnsCraftableChain")
    public static craftableChainMod instance;
    
    @SidedProxy(clientSide="Dr_Sideburns.CraftableChainMod.client.ClientProxy", serverSide="Dr_Sideburns.craftableChainMod.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event) {
    	
    	chainLink = new CCItem(16221, 64, CreativeTabs.tabMaterials, 1, "chainLink", "craftablechainmod:chainlink");
    	chainMail = new CCItem(16222, 64, CreativeTabs.tabMaterials, 1, "chainMail", "craftablechainmod:chainmail");

}
    
    @EventHandler
	public void load (FMLInitializationEvent event) {
    	
    	LanguageRegistry.addName(chainLink, "Chain Link");
    	LanguageRegistry.addName(chainMail, "Chainmail");
    	
    	GameRegistry.addRecipe(new ItemStack(chainLink, 72), " x ", "x x", " x ", 'x', new ItemStack(Item.ingotIron));
    	GameRegistry.addRecipe(new ItemStack(chainMail), "xxx", "xxx", "xxx", 'x', new ItemStack(chainLink));
    	GameRegistry.addRecipe(new ItemStack(Item.helmetChain), "xxx", "x x", 'x', new ItemStack(chainMail));
    	GameRegistry.addRecipe(new ItemStack(Item.plateChain), "x x", "xxx", "xxx", 'x', new ItemStack(chainMail));
    	GameRegistry.addRecipe(new ItemStack(Item.legsChain), "xxx", "x x", "x x", 'x', new ItemStack(chainMail));
    	GameRegistry.addRecipe(new ItemStack(Item.bootsChain), "x x", "x x", 'x', new ItemStack(chainMail));
    	
    }
    
    @EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		
	}
}
