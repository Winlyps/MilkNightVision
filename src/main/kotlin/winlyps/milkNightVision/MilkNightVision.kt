//1.File: MilkNightVision.kt
package winlyps.milkNightVision

import org.bukkit.plugin.java.JavaPlugin

class MilkNightVision : JavaPlugin() {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(MilkListener(this), this)
        logger.info("MilkNightVision plugin enabled.")
    }

    override fun onDisable() {
        logger.info("MilkNightVision plugin disabled.")
    }
}