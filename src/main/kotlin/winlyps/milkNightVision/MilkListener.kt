package winlyps.milkNightVision

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffectType
import org.bukkit.plugin.Plugin

class MilkListener(private val plugin: Plugin) : Listener {

    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
        if (event.item.type == Material.MILK_BUCKET) {
            // Cancel the default milk bucket effect
            event.isCancelled = true

            // Remove the milk bucket from the player's inventory
            val player = event.player
            if (player.inventory.itemInMainHand.type == Material.MILK_BUCKET) {
                player.inventory.setItemInMainHand(ItemStack(Material.BUCKET))
            } else if (player.inventory.itemInOffHand.type == Material.MILK_BUCKET) {
                player.inventory.setItemInOffHand(ItemStack(Material.BUCKET))
            }

            // Remove all potion effects except night vision
            val nightVisionEffect = player.activePotionEffects.find { it.type == PotionEffectType.NIGHT_VISION }
            player.activePotionEffects.forEach { effect ->
                if (effect.type != PotionEffectType.NIGHT_VISION) {
                    player.removePotionEffect(effect.type)
                }
            }

            // Reapply night vision if it was present
            nightVisionEffect?.let {
                player.addPotionEffect(it)
            }
        }
    }
}