package ar.mc.reloadsoundsystembtn;

import net.minecraft.client.gui.GuiScreenOptionsSounds;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ReloadSoundSystemBtn.MODID,
        name = ReloadSoundSystemBtn.NAME,
        version = ReloadSoundSystemBtn.VERSION,
        acceptedMinecraftVersions = "[1.12.2,1.13)",
        clientSideOnly = true)
@Mod.EventBusSubscriber
public class ReloadSoundSystemBtn {
    public static final String MODID = "reloadsoundsystembtn";
    public static final String NAME = "Reload Sound System Button";
    public static final String VERSION = "1";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @SubscribeEvent
    public static void onGuiOpen(GuiOpenEvent event) {
        if (event.getGui() instanceof GuiScreenOptionsSounds && !(event.getGui() instanceof Ui)) {
            GuiScreenOptionsSounds sounds = (GuiScreenOptionsSounds) event.getGui();
            event.setGui(new Ui(sounds.parent, sounds.game_settings_4));
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("A button called reload sound system appears in your menu.");
    }
}
