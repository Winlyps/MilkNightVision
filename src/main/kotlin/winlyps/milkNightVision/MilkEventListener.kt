package winlyps.milkNightVision

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class MilkEventListener(private val plugin: MilkNightVision) : Listener {

    @EventHandler
    fun onPlayerDrinkMilk(event: PlayerItemConsumeEvent) {
        if (event.item.type == org.bukkit.Material.MILK_BUCKET) {
            // Prevent the player from losing night vision effect
            val player = event.player
            val nightVisionEffect = player.getPotionEffect(PotionEffectType.NIGHT_VISION)
            if (nightVisionEffect != null) {
                event.isCancelled = true
                player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, nightVisionEffect.duration, nightVisionEffect.amplifier, nightVisionEffect.isAmbient, nightVisionEffect.hasParticles(), nightVisionEffect.hasIcon()))
            }
        }
    }
}