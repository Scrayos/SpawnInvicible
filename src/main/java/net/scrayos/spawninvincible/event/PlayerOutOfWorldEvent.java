package net.scrayos.spawninvincible.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerOutOfWorldEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    @Getter
    @Setter
    private Location destination;

    public PlayerOutOfWorldEvent(Player p, Location destination) {
        super(p);
        this.destination = destination;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

