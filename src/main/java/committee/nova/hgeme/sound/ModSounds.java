package committee.nova.hgeme.sound;

import committee.nova.hgeme.HGeMe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HGeMe.MOD_ID);

    public static final RegistryObject<SoundEvent> HAQI1 =
            registerSoundEvents("haqi1");
    public static final RegistryObject<SoundEvent> HAQI2 =
            registerSoundEvents("haqi2");
    public static final RegistryObject<SoundEvent> HAQI3 =
            registerSoundEvents("haqi3");






    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(HGeMe.MOD_ID, name)));
    }


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }


}
