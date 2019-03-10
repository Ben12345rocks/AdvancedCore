package com.Ben12345rocks.AdvancedCore.Util.Skull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.Ben12345rocks.AdvancedCore.AdvancedCoreHook;
import com.Ben12345rocks.AdvancedCore.NMSManager.NMSManager;
import com.Ben12345rocks.AdvancedCore.NMSManager.ReflectionUtils;
import com.Ben12345rocks.AdvancedCore.Thread.Thread;
import com.Ben12345rocks.AdvancedCore.UserManager.User;
import com.Ben12345rocks.AdvancedCore.UserManager.UserStartup;
import com.Ben12345rocks.AdvancedCore.Util.Item.ItemBuilder;

public class SkullHandler {

	private static SkullHandler instance = new SkullHandler();

	@SuppressWarnings("rawtypes")
	private Class craftItemStack;
	@SuppressWarnings("rawtypes")
	private Class itemStack;
	private Method asNMSCopy;
	private Method asBukkitCopy;

	public static SkullHandler getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public void load() {
		craftItemStack = ReflectionUtils.getClassForName("org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack");
		itemStack = NMSManager.getInstance().getNMSClass("ItemStack");
		try {
			asNMSCopy = craftItemStack.getDeclaredMethod("asNMSCopy", ItemStack.class);
			asNMSCopy.setAccessible(true);
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			asBukkitCopy = craftItemStack.getDeclaredMethod("asBukkitCopy", itemStack);
			asBukkitCopy.setAccessible(true);
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		if (AdvancedCoreHook.getInstance().getOptions().isPreloadSkulls()) {
			AdvancedCoreHook.getInstance().addUserStartup(new UserStartup() {

				@Override
				public void onStartUp(User user) {
					loadSkull(user.getPlayerName());
				}

				@Override
				public void onStart() {

				}

				@Override
				public void onFinish() {

				}
			});
		}
	}

	private ConcurrentHashMap<String, Object> skulls = new ConcurrentHashMap<String, Object>();

	public void loadSkull(Player player) {
		loadSkull(player.getName());
	}

	@SuppressWarnings("deprecation")
	public void loadSkull(final String playerName) {
		if (playerName == null || playerName.isEmpty()) {
			// AdvancedCoreHook.getInstance().debug("Invalid skull name");
			return;
		}
		if (hasSkull(playerName)) {
			return;
		}
		Bukkit.getScheduler().runTaskAsynchronously(AdvancedCoreHook.getInstance().getPlugin(), new Runnable() {

			@Override
			public void run() {
				Thread.getInstance().run(new Runnable() {

					@Override
					public void run() {
						ItemStack s = new ItemStack(Material.PLAYER_HEAD, 1);
						SkullMeta meta = (SkullMeta) s.getItemMeta();
						meta.setOwner(playerName);
						s.setItemMeta(meta);

						try {
							skulls.put(playerName, asNMSCopy.invoke(null, s));
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
						AdvancedCoreHook.getInstance().extraDebug("Loading skull: " + playerName);

					}
				});
			}
		});

	}

	@SuppressWarnings("deprecation")
	public org.bukkit.inventory.ItemStack getItemStack(String playerName) {
		if (hasSkull(playerName)) {
			try {
				return (ItemStack) asBukkitCopy.invoke(null, skulls.get(playerName));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}

		} else {
			loadSkull(playerName);
		}
		return new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(playerName).toItemStack();
	}

	public boolean hasSkull(String playerName) {
		if (skulls.containsKey(playerName)) {
			if (skulls.get(playerName) != null) {
				return true;
			}
		}
		return false;
	}

}
