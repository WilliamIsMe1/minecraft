package net.minecraft.network;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet17Sleep;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet200Statistic;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet21PickupSpawn;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.network.packet.Packet23VehicleSpawn;
import net.minecraft.network.packet.Packet24MobSpawn;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet25EntityPainting;
import net.minecraft.network.packet.Packet27Position;
import net.minecraft.network.packet.Packet28EntityVelocity;
import net.minecraft.network.packet.Packet29DestroyEntity;
import net.minecraft.network.packet.Packet2Handshake;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet34EntityTeleport;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet39AttachEntity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet40EntityMetadata;
import net.minecraft.network.packet.Packet4UpdateTime;
import net.minecraft.network.packet.Packet50PreChunk;
import net.minecraft.network.packet.Packet51MapChunk;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.network.packet.Packet54PlayNoteBlock;
import net.minecraft.network.packet.Packet5PlayerInventory;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.network.packet.Packet61DoorChange;
import net.minecraft.network.packet.Packet6SpawnPosition;
import net.minecraft.network.packet.Packet70Bed;
import net.minecraft.network.packet.Packet71Weather;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet8UpdateHealth;
import net.minecraft.network.packet.Packet9Respawn;

public abstract class NetHandler {
	public abstract boolean isServerHandler();

	public void handleMapChunk(Packet51MapChunk var1) {
	}

	public void registerPacket(Packet var1) {
	}

	public void handleErrorMessage(String var1, Object[] var2) {
	}

	public void handleKickDisconnect(Packet255KickDisconnect var1) {
		this.registerPacket(var1);
	}

	public void handleLogin(Packet1Login var1) {
		this.registerPacket(var1);
	}

	public void handleFlying(Packet10Flying var1) {
		this.registerPacket(var1);
	}

	public void handleMultiBlockChange(Packet52MultiBlockChange var1) {
		this.registerPacket(var1);
	}

	public void handleBlockDig(Packet14BlockDig var1) {
		this.registerPacket(var1);
	}

	public void handleBlockChange(Packet53BlockChange var1) {
		this.registerPacket(var1);
	}

	public void handlePreChunk(Packet50PreChunk var1) {
		this.registerPacket(var1);
	}

	public void handleNamedEntitySpawn(Packet20NamedEntitySpawn var1) {
		this.registerPacket(var1);
	}

	public void handleEntity(Packet30Entity var1) {
		this.registerPacket(var1);
	}

	public void handleEntityTeleport(Packet34EntityTeleport var1) {
		this.registerPacket(var1);
	}

	public void handlePlace(Packet15Place var1) {
		this.registerPacket(var1);
	}

	public void handleBlockItemSwitch(Packet16BlockItemSwitch var1) {
		this.registerPacket(var1);
	}

	public void handleDestroyEntity(Packet29DestroyEntity var1) {
		this.registerPacket(var1);
	}

	public void handlePickupSpawn(Packet21PickupSpawn var1) {
		this.registerPacket(var1);
	}

	public void handleCollect(Packet22Collect var1) {
		this.registerPacket(var1);
	}

	public void handleChat(Packet3Chat var1) {
		this.registerPacket(var1);
	}

	public void handleVehicleSpawn(Packet23VehicleSpawn var1) {
		this.registerPacket(var1);
	}

	public void handleArmAnimation(Packet18Animation var1) {
		this.registerPacket(var1);
	}

	public void func_21147_a(Packet19EntityAction var1) {
		this.registerPacket(var1);
	}

	public void handleHandshake(Packet2Handshake var1) {
		this.registerPacket(var1);
	}

	public void handleMobSpawn(Packet24MobSpawn var1) {
		this.registerPacket(var1);
	}

	public void handleUpdateTime(Packet4UpdateTime var1) {
		this.registerPacket(var1);
	}

	public void handleSpawnPosition(Packet6SpawnPosition var1) {
		this.registerPacket(var1);
	}

	public void func_6498_a(Packet28EntityVelocity var1) {
		this.registerPacket(var1);
	}

	public void func_21148_a(Packet40EntityMetadata var1) {
		this.registerPacket(var1);
	}

	public void func_6497_a(Packet39AttachEntity var1) {
		this.registerPacket(var1);
	}

	public void handleUseEntity(Packet7UseEntity var1) {
		this.registerPacket(var1);
	}

	public void func_9447_a(Packet38EntityStatus var1) {
		this.registerPacket(var1);
	}

	public void handleHealth(Packet8UpdateHealth var1) {
		this.registerPacket(var1);
	}

	public void func_9448_a(Packet9Respawn var1) {
		this.registerPacket(var1);
	}

	public void func_12245_a(Packet60Explosion var1) {
		this.registerPacket(var1);
	}

	public void func_20087_a(Packet100OpenWindow var1) {
		this.registerPacket(var1);
	}

	public void func_20092_a(Packet101CloseWindow var1) {
		this.registerPacket(var1);
	}

	public void func_20091_a(Packet102WindowClick var1) {
		this.registerPacket(var1);
	}

	public void func_20088_a(Packet103SetSlot var1) {
		this.registerPacket(var1);
	}

	public void func_20094_a(Packet104WindowItems var1) {
		this.registerPacket(var1);
	}

	public void handleSignUpdate(Packet130UpdateSign var1) {
		this.registerPacket(var1);
	}

	public void func_20090_a(Packet105UpdateProgressbar var1) {
		this.registerPacket(var1);
	}

	public void handlePlayerInventory(Packet5PlayerInventory var1) {
		this.registerPacket(var1);
	}

	public void func_20089_a(Packet106Transaction var1) {
		this.registerPacket(var1);
	}

	public void func_21146_a(Packet25EntityPainting var1) {
		this.registerPacket(var1);
	}

	public void handleNotePlay(Packet54PlayNoteBlock var1) {
		this.registerPacket(var1);
	}

	public void func_27245_a(Packet200Statistic var1) {
		this.registerPacket(var1);
	}

	public void func_22186_a(Packet17Sleep var1) {
		this.registerPacket(var1);
	}

	public void func_22185_a(Packet27Position var1) {
		this.registerPacket(var1);
	}

	public void func_25118_a(Packet70Bed var1) {
		this.registerPacket(var1);
	}

	public void handleWeather(Packet71Weather var1) {
		this.registerPacket(var1);
	}

	public void func_28116_a(Packet131MapData var1) {
		this.registerPacket(var1);
	}

	public void func_28115_a(Packet61DoorChange var1) {
		this.registerPacket(var1);
	}
}
