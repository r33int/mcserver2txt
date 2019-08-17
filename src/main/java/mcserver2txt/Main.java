package mcserver2txt;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "mcserver2txt";
    public static final String VERSION = "1.0.2";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	rEventHandler handler = new rEventHandler();
    	MinecraftForge.EVENT_BUS.register(handler);
    	FMLCommonHandler.instance().bus().register(handler);
    	rEventHandler.deleteFile();
    }
}