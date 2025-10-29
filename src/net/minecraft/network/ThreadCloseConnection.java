package net.minecraft.network;

public class ThreadCloseConnection extends Thread {
	final net.minecraft.network.NetworkManager field_28109_a;

	public ThreadCloseConnection(net.minecraft.network.NetworkManager var1) {
		this.field_28109_a = var1;
	}

	public void run() {
		try {
			Thread.sleep(2000L);
			if(net.minecraft.network.NetworkManager.isRunning(this.field_28109_a)) {
				NetworkManager.getWriteThread(this.field_28109_a).interrupt();
				this.field_28109_a.networkShutdown("disconnect.closed", new Object[0]);
			}
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}
}
