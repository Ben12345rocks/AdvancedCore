package com.bencodez.advancedcore.api.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.bencodez.advancedcore.AdvancedCorePlugin;
import com.bencodez.advancedcore.api.messages.StringParser;

import lombok.Getter;

public class FullInventoryHandler {
	@Getter
	private ConcurrentHashMap<UUID, ArrayList<ItemStack>> items;

	private AdvancedCorePlugin plugin;

	private Timer timer;

	public FullInventoryHandler(AdvancedCorePlugin plugin) {
		items = new ConcurrentHashMap<UUID, ArrayList<ItemStack>>();
		this.plugin = plugin;
		loadTimer();
	}

	public void loadTimer() {
		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				check();
			}
		}, 10 * 1000, 30 * 1000);
	}

	public void check(Player p) {
		if (p != null && items.containsKey(p.getUniqueId())) {
			ArrayList<ItemStack> extra = new ArrayList<ItemStack>();
			for (ItemStack item : items.get(p.getUniqueId())) {
				HashMap<Integer, ItemStack> excess = p.getInventory().addItem(item);
				for (Map.Entry<Integer, ItemStack> me : excess.entrySet()) {
					extra.add(me.getValue());
				}
			}
			if (extra.size() == 0) {
				items.remove(p.getUniqueId());
			} else {
				items.put(p.getUniqueId(), extra);
			}
		}
	}

	public void giveItem(Player p, ItemStack item) {
		HashMap<Integer, ItemStack> excess = p.getInventory().addItem(item);
		boolean full = false;
		boolean dropItems = plugin.getOptions().isDropOnFullInv();
		for (Map.Entry<Integer, ItemStack> me : excess.entrySet()) {
			full = true;
			if (dropItems) {
				p.getWorld().dropItem(p.getLocation(), me.getValue());
			} else {
				add(p.getUniqueId(), me.getValue());
			}
		}
		if (full) {
			String msg = StringParser.getInstance()
					.colorize(AdvancedCorePlugin.getInstance().getOptions().getFormatInvFull());
			if (!msg.isEmpty()) {
				p.sendMessage(msg);
			}
		}

		p.updateInventory();
	}

	public void add(UUID uuid, ArrayList<ItemStack> item) {
		if (items.containsKey(uuid)) {
			ArrayList<ItemStack> current = items.get(uuid);
			current.addAll(item);
			items.put(null, current);
		} else {
			items.put(uuid, item);
		}
	}

	public void add(UUID uuid, ItemStack item) {
		if (items.containsKey(uuid)) {
			ArrayList<ItemStack> current = items.get(uuid);
			current.add(item);
			items.put(uuid, current);
		} else {
			ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
			itemList.add(item);
			items.put(uuid, itemList);
		}
	}

	public void check() {
		for (UUID entry : items.keySet()) {
			Player p = Bukkit.getPlayer(entry);
			check(p);
		}
	}

}