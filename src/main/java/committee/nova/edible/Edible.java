package committee.nova.edible;

import committee.nova.edible.config.CommonConfig;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Edible.MODID, useMetadata = true)
public class Edible {
    public static final String MODID = "edible";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CommonConfig.init(event);
    }
}
