package net.minecraft.block;

public class StepSound {
	public final String soundId;
	public final float volume;
	public final float pitch;

	public StepSound(String soundId, float volume, float pitch) {
		this.soundId = soundId;
		this.volume = volume;
		this.pitch = pitch;
	}

	public float getVolume() {
		return this.volume;
	}

	public float getPitch() {
		return this.pitch;
	}

	public String stepSoundDir() {
		return "step." + this.soundId;
	}

	public String func_1145_d() {
		return "step." + this.soundId;
	}
}
