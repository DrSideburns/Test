package Dr_Sideburns.CraftableChainMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CCItem extends Item {

	public CCItem(int id, int maxStackSize, CreativeTabs tab, int texture, String name, String Texture) {
		super(id);
		setMaxStackSize(maxStackSize);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setTextureName(Texture);
	}

}
