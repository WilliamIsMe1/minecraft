package net.minecraft.network;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.gui.GuiConnectFailed;
import net.minecraft.client.render.gui.GuiConnecting;
import net.minecraft.network.packet.Packet2Handshake;

public class ThreadConnectToServer extends Thread {
	final Minecraft mc;
	final String hostName;
	final int port;
	final net.minecraft.client.render.gui.GuiConnecting connectingGui;

	public ThreadConnectToServer(net.minecraft.client.render.gui.GuiConnecting var1, Minecraft var2, String var3, int var4) {
		this.connectingGui = var1;
		this.mc = var2;
		this.hostName = var3;
		this.port = var4;
	}

	public void run() {
		try {
			net.minecraft.client.render.gui.GuiConnecting.setNetClientHandler(this.connectingGui, new NetClientHandler(this.mc, this.hostName, this.port));
			if(net.minecraft.client.render.gui.GuiConnecting.isCancelled(this.connectingGui)) {
				return;
			}

			net.minecraft.client.render.gui.GuiConnecting.getNetClientHandler(this.connectingGui).addToSendQueue(new Packet2Handshake(this.mc.session.username));
		} catch (UnknownHostException var2) {
			if(net.minecraft.client.render.gui.GuiConnecting.isCancelled(this.connectingGui)) {
				return;
			}

			this.mc.displayGuiScreen(new net.minecraft.client.render.gui.GuiConnectFailed("connect.failed", "disconnect.genericReason", "Unknown host '" + this.hostName + "'"));
		} catch (ConnectException var3) {
			if(net.minecraft.client.render.gui.GuiConnecting.isCancelled(this.connectingGui)) {
				return;
			}

			this.mc.displayGuiScreen(new net.minecraft.client.render.gui.GuiConnectFailed("connect.failed", "disconnect.genericReason", var3.getMessage()));
		} catch (Exception var4) {
			if(GuiConnecting.isCancelled(this.connectingGui)) {
				return;
			}

			var4.printStackTrace();
			this.mc.displayGuiScreen(new GuiConnectFailed("connect.failed", "disconnect.genericReason", var4.toString()));
		}

	}
}
