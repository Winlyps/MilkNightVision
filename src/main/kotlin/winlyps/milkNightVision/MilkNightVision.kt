//1.File: MilkNightVision.kt
package winlyps.milkNightVision

import org.bukkit.plugin.java.JavaPlugin

class MilkNightVision : JavaPlugin() {

    override fun onEnable() {
        getServer().pluginManager.registerEvents(MilkEventListener(this), this)
    }

    override fun onDisable() {
    }
}