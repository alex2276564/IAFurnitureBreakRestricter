# ItemsAdder Furniture Protection 🛡️🪑

[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.16.5+-brightgreen)](https://papermc.io/software/paper)
[![Java Version](https://img.shields.io/badge/java-17+-orange)](https://adoptium.net/installation/linux/)
[![GitHub Release](https://img.shields.io/github/v/release/alex2276564/IAFurnitureBreakRestricter?color=blue)](https://github.com/alex2276564/IAFurnitureBreakRestricter/releases/latest)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
[![SLSA 3](https://slsa.dev/images/gh-badge-level3.svg)](https://slsa.dev)

**ItemsAdder Furniture Protection** is a lightweight addon for the ItemsAdder Minecraft plugin that restricts breaking of custom furniture items. It's specifically designed for **minigame servers** (especially BedWars, SkyWars, and similar games) where traditional protection plugins like WorldGuard cannot be effectively used without causing gameplay issues.

## 🎯 When Do You Need This Plugin?

### ✅ **You NEED this plugin if:**

- 🎮 You run **minigame servers** (BedWars, SkyWars, BuildBattle, etc.)
- 🪑 You have **ItemsAdder furniture** in game lobbies or arenas
- 🚫 You **cannot use WorldGuard** in game zones (it breaks minigame mechanics)
- 🛡️ You need furniture protection **without region-based plugins**

### ❌ **You DON'T need this plugin if:**

- 🌍 You run a **Survival/SMP server** where WorldGuard can protect spawn and player regions
- 🏠 You can use **vanilla spawn protection** or **WorldGuard regions** effectively
- 🚪 Your furniture is already protected by existing region plugins

### 💡 **Why not just use WorldGuard?**

WorldGuard works great for Survival servers, but on **minigame servers**:

- ❌ Creating regions in every BedWars/SkyWars arena is impractical and causes bugs
- ❌ Players need to break/place blocks in arenas, but furniture must remain protected
- ❌ Dynamic game zones make region-based protection unreliable

**This plugin solves that** by using permissions instead of regions - furniture is protected everywhere unless the player has `ia.furniture.break` or `ia.*` permission.

## ✨ Features

- ✅ **Furniture Protection:** Prevents unauthorized players from breaking ItemsAdder furniture.
- ✅ **Flexible Permission System:** Grants permission to break furniture with either the specific `ia.furniture.break` permission or the broader `ia.*` permission.
- ✅ **Minigame Friendly:** Ideal for games like BedWars where WorldGuard can't be used.
- ✅ **Lightweight & Optimized:**
  - Minimal performance impact (~0.001ms per permission check)
  - Leverages LuckPerms in-memory cache for instant permission lookups
  - Zero database queries - all checks happen in RAM
  - Perfect for high-player-count servers
- 🔄 **Auto-Update Check:** On server start, the plugin checks for updates. If a new version is available, a notification is displayed in the console.

## 📥 Installation

1. **Ensure you have ItemsAdder installed on your server.**

2. **Download the latest version of the plugin from the [Releases](https://github.com/alex2276564/IAFurnitureBreakRestricter/releases) section.**

3. **Place the `.jar` file into your Minecraft server's `plugins` folder.**

4. **Restart the server** to load the plugin.

5. **(Optional)** Grant `ia.furniture.break` permission to staff members who need to manage furniture.

## 🛠️ Compatibility

- **Minecraft Versions:** 1.16.5 to the latest release
- **Server Software:**
  - ✅ [Paper](https://papermc.io/) (1.16.5 and newer) - **Fully Supported**
  - ❌ Folia - ItemsAdder does not support Folia at this time
  - ❌ Spigot - Not supported
- **Required Plugins:** [ItemsAdder](https://www.spigotmc.org/resources/itemsadder.73355/)
- ✅ **Works with all ItemsAdder furniture**
- ✅ **Full ItemsAdder Compatibility:** Compatible with all versions of ItemsAdder.

### 🎮 Minigame Plugin Compatibility

This plugin works seamlessly with popular minigame plugins:

- ✅ **BedWars Plugins:**
  - [BedWars1058](https://www.spigotmc.org/resources/bedwars1058.50942/)
  - [Screaming BedWars](https://www.spigotmc.org/resources/screaming-bedwars-1-8-8-1-20-4.63714/)
  - [MBedwars](https://mbedwars.com/)
  - Other BedWars forks and custom implementations
- ✅ **SkyWars Plugins:** Most SkyWars implementations
- ✅ **BuildBattle, Murder Mystery, and other minigames**

### ✅ Full Compatibility

- ✅ **Works with all ItemsAdder furniture**
- ✅ **Full ItemsAdder Compatibility:** Compatible with all versions of ItemsAdder.
- ✅ **No conflicts with minigame plugins** - uses permission-based protection instead of regions

## ℹ️ How it works

The plugin listens for ItemsAdder furniture break interactions and cancels them unless the player has the proper permission. It does not replace WorldGuard — it’s a niche tool for arenas where regions are undesirable.

## 📦 Other Plugins

> 🔍 **You can find more of my Minecraft plugins here:**  
> [https://github.com/alex2276564?tab=repositories](https://github.com/alex2276564?tab=repositories)

## 🆘 Support

If you encounter any issues or have suggestions for improving the plugin, please create an [issue](https://github.com/alex2276564/IAFurnitureBreakRestricter/issues) in this repository.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

[Alex] - [https://github.com/alex2276564]

We appreciate your contribution to the project! If you like this plugin, please give it a star on GitHub.

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/alex2276564/IAFurnitureBreakRestricter/issues).

### How to Contribute

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a Pull Request.

---

Thank you for using **ItemsAdder Furniture Protection**! We hope it enhances your server's gameplay and makes managing custom furniture easier on minigame servers. 🎮🪑
