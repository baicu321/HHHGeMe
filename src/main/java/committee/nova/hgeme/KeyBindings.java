package committee.nova.hgeme;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = HGeMe.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeyBindings {
    public static KeyMapping CUSTOM_SOUND_KEY;

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        CUSTOM_SOUND_KEY = new KeyMapping(
                "key.hgeme.hold_h",
                GLFW.GLFW_KEY_H,
                "key.categories.hgeme"
        );
        event.register(CUSTOM_SOUND_KEY);
    }
}
