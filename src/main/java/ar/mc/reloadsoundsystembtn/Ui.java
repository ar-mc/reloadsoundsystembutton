package ar.mc.reloadsoundsystembtn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenOptionsSounds;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;

import java.io.IOException;

public class Ui extends GuiScreenOptionsSounds {
    public Ui(GuiScreen parentIn, GameSettings settingsIn) {
        super(parentIn, settingsIn);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.remove(this.buttonList.size() - 1);
        this.buttonList.add(new GuiButton(300, this.width / 2 - 100, this.height / 6 + 156, mc.fontRenderer.trimStringToWidth("Reload Sound System", 200)));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 180, I18n.format("gui.done")));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 300) {
            Minecraft.getMinecraft().getSoundHandler().sndManager.reloadSoundSystem();
            mc.displayGuiScreen(new GuiErrorScreen(":)", "Sound manager reloaded"));
        } else {
            super.actionPerformed(button);
        }
    }
}
