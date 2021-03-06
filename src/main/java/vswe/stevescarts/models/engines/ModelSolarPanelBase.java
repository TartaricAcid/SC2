package vswe.stevescarts.models.engines;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vswe.stevescarts.helpers.ResourceHelper;
import vswe.stevescarts.modules.ModuleBase;

@SideOnly(Side.CLIENT)
public class ModelSolarPanelBase extends ModelSolarPanel {
	private static ResourceLocation texture;

	@Override
	public ResourceLocation getResource(final ModuleBase module) {
		return ModelSolarPanelBase.texture;
	}

	@Override
	protected int getTextureWidth() {
		return 32;
	}

	@Override
	protected int getTextureHeight() {
		return 32;
	}

	public ModelSolarPanelBase() {
		final ModelRenderer base = new ModelRenderer(this, 0, 0);
		this.AddRenderer(base);
		base.addBox(-1.0f, -5.0f, -1.0f, 2, 10, 2, 0.0f);
		base.setRotationPoint(0.0f, -4.5f, 0.0f);
		final ModelRenderer moving = this.createMovingHolder(8, 0);
		moving.addBox(-2.0f, -3.5f, -2.0f, 4, 7, 4, 0.0f);
		final ModelRenderer top = new ModelRenderer(this, 0, 12);
		this.fixSize(top);
		moving.addChild(top);
		top.addBox(-6.0f, -1.5f, -2.0f, 12, 3, 4, 0.0f);
		top.setRotationPoint(0.0f, -5.0f, 0.0f);
	}

	static {
		ModelSolarPanelBase.texture = ResourceHelper.getResource("/models/panelModelBase.png");
	}
}
