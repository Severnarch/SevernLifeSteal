![Server Environment](https://img.shields.io/badge/Environment-SERVER-ddd?labelColor=222) ![Forge, Fabric and Spigot Loaders](https://img.shields.io/badge/Loader-FORGE%2C%20FABRIC%20&%20SPIGOT-ddd?labelColor=222)

# SevernLifeSteal ![Mod/Plugin](https://img.shields.io/badge/[%20%20%20%20Mod%2fPlugin-]-22d?labelColor=22d)
SevernLifeSteal (*or SLS*) is a multi-platform life steal mod for Minecraft. This mod aims to support Forge, Fabric/Quilt and Spigot.

## Features
As this is a LifeSteal mod, there is a feature where killing someone makes the killer gain half a heart and the victim lose half a heart (unlike regular LifeSteal where its a full heart). However, there more features revolved around this singular feature which can be toggled[^1].
### Name Colouring
One of these additional features is the recolouring of names depending on how many maximum hearts you, as a player, have. You will be **![](https://placehold.it/16x16/00aa00/00aa00.png) dark green** when above two rows of hearts (40mhp)[^2][^3], **![](https://placehold.it/16x16/55ff55/55ff55.png) light green** when above one row of hearts (20mhp)[^2][^3], **![](https://placehold.it/16x16/ffff55/ffff55.png) yellow** when above half a row of hearts (10mhp)[^2][^3], **![](https://placehold.it/16x16/ffaa00/ffaa00.png) gold** when above one and a half hearts (3mhp)[^2][^3] and finally **![](https://placehold.it/16x16/ff5555/ff5555.png) red** when above no hearts (0mhp)[^4][^3]. Soft-spectators will have a **![](https://placehold.it/16x16/555555/555555.png) dark grey** name regardless of whether **Name Colouring** is enabled or not.
### Soft-Spectator
> **[!] WARNING**<br>
> Disabling this causes players to be banned on final death and disables **Player Reviving**.

Soft-spectator is a replacement for the common ban-on-loss technique, having the player be locked at 1mhp with a permanent invisibility effect and being unable to interact with blocks other than doors and trapdoors and unable to pick or drop items. Soft-Spectators will always have a **![](https://placehold.it/16x16/555555/555555.png) dark grey** name, similar to default spectator name formatting. This also allows for **Player Reviving** to be enabled.
### Player Reviving
> **[!] NOTICE**<br>
> This is automatically disabled when **Soft-Spectator** is disabled, as it is dependent on it. 

> **[!] WARNING**<br>
> Disabling this causes players who have died to only be revivable by using an admin command.<br>

When a player is killed on their last half-heart (1mhp) and enters **Soft-Spectator** mode, the player will drop their **Head** which can be placed anywhere. Reviving works by right-clicking a player's placed **Head** with a **Totem of Undying**, which will set the player back to normal, but with 5 hearts (10mhp) instead of 10 hearts (20mhp), and teleport them to the **Head** location. The player's **Head** will despawn once the revival completes, and this process also works with the player offline.

## Commands
These are special commands for the SevernLifeSteal mod, all under `/severnlifesteal` (*or `/sls`*). A list of commands can be seen below:
  - `/sls revive <player>` - Revive a player in soft-spectator mode [Permission level 3 or `severnlifesteal.revive`]
  - `/sls mhp <add|remove|set> <player> <amount>` - Edit a player's MHP value [Permission level 3 or `severnlifesteal.mhp.<add|remove|set|*>`]
  - `/sls give <player> <amount>` - Give another player `<amount>` MHP [Permission level 0 or `severnlifesteal.give`]
  - `/sls config ...` - Configure the SLS mod [Permission level 4 or `severnlifesteal.config.<toggle|edit|*>`] 
    - `/sls config <enable|disable> <feature>` - Enable or disable a feature for the mod [Permission level 4 or `severnlifesteal.config.toggle`]
    - `/sls config edit <feature> <configArg> <value>` - Edit a feature's `<configArg>` [Permission level 4 or `severnlifesteal.config.edit.<[feature]|*>`]

## Definitions
This is a list of definitions for non-standard words or abbreviations used within this document.
  - MHP: Maximum Health Points

[^1]: All features are ON/TRUE by default, meaning to disable them you either edit the properties file or use an admin command.
[^2]: This can be customised, the value shown here is the default amount.
[^3]: The value for hearts is an integer similar to how Vanilla Minecraft has heart values, with 2 as a full heart and 1 being a half heart.
[^4]: This value can not be customised.