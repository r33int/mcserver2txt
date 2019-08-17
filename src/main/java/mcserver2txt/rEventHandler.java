package mcserver2txt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;



public class rEventHandler {
	
	public static void deleteFile() {
		File f = new File ("myserver.txt");
		if (f.exists()) {
			f.delete();
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void connectedToServer(ClientConnectedToServerEvent e) {
		System.out.println("connected to server");
		String currentServer=(Minecraft.getMinecraft().getCurrentServerData().serverIP);
		System.out.println(currentServer);
		
		try {
			deleteFile();
			FileWriter writer = new FileWriter("myserver.txt", true);
				writer.write(currentServer);
				writer.close();
			} catch (IOException er) {
				er.printStackTrace();
		}
	}
	
	@SubscribeEvent
	public void disconnectedFromServer(ClientDisconnectionFromServerEvent e) {
		System.out.println("disconnected from server");
		deleteFile();
	}
	
	protected void finalize() {
		deleteFile();
	}

}