package net.minecraft.isom;

import java.applet.Applet;
import java.awt.BorderLayout;
import net.minecraft.client.render.canvas.CanvasIsomPreview;

public class IsomPreviewApplet extends Applet {
	private CanvasIsomPreview a = new CanvasIsomPreview();

	public IsomPreviewApplet() {
		this.setLayout(new BorderLayout());
		this.add(this.a, "Center");
	}

	public void start() {
		this.a.func_1272_b();
	}

	public void stop() {
		this.a.exit();
	}
}
