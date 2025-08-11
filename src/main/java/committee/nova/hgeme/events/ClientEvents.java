package committee.nova.hgeme.events;


import committee.nova.hgeme.HGeMe;
import committee.nova.hgeme.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HGeMe.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    private static final Minecraft MC = Minecraft.getInstance();
    private static int soundDelay = 0;



    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.ClientTickEvent.Phase.END) return;

        if (KeyBindings.CUSTOM_SOUND_KEY  != null && KeyBindings.CUSTOM_SOUND_KEY .isDown()) {
            if (soundDelay <= 0) {
                if (MC.player != null) {
                    MC.level.playSound(MC.player, MC.player.blockPosition(),
                            SoundEvents.NOTE_BLOCK_BELL.value(),
                            SoundSource.PLAYERS, 1.0F, 1.0F);
                }
                soundDelay = 20;
            }
        }

        if (soundDelay > 0) soundDelay--;
    }
}
