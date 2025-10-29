package net.minecraft.network;

public class PacketCounter {
	private int totalPackets;
	private long totalBytes;

	private PacketCounter() {
	}

	public void addPacket(int var1) {
		++this.totalPackets;
		this.totalBytes += (long)var1;
	}

	public PacketCounter(Empty1 var1) {
		this();
	}
}
