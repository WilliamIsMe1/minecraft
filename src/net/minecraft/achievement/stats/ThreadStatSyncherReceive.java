package net.minecraft.achievement.stats;

public class ThreadStatSyncherReceive extends Thread {
	final net.minecraft.achievement.stats.StatsSyncher field_27231_a;

	public ThreadStatSyncherReceive(net.minecraft.achievement.stats.StatsSyncher var1) {
		this.field_27231_a = var1;
	}

	public void run() {
		try {
			if(net.minecraft.achievement.stats.StatsSyncher.func_27422_a(this.field_27231_a) != null) {
				net.minecraft.achievement.stats.StatsSyncher.func_27412_a(this.field_27231_a, net.minecraft.achievement.stats.StatsSyncher.func_27422_a(this.field_27231_a), net.minecraft.achievement.stats.StatsSyncher.func_27423_b(this.field_27231_a), net.minecraft.achievement.stats.StatsSyncher.func_27411_c(this.field_27231_a), net.minecraft.achievement.stats.StatsSyncher.func_27413_d(this.field_27231_a));
			} else if(net.minecraft.achievement.stats.StatsSyncher.func_27423_b(this.field_27231_a).exists()) {
				net.minecraft.achievement.stats.StatsSyncher.func_27421_a(this.field_27231_a, net.minecraft.achievement.stats.StatsSyncher.func_27409_a(this.field_27231_a, net.minecraft.achievement.stats.StatsSyncher.func_27423_b(this.field_27231_a), net.minecraft.achievement.stats.StatsSyncher.func_27411_c(this.field_27231_a), net.minecraft.achievement.stats.StatsSyncher.func_27413_d(this.field_27231_a)));
			}
		} catch (Exception var5) {
			var5.printStackTrace();
		} finally {
			StatsSyncher.func_27416_a(this.field_27231_a, false);
		}

	}
}
