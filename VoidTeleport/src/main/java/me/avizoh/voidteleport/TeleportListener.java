package me.avizoh.voidteleport;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class TeleportListener implements Listener {

    @EventHandler
    public void onVoidDamage(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
            if (event.getEntity() instanceof Player) {
                event.setCancelled(true);
                Player player = (Player) event.getEntity();

                World world = VoidTeleport.getInstance().getServer().getWorld(VoidTeleport.getInstance().getConfig().getString("world"));
                Double x = VoidTeleport.getInstance().getConfig().getDouble("X");
                Double y = VoidTeleport.getInstance().getConfig().getDouble("Y");
                Double z = VoidTeleport.getInstance().getConfig().getDouble("Z");

                player.teleport(new Location(world, x, y, z));
            }
        }
    }
}
