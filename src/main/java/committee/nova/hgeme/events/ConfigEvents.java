package committee.nova.hgeme.events;

import committee.nova.hgeme.HGeMe;
import committee.nova.hgeme.KeyBindings;
import committee.nova.hgeme.ModConfig;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = HGeMe.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigEvents {

    @SubscribeEvent
    public static void onConfigLoaded(ModConfigEvent.Loading event) {
        updateKeyFromConfig();
    }

    @SubscribeEvent
    public static void onConfigReloaded(ModConfigEvent.Reloading event) {
        updateKeyFromConfig();
    }

    private static void updateKeyFromConfig() {
        if (KeyBindings.CUSTOM_SOUND_KEY != null) {
            int keyCode = ModConfig.CUSTOM_KEY.get();
            if (keyCode < 32 || keyCode > 348) {
                keyCode = GLFW.GLFW_KEY_H;
            }
            KeyBindings.CUSTOM_SOUND_KEY.setKey(InputConstants.Type.KEYSYM.getOrCreate(keyCode));
        }
    }
}
