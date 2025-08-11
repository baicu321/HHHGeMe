package committee.nova.hgeme;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
    public static ForgeConfigSpec.IntValue CUSTOM_KEY;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("Key Bindings");

        CUSTOM_KEY = builder
                .comment("Key code for sound trigger (GLFW key codes, e.g. 72 = H key)")
                .defineInRange("customKey", 72, 32, 348);

        builder.pop();
    }
}
