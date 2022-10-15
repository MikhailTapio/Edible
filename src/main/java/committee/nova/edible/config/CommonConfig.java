package committee.nova.edible.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

public class CommonConfig {
    public static Configuration config = null;
    public static String[] notAlwaysEdible = null;

    public static void init(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        notAlwaysEdible = config.getStringList("notAlwaysEdible", Configuration.CATEGORY_GENERAL, new String[]{"exampleNotEdible1", "exampleNotEdible2"}, "List of foods not always edible");
        config.save();
    }

    public static boolean isNotAlwaysEdible(ItemStack stack) {
        for (final String food : notAlwaysEdible) {
            if (food.equals(stack.getItem().getUnlocalizedName().substring(5))) return true;
        }
        return false;
    }
}
