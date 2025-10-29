package net.minecraft.client.render;

public class SignModel {
	public net.minecraft.client.render.ModelRenderer signBoard = new net.minecraft.client.render.ModelRenderer(0, 0);
	public net.minecraft.client.render.ModelRenderer signStick;

	public SignModel() {
		this.signBoard.addBox(-12.0F, -14.0F, -1.0F, 24, 12, 2, 0.0F);
		this.signStick = new ModelRenderer(0, 14);
		this.signStick.addBox(-1.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
	}

	public void func_887_a() {
		this.signBoard.render(1.0F / 16.0F);
		this.signStick.render(1.0F / 16.0F);
	}
}
