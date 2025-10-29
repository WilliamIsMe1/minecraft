package net.minecraft.isom;

import net.minecraft.client.render.CanvasIsomPreview;

public class ThreadRunIsoClient extends Thread {
	final net.minecraft.client.render.CanvasIsomPreview isoCanvas;

	public ThreadRunIsoClient(net.minecraft.client.render.CanvasIsomPreview var1) {
		this.isoCanvas = var1;
	}

	public void run() {
		while(CanvasIsomPreview.isRunning(this.isoCanvas)) {
			this.isoCanvas.showNextBuffer();

			try {
				Thread.sleep(1L);
			} catch (Exception var2) {
			}
		}

	}
}
