package net.pistonmaster.chatuwuify;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatUwuify extends JavaPlugin implements Listener {
    private final UwUSource uwuSource = new UwUSource(
            getConfig().getInt("stutterChance"),
            getConfig().getInt("emojiChance")
    );

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setMessage(uwuSource.uwuify(event.getMessage()));
    }
}
