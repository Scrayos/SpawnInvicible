package net.scrayos.spawninvincible.listener;

import net.scrayos.spawninvincible.SpawnInvincible;
import net.scrayos.spawninvincible.event.PlayerOutOfWorldEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            //Core functionality
            e.setCancelled(true);

            //Special void-handling
            if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                PlayerOutOfWorldEvent event = new PlayerOutOfWorldEvent(player, player.getWorld().getSpawnLocation());
                SpawnInvincible.getInstance().getServer().getPluginManager().callEvent(event);
                e.getEntity().teleport(event.getDestination());
            }

            //Remove any fire
            e.getEntity().setFireTicks(0);
        }
    }
}
