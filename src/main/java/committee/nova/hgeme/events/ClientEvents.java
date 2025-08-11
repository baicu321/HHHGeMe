package committee.nova.hgeme.events;

import committee.nova.hgeme.HGeMe;
import committee.nova.hgeme.KeyBindings;
import committee.nova.hgeme.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = HGeMe.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    private static final Minecraft MC = Minecraft.getInstance();
    private static int soundDelay = 0;
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.ClientTickEvent.Phase.END) return;

        if (KeyBindings.CUSTOM_SOUND_KEY != null && KeyBindings.CUSTOM_SOUND_KEY.isDown()) {
            if (soundDelay <= 0) {
                if (MC.player != null) {
                    int randomIndex = RANDOM.nextInt(3);
                    switch (randomIndex) {
                        case 0 -> MC.level.playSound(MC.player, MC.player.blockPosition(),
                                ModSounds.HAQI1.get(), SoundSource.PLAYERS, 4.0F, 1.0F);
                        case 1 -> MC.level.playSound(MC.player, MC.player.blockPosition(),
                                ModSounds.HAQI2.get(), SoundSource.PLAYERS, 4.0F, 1.0F);
                        case 2 -> MC.level.playSound(MC.player, MC.player.blockPosition(),
                                ModSounds.HAQI3.get(), SoundSource.PLAYERS, 4.0F, 1.0F);
                    }
                }
                soundDelay = 20;
            }
        }

        if (soundDelay > 0) soundDelay--;
    }
}