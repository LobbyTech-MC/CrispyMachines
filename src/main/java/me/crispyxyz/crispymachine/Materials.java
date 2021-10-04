package me.crispyxyz.crispymachine;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public final class Materials {
    public static final SlimefunItemStack DIESEL_OIL = new SlimefunItemStack("DIESEL_OIL", Material.LAVA_BUCKET, "&b柴油桶", "&3一种燃料");
    public static final SlimefunItemStack GASOLINE = new SlimefunItemStack("GASOLINE", Material.LAVA_BUCKET, "&b汽油桶", "&3一种燃料");
    public static final SlimefunItemStack CRISPY_MACHINE_CORE = new SlimefunItemStack("CRISPY_MACHINE_CORE", Material.FURNACE, "&d酥脆机器核心", "&3用于合成机器");
    public static final SlimefunItemStack DIESEL_GENERATOR = new SlimefunItemStack("DIESEL_GENERATOR", Material.BLAST_FURNACE, "&e柴油发电机", "&7 400 J 缓存", "&7 100 J/s");
    public static final SlimefunItemStack GASOLINE_GENERATOR = new SlimefunItemStack("GASOLINE_GENERATOR", Material.BLAST_FURNACE, "&e汽油发电机", "&7 200 J 缓存", "&7 50 J/s");
    public static final SlimefunItemStack CRISPY_MACHINE_SHELL = new SlimefunItemStack("CRISPY_MACHINE_SHELL", Material.PAPER, "&d酥脆机器外壳", "&3用于合成机器");
    public static final SlimefunItemStack PRINTER = new SlimefunItemStack("PRINTER", Material.PISTON, "&e打印机", "&3用于打印通用模板", "&7 20,000 J 缓存", "&7 500 J/s");
    public static final SlimefunItemStack GENERAL_TEMPLATE = new SlimefunItemStack("GENERAL_TEMPLATE", Material.PAPER, "&b通用模板", "&3用于复制物品");
    public static final SlimefunItemStack COPIER = new SlimefunItemStack("COPIER", Material.IRON_BLOCK, "&e复制机", "&3用于复制物品", "&7 200,000 J 缓存", "&7 200,000 J 每次使用");
}
