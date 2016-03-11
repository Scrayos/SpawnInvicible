package net.scrayos.spawninvincible;

import lombok.Getter;
import net.scrayos.spawninvincible.include.Metrics;
import net.scrayos.spawninvincible.listener.DamageListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;

public class SpawnInvincible extends JavaPlugin {

    @Getter
    private static SpawnInvincible instance = null;

    @Override
    public void onEnable() {
        instance = this;

        //Metrics initialization.
        try {
            new Metrics(this).start();
        } catch (IOException ex) {
            getLogger().log(Level.INFO, "Metrics couldn't be initialized. Connection couldn't be established!");
            getLogger().log(Level.FINE, "The error is as follows:", ex);
        }

        //Register events
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }

    @Override
    public void onDisable() {

        instance = null;
    }
}
