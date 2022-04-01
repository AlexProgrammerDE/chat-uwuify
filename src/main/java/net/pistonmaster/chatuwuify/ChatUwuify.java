package net.pistonmaster.chatuwuify;

import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class ChatUwuify extends JavaPlugin implements Listener {
    private final UwUSource uwuSource = new UwUSource(
            getConfig().getInt("stutterChance"),
            getConfig().getInt("emojiChance")
    );

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);

        if (getServer().getPluginManager().getPlugin("PistonChat") != null) {
            getLogger().info("PistonChat detected, enabling support.");
            getServer().getPluginManager().registerEvents(new PistonChatExtension(this), this);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setMessage(uwuSource.uwuify(event.getMessage()));
    }
}
