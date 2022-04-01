package net.pistonmaster.chatuwuify;

import lombok.RequiredArgsConstructor;
import net.pistonmaster.pistonchat.api.PistonWhisperEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@RequiredArgsConstructor
public class PistonChatExtension implements Listener {
    private final ChatUwuify plugin;

    @EventHandler
    public void onWhisper(PistonWhisperEvent event) {
        event.setMessage(plugin.getUwuSource().uwuify(event.getMessage()));
    }
}
