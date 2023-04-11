![Server Environment](https://img.shields.io/badge/Environment-SERVER-ddd?labelColor=222) ![Forge, Fabric and Spigot Loaders](https://img.shields.io/badge/Loader-FORGE%2C%20FABRIC%20&%20SPIGOT-ddd?labelColor=222)

# SevernLifeSteal ![Mod/Plugin](https://img.shields.io/badge/[%20%20%20Mod%2fPlugin-]-22d?labelColor=22d)
SevernLifeSteal (*or SLS*) is a multi-platform life steal mod for Minecraft. This mod aims to support Forge, Fabric/Quilt and Spigot.

## Features
As this is a LifeSteal mod, there is obviously a feature where killing someone makes you take one heart off of them. However, there more features revolved around this singular feature which can be toggled[^1]. Instead of banning players upon losing all of their hearts, they will instead be in a soft-spectator mode described somewhere below.
### Name Colouring
One of these additional features is the recolouring of names depending on how many maximum hearts you, as a player, have. You will be **![](https://placehold.it/16x16/55ff55/55ff55.png) light green** when above two rows of hearts (40mhp)[^2][^3], **![](https://placehold.it/16x16/00aa00/00aa00.png) dark green** when above one row of hearts (20mhp)[^2][^3], **![](https://placehold.it/16x16/ffff55/ffff55.png) yellow** when above half a row of hearts (10mhp)[^2][^3], **![](https://placehold.it/16x16/ffaa00/ffaa00.png) gold** when above one and a half hearts (3mhp)[^2][^3] and finally **![](https://placehold.it/16x16/ff5555/ff5555.png) red** when above no hearts (0mhp)[^4][^3]. Soft-spectators will have a **![](https://placehold.it/16x16/555555/555555.png) dark grey** *italicised* name.
### Soft-Spectator
Soft-spectator is a replacement for the common ban-on-loss technique, having the player be locked at 1mhp with a permanent invisibility effect and being unable to interact with blocks other than doors and trapdoors. When **Name Colouring** is enabled, they will have a **![](https://placehold.it/16x16/555555/555555.png) dark grey** *italicised* name similar to default spectator name formatting.

## Definitions
This is a list of definitions for non-standard words or abbreviations used within this document.
  - MHP: Maximum Health Points

[^1]: All features are ON/TRUE by default, meaning you'd have to access the configuration manually to turn features off when wanted.
[^2]: This can be customised, the value shown here is the default amount.
[^3]: The value for hearts is an integer similar to how Vanilla Minecraft has heart values, with 2 being a full heart and 1 being half a heart.
[^4]: This value can not be customised, most likely as it is the lowest value possible.