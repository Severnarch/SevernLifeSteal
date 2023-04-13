package io.github.severnarch.severnlifesteal.listeners;

import io.github.severnarch.severnlifesteal.SevernLifeSteal;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        SevernLifeSteal plugin = JavaPlugin.getPlugin(SevernLifeSteal.class);
        Player player = event.getEntity();
        if(player.getKiller() != null){
            if (player.getKiller().getAttribute(Attribute.GENERIC_MAX_HEALTH) != null && player.getAttribute(Attribute.GENERIC_MAX_HEALTH) != null) {
                player.getKiller().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(player.getKiller().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 1.0);
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 1.0);
                plugin.updatePlayerName(player);plugin.updatePlayerName(player.getKiller());
            }
        }
    }
}
