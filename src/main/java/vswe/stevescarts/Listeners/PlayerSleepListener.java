package vswe.stevescarts.Listeners;
import java.util.EnumSet;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import vswe.stevescarts.Items.ModItems;
import vswe.stevescarts.StevesCarts;
import cpw.mods.fml.relauncher.Side;

public class PlayerSleepListener
{

    public PlayerSleepListener() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void tickEnd(TickEvent.PlayerTickEvent event) {
		if (event.side == Side.SERVER) {
			EntityPlayer player = event.player;
			
			if (StevesCarts.isChristmas && player.isPlayerFullyAsleep()) {
				for (int i = 0; i < player.inventory.getSizeInventory();i++) {
					ItemStack item = player.inventory.getStackInSlot(i);
					if (item != null && item.getItem() == ModItems.component && item.getItemDamage() == 56) {
						item.setItemDamage(item.getItemDamage() + 1);
					}
				}
				
				
			}
		}
	}

	
}