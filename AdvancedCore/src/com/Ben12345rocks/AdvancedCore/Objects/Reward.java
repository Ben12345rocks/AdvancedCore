package com.Ben12345rocks.AdvancedCore.Objects;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Ben12345rocks.AdvancedCore.Main;
import com.Ben12345rocks.AdvancedCore.Utils;
import com.Ben12345rocks.AdvancedCore.Configs.ConfigRewards;
import com.Ben12345rocks.AdvancedCore.Listeners.PlayerRewardEvent;
import com.Ben12345rocks.AdvancedCore.Util.Javascript.JavascriptHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class Reward.
 */
public class Reward {

	/** The plugin. */
	static Main plugin = Main.plugin;

	/** The name. */
	public String name;

	/** The reward type. */
	private String rewardType;

	/** The delay enabled. */
	private boolean delayEnabled;

	/** The delay hours. */
	private int delayHours;

	/** The delay minutes. */
	private int delayMinutes;

	/** The timed enabled. */
	private boolean timedEnabled;

	/** The timed hour. */
	private int timedHour;

	/** The timed minute. */
	private int timedMinute;

	/** The chance. */
	private double chance;

	/** The random chance. */
	private double randomChance;

	/** The random rewards. */
	private ArrayList<String> randomRewards;

	/** The random fall back. */
	private ArrayList<String> randomFallBack;

	/** The require permission. */
	private boolean requirePermission;

	/** The worlds. */
	private ArrayList<String> worlds;

	/** The give in each world. */
	private boolean giveInEachWorld;

	/** The items. */
	private Set<String> items;

	/** The item material. */
	private HashMap<String, String> itemMaterial;

	/** The item skull. */
	private HashMap<String, String> itemSkull;

	/** The item data. */
	private HashMap<String, Integer> itemData;

	/** The item durabilty. */
	private HashMap<String, Integer> itemDurabilty;

	/** The item amount. */
	private HashMap<String, Integer> itemAmount;

	/** The item min amount. */
	private HashMap<String, Integer> itemMinAmount;

	/** The item max amount. */
	private HashMap<String, Integer> itemMaxAmount;

	/** The item name. */
	private HashMap<String, String> itemName;

	/** The item lore. */
	private HashMap<String, ArrayList<String>> itemLore;

	/** The item enchants. */
	private HashMap<String, HashMap<String, Integer>> itemEnchants;

	/** The money. */
	private int money;

	/** The Min money. */
	private int MinMoney;

	/** The Max money. */
	private int MaxMoney;

	/** The exp. */
	private int exp;

	/** The min exp. */
	private int minExp;

	/** The max exp. */
	private int maxExp;

	/** The console commands. */
	private ArrayList<String> consoleCommands;

	/** The player commands. */
	private ArrayList<String> playerCommands;

	/** The potions. */
	private Set<String> potions;

	/** The potions duration. */
	private HashMap<String, Integer> potionsDuration;

	/** The potions amplifier. */
	private HashMap<String, Integer> potionsAmplifier;

	/** The reward msg. */
	private String rewardMsg;

	/** The action bar msg. */
	private String actionBarMsg;

	/** The action bar delay. */
	private int actionBarDelay;

	/** The boss bar enabled. */
	private boolean bossBarEnabled;

	/** The boss bar message. */
	private String bossBarMessage;

	/** The boss bar color. */
	private String bossBarColor;

	/** The boss bar style. */
	private String bossBarStyle;

	/** The boss bar delay. */
	private int bossBarDelay;

	/** The boss bar progress. */
	private double bossBarProgress;

	/** The broadcast msg. */
	private String broadcastMsg;

	/** The permission. */
	private String permission;

	/** The javascript enabled. */
	private boolean javascriptEnabled;

	/** The javascript expression. */
	private String javascriptExpression;

	/** The javascript true rewards. */
	private ArrayList<String> javascriptTrueRewards;

	/** The javascript false rewards. */
	private ArrayList<String> javascriptFalseRewards;

	/** The choice rewards rewards. */
	private ArrayList<String> choiceRewardsRewards;

	private HashMap<String, Integer> itemsAndAmountsGiven;

	/** The choice rewards enabled. */
	private boolean choiceRewardsEnabled;

	/** The firework enabled. */
	private boolean fireworkEnabled;

	/** The firework flicker. */
	private boolean fireworkFlicker;

	/** The firework trail. */
	private boolean fireworkTrail;

	/** The firework power. */
	private int fireworkPower;

	/** The firework colors. */
	private ArrayList<String> fireworkColors;

	/** The firework fade out colors. */
	private ArrayList<String> fireworkFadeOutColors;

	/** The firework types. */
	private ArrayList<String> fireworkTypes;

	private boolean usesWorlds;

	private File file;

	public Reward(File file, String reward) {
		load(file, reward);
	}

	public void load(File file, String reward) {
		name = reward;
		this.file = file;
		setRewardType(ConfigRewards.getInstance().getRewardType(file, reward));

		setDelayEnabled(ConfigRewards.getInstance().getDelayedEnabled(file,
				reward));
		setDelayHours(ConfigRewards.getInstance().getDelayedHours(file, reward));
		setDelayMinutes(ConfigRewards.getInstance().getDelayedMinutes(file,
				reward));

		setTimedEnabled(ConfigRewards.getInstance().getTimedEnabled(file,
				reward));
		setTimedHour(ConfigRewards.getInstance().getTimedHour(file, reward));
		setTimedMinute(ConfigRewards.getInstance().getTimedMinute(file, reward));

		setChance(ConfigRewards.getInstance().getChance(file, reward));
		setRandomChance(ConfigRewards.getInstance().getRandomChance(file,
				reward));
		setRandomRewards(ConfigRewards.getInstance().getRandomRewards(file,
				reward));
		setRandomFallBack(ConfigRewards.getInstance().getRandomFallBack(file,
				reward));

		setRequirePermission(ConfigRewards.getInstance().getRequirePermission(
				file, reward));
		setWorlds(ConfigRewards.getInstance().getWorlds(file, reward));
		setGiveInEachWorld(ConfigRewards.getInstance().getGiveInEachWorld(file,
				reward));

		setItems(ConfigRewards.getInstance().getItems(file, reward));
		itemMaterial = new HashMap<String, String>();
		itemData = new HashMap<String, Integer>();
		itemSkull = new HashMap<String, String>();
		itemDurabilty = new HashMap<String, Integer>();
		itemAmount = new HashMap<String, Integer>();
		itemMinAmount = new HashMap<String, Integer>();
		itemMaxAmount = new HashMap<String, Integer>();
		itemName = new HashMap<String, String>();
		itemLore = new HashMap<String, ArrayList<String>>();
		itemName = new HashMap<String, String>();
		itemEnchants = new HashMap<String, HashMap<String, Integer>>();
		for (String item : ConfigRewards.getInstance().getItems(file, reward)) {
			itemMaterial.put(
					item,
					ConfigRewards.getInstance().getItemMaterial(file, reward,
							item));
			itemData.put(item,
					ConfigRewards.getInstance().getItemData(file, reward, item));
			itemAmount.put(
					item,
					ConfigRewards.getInstance().getItemAmount(file, reward,
							item));
			itemMinAmount.put(item, ConfigRewards.getInstance()
					.getItemMinAmount(file, reward, item));
			itemMaxAmount.put(item, ConfigRewards.getInstance()
					.getItemMaxAmount(file, reward, item));
			itemName.put(item,
					ConfigRewards.getInstance().getItemName(file, reward, item));
			itemLore.put(item,
					ConfigRewards.getInstance().getItemLore(file, reward, item));
			itemDurabilty.put(item, ConfigRewards.getInstance()
					.getItemDurability(file, reward, item));
			itemSkull.put(item,
					ConfigRewards.getInstance()
							.getItemSkull(file, reward, item));
			HashMap<String, Integer> enchants = new HashMap<String, Integer>();
			for (String enchant : ConfigRewards.getInstance().getItemEnchants(
					file, reward, item)) {
				enchants.put(enchant, ConfigRewards.getInstance()
						.getItemEnchantsLevel(file, reward, item, enchant));

			}
			itemEnchants.put(item, enchants);
		}

		setMoney(ConfigRewards.getInstance().getMoney(file, reward));
		setMinMoney(ConfigRewards.getInstance().getMinMoney(file, reward));
		setMaxMoney(ConfigRewards.getInstance().getMaxMoney(file, reward));

		setExp(ConfigRewards.getInstance().getEXP(file, reward));
		setMinExp(ConfigRewards.getInstance().getMinExp(file, reward));
		setMaxExp(ConfigRewards.getInstance().getMaxExp(file, reward));

		setConsoleCommands(ConfigRewards.getInstance().getCommandsConsole(file,
				reward));
		setPlayerCommands(ConfigRewards.getInstance().getCommandsPlayer(file,
				reward));

		potions = ConfigRewards.getInstance().getPotions(file, reward);
		potionsDuration = new HashMap<String, Integer>();
		potionsAmplifier = new HashMap<String, Integer>();
		for (String potion : potions) {
			potionsDuration.put(potion, ConfigRewards.getInstance()
					.getPotionsDuration(file, reward, potion));
			potionsAmplifier.put(potion, ConfigRewards.getInstance()
					.getPotionsAmplifier(file, reward, potion));
		}

		setRewardMsg(ConfigRewards.getInstance()
				.getMessagesReward(file, reward));
		setActionBarMsg(ConfigRewards.getInstance().getActionBarMessage(file,
				reward));
		setActionBarDelay(ConfigRewards.getInstance().getActionBarDelay(file,
				reward));

		setBossBarEnabled(ConfigRewards.getInstance().getBossBarEnabled(file,
				reward));
		setBossBarMessage(ConfigRewards.getInstance().getBossBarMessage(file,
				reward));
		setBossBarColor(ConfigRewards.getInstance().getBossBarColor(file,
				reward));
		setBossBarStyle(ConfigRewards.getInstance().getBossBarStyle(file,
				reward));
		setBossBarProgress(ConfigRewards.getInstance().getBossBarProgress(file,
				reward));
		setBossBarDelay(ConfigRewards.getInstance().getBossBarDelay(file,
				reward));

		broadcastMsg = ConfigRewards.getInstance().getMessagesBroadcast(file,
				reward);

		permission = ConfigRewards.getInstance().getPermission(file, reward);

		setJavascriptEnabled(ConfigRewards.getInstance().getJavascriptEnabled(
				file, reward));
		setJavascriptExpression(ConfigRewards.getInstance()
				.getJavascriptExpression(file, reward));
		setJavascriptTrueRewards(ConfigRewards.getInstance()
				.getJavascriptTrueRewards(file, reward));
		setJavascriptFalseRewards(ConfigRewards.getInstance()
				.getJavascriptFalseRewards(file, reward));
		setChoiceRewardsEnabled(ConfigRewards.getInstance()
				.getChoiceRewardsEnabled(file, reward));
		setChoiceRewardsRewards(ConfigRewards.getInstance()
				.getChoiceRewardsRewards(file, reward));

		fireworkEnabled = ConfigRewards.getInstance().getFireworkEnabled(file,
				reward);
		fireworkColors = ConfigRewards.getInstance().getFireworkColors(file,
				reward);
		fireworkFadeOutColors = ConfigRewards.getInstance()
				.getFireworkColorsFadeOut(file, reward);
		fireworkPower = ConfigRewards.getInstance().getFireworkPower(file,
				reward);
		fireworkTypes = ConfigRewards.getInstance().getFireworkTypes(file,
				reward);
		fireworkTrail = ConfigRewards.getInstance().getFireworkTrail(file,
				reward);
		fireworkFlicker = ConfigRewards.getInstance().getFireworkFlicker(file,
				reward);

		if (getWorlds().size() == 0) {
			usesWorlds = false;
		} else {
			usesWorlds = true;
		}
	}

	/**
	 * Instantiates a new reward.
	 *
	 * @param reward
	 *            the reward
	 */
	public Reward(String reward) {
		load(new File(plugin.getDataFolder(), "Rewards"), reward);
	}

	/**
	 * Check chance.
	 *
	 * @return true, if successful
	 */
	public boolean checkChance() {
		double chance = getChance();

		if ((chance == 0) || (chance == 100)) {
			return true;
		}

		double randomNum = (Math.random() * 100) + 1;

		plugin.debug("Random: " + randomNum + ", Chance: " + chance);

		if (randomNum <= chance) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check choice rewards.
	 *
	 * @param user
	 *            the user
	 */
	public void checkChoiceRewards(User user) {
		if (isChoiceRewardsEnabled()) {
			Player player = user.getPlayer();
			if (player != null) {
				user.addChoiceReward(this);
			}
		}
	}

	/**
	 * Check delayed.
	 *
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public boolean checkDelayed(User user) {
		if (!isDelayEnabled()) {
			return false;
		}

		Date time = new Date();
		time = DateUtils.addHours(time, getDelayHours());
		time = DateUtils.addMinutes(time, getDelayMinutes());
		user.addTimedReward(this, time.getTime());

		plugin.debug("Giving reward " + name + " in " + getDelayHours()
				+ " hours " + getDelayMinutes() + " minutes ("
				+ time.toString() + ")");
		return true;

	}

	/**
	 * Check random chance.
	 *
	 * @return true, if successful
	 */
	public boolean checkRandomChance() {
		double chance = getRandomChance();

		if ((chance == 0) || (chance == 100)) {
			return true;
		}

		double randomNum = (Math.random() * 100) + 1;

		plugin.debug("Random: Random: " + randomNum + ", Chance: " + chance);

		if (randomNum <= chance) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check timed.
	 *
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	@SuppressWarnings("deprecation")
	public boolean checkTimed(User user) {
		if (!isTimedEnabled()) {
			return false;
		}

		Date time = new Date();
		time.setHours(getTimedHour());
		time.setMinutes(getTimedMinute());
		if (new Date().after(time)) {
			time = DateUtils.addDays(time, 1);
		}
		user.addTimedReward(this, time.getTime());

		plugin.debug("Giving reward " + name + " at " + time.toString());
		return true;
	}

	/**
	 * Gets the action bar delay.
	 *
	 * @return the action bar delay
	 */
	public int getActionBarDelay() {
		return actionBarDelay;
	}

	/**
	 * Gets the action bar msg.
	 *
	 * @return the action bar msg
	 */
	public String getActionBarMsg() {
		return actionBarMsg;
	}

	/**
	 * Gets the boss bar color.
	 *
	 * @return the boss bar color
	 */
	public String getBossBarColor() {
		return bossBarColor;
	}

	/**
	 * Gets the boss bar delay.
	 *
	 * @return the boss bar delay
	 */
	public int getBossBarDelay() {
		return bossBarDelay;
	}

	/**
	 * Gets the boss bar message.
	 *
	 * @return the boss bar message
	 */
	public String getBossBarMessage() {
		return bossBarMessage;
	}

	/**
	 * Gets the boss bar progress.
	 *
	 * @return the boss bar progress
	 */
	public double getBossBarProgress() {
		return bossBarProgress;
	}

	/**
	 * Gets the boss bar style.
	 *
	 * @return the boss bar style
	 */
	public String getBossBarStyle() {
		return bossBarStyle;
	}

	/**
	 * Gets the broadcast msg.
	 *
	 * @return the broadcast msg
	 */
	public String getBroadcastMsg() {
		return broadcastMsg;
	}

	/**
	 * Gets the chance.
	 *
	 * @return the chance
	 */
	public double getChance() {
		return chance;
	}

	/**
	 * Gets the choice rewards rewards.
	 *
	 * @return the choice rewards rewards
	 */
	public ArrayList<String> getChoiceRewardsRewards() {
		return choiceRewardsRewards;
	}

	/**
	 * Gets the console commands.
	 *
	 * @return the console commands
	 */
	public ArrayList<String> getConsoleCommands() {
		return consoleCommands;
	}

	/**
	 * Gets the delay hours.
	 *
	 * @return the delay hours
	 */
	public int getDelayHours() {
		return delayHours;
	}

	/**
	 * Gets the delay minutes.
	 *
	 * @return the delay minutes
	 */
	public int getDelayMinutes() {
		return delayMinutes;
	}

	/**
	 * Gets the exp.
	 *
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * Gets the exp to give.
	 *
	 * @return the exp to give
	 */
	public int getExpToGive() {
		int amount = getExp();
		int maxAmount = getMaxExp();
		int minAmount = getMinExp();
		if ((maxAmount == 0) && (minAmount == 0)) {
			return amount;
		} else {
			int num = (int) (Math.random() * maxAmount);
			num++;
			if (num < minAmount) {
				num = minAmount;
			}
			return num;
		}
	}

	/**
	 * Gets the firework colors.
	 *
	 * @return the firework colors
	 */
	public ArrayList<String> getFireworkColors() {
		return fireworkColors;
	}

	/**
	 * Gets the firework fade out colors.
	 *
	 * @return the firework fade out colors
	 */
	public ArrayList<String> getFireworkFadeOutColors() {
		return fireworkFadeOutColors;
	}

	/**
	 * Gets the firework power.
	 *
	 * @return the firework power
	 */
	public int getFireworkPower() {
		return fireworkPower;
	}

	/**
	 * Gets the firework types.
	 *
	 * @return the firework types
	 */
	public ArrayList<String> getFireworkTypes() {
		return fireworkTypes;
	}

	/**
	 * Gets the item amount.
	 *
	 * @return the item amount
	 */
	public HashMap<String, Integer> getItemAmount() {
		return itemAmount;
	}

	/**
	 * Gets the item amount.
	 *
	 * @param item
	 *            the item
	 * @return the item amount
	 */
	public int getItemAmount(String item) {
		int amount = getItemAmount().get(item);
		int maxAmount = getItemMaxAmount().get(item);
		int minAmount = getItemMinAmount().get(item);
		if ((maxAmount == 0) && (minAmount == 0)) {
			return amount;
		} else {
			int num = (int) (Math.random() * maxAmount);
			num++;
			if (num < minAmount) {
				num = minAmount;
			}
			return num;
		}
	}

	/**
	 * Gets the item data.
	 *
	 * @return the item data
	 */
	public HashMap<String, Integer> getItemData() {
		return itemData;
	}

	/**
	 * Gets the item durabilty.
	 *
	 * @return the item durabilty
	 */
	public HashMap<String, Integer> getItemDurabilty() {
		return itemDurabilty;
	}

	/**
	 * Gets the item enchants.
	 *
	 * @return the item enchants
	 */
	public HashMap<String, HashMap<String, Integer>> getItemEnchants() {
		return itemEnchants;
	}

	/**
	 * Gets the item lore.
	 *
	 * @return the item lore
	 */
	public HashMap<String, ArrayList<String>> getItemLore() {
		return itemLore;
	}

	/**
	 * Gets the item material.
	 *
	 * @return the item material
	 */
	public HashMap<String, String> getItemMaterial() {
		return itemMaterial;
	}

	/**
	 * Gets the item max amount.
	 *
	 * @return the item max amount
	 */
	public HashMap<String, Integer> getItemMaxAmount() {
		return itemMaxAmount;
	}

	/**
	 * Gets the item min amount.
	 *
	 * @return the item min amount
	 */
	public HashMap<String, Integer> getItemMinAmount() {
		return itemMinAmount;
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public HashMap<String, String> getItemName() {
		return itemName;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public Set<String> getItems() {
		return items;
	}

	/**
	 * Gets the item skull.
	 *
	 * @return the item skull
	 */
	public HashMap<String, String> getItemSkull() {
		return itemSkull;
	}

	/**
	 * Gets the javascript expression.
	 *
	 * @return the javascript expression
	 */
	public String getJavascriptExpression() {
		return javascriptExpression;
	}

	/**
	 * Gets the javascript false rewards.
	 *
	 * @return the javascript false rewards
	 */
	public ArrayList<String> getJavascriptFalseRewards() {
		return javascriptFalseRewards;
	}

	/**
	 * Gets the javascript true rewards.
	 *
	 * @return the javascript true rewards
	 */
	public ArrayList<String> getJavascriptTrueRewards() {
		return javascriptTrueRewards;
	}

	/**
	 * Gets the max exp.
	 *
	 * @return the max exp
	 */
	public int getMaxExp() {
		return maxExp;
	}

	/**
	 * Gets the max money.
	 *
	 * @return the max money
	 */
	public int getMaxMoney() {
		return MaxMoney;
	}

	/**
	 * Gets the min exp.
	 *
	 * @return the min exp
	 */
	public int getMinExp() {
		return minExp;
	}

	/**
	 * Gets the min money.
	 *
	 * @return the min money
	 */
	public int getMinMoney() {
		return MinMoney;
	}

	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Gets the money to give.
	 *
	 * @return the money to give
	 */
	public int getMoneyToGive() {
		int amount = getMoney();
		int maxAmount = getMaxMoney();
		int minAmount = getMinMoney();
		if ((maxAmount == 0) && (minAmount == 0)) {
			return amount;
		} else {
			int num = (int) (Math.random() * maxAmount);
			num++;
			if (num < minAmount) {
				num = minAmount;
			}
			return num;
		}
	}

	/**
	 * Gets the permission.
	 *
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * Gets the player commands.
	 *
	 * @return the player commands
	 */
	public ArrayList<String> getPlayerCommands() {
		return playerCommands;
	}

	/**
	 * Gets the potions.
	 *
	 * @return the potions
	 */
	public Set<String> getPotions() {
		return potions;
	}

	/**
	 * Gets the potions amplifier.
	 *
	 * @return the potions amplifier
	 */
	public HashMap<String, Integer> getPotionsAmplifier() {
		return potionsAmplifier;
	}

	/**
	 * Gets the potions duration.
	 *
	 * @return the potions duration
	 */
	public HashMap<String, Integer> getPotionsDuration() {
		return potionsDuration;
	}

	/**
	 * Gets the random chance.
	 *
	 * @return the random chance
	 */
	public double getRandomChance() {
		return randomChance;
	}

	/**
	 * Gets the random fall back.
	 *
	 * @return the random fall back
	 */
	public ArrayList<String> getRandomFallBack() {
		return randomFallBack;
	}

	/**
	 * Gets the random rewards.
	 *
	 * @return the random rewards
	 */
	public ArrayList<String> getRandomRewards() {
		return randomRewards;
	}

	/**
	 * Gets the reward msg.
	 *
	 * @return the reward msg
	 */
	public String getRewardMsg() {
		return rewardMsg;
	}

	/**
	 * Gets the reward name.
	 *
	 * @return the reward name
	 */
	public String getRewardName() {
		return name;
	}

	/**
	 * Gets the reward type.
	 *
	 * @return the reward type
	 */
	public String getRewardType() {
		return rewardType;
	}

	/**
	 * Gets the timed hour.
	 *
	 * @return the timed hour
	 */
	public int getTimedHour() {
		return timedHour;
	}

	/**
	 * Gets the timed minute.
	 *
	 * @return the timed minute
	 */
	public int getTimedMinute() {
		return timedMinute;
	}

	/**
	 * Gets the worlds.
	 *
	 * @return the worlds
	 */
	public ArrayList<String> getWorlds() {
		return worlds;
	}

	public void giveExp(User user, int exp) {
		user.giveExp(exp);
	}

	/**
	 * Give items.
	 *
	 * @param user
	 *            the user
	 */
	public void giveItems(User user) {
		itemsAndAmountsGiven = new HashMap<String, Integer>();
		for (String item : getItems()) {
			ItemStack itemStack = new ItemStack(
					Material.valueOf(getItemMaterial().get(item)),
					getItemAmount(item), Short.valueOf(Integer
							.toString(getItemData().get(item))));
			itemsAndAmountsGiven.put(item, itemStack.getAmount());
			String name = getItemName().get(item);
			if (name != null) {
				itemStack = Utils.getInstance().nameItem(itemStack,
						name.replace("%Player%", user.getPlayerName()));
			}
			itemStack = Utils.getInstance().addLore(
					itemStack,
					Utils.getInstance().replace(getItemLore().get(item),
							"%Player%", user.getPlayerName()));
			itemStack = Utils.getInstance().addEnchants(itemStack,
					getItemEnchants().get(item));
			itemStack = Utils.getInstance().setDurabilty(itemStack,
					getItemDurabilty().get(item));
			String skull = getItemSkull().get(item);
			if (skull != null) {
				itemStack = Utils.getInstance().setSkullOwner(itemStack,
						skull.replace("%Player%", user.getPlayerName()));
			}
			user.giveItem(itemStack);
		}
	}

	public void giveMoney(User user, int money) {
		user.giveMoney(money);
	}

	/**
	 * Give potions.
	 *
	 * @param user
	 *            the user
	 */
	public void givePotions(User user) {
		for (String potionName : getPotions()) {
			user.givePotionEffect(potionName,
					getPotionsDuration().get(potionName), getPotionsAmplifier()
							.get(potionName));
		}
	}

	/**
	 * Give random.
	 *
	 * @param user
	 *            the user
	 * @param online
	 *            the online
	 */
	public void giveRandom(User user, boolean online) {
		if (checkRandomChance()) {
			ArrayList<String> rewards = getRandomRewards();
			if (rewards != null) {
				if (rewards.size() > 0) {
					String reward = rewards.get((int) Math.random()
							* rewards.size());
					if (!reward.equals("")) {
						RewardHandler.getInstance().giveReward(user, reward,
								online);
					}
				}
			}
		} else {
			for (String reward : getRandomFallBack()) {
				if (!reward.equals("")) {
					RewardHandler.getInstance()
							.giveReward(user, reward, online);
				}
			}
		}
	}

	public void giveReward(User user, boolean online) {
		giveReward(user, online, true);
	}

	public void giveReward(User user, boolean online, boolean giveOffline) {

		PlayerRewardEvent event = new PlayerRewardEvent(this, user);
		Bukkit.getPluginManager().callEvent(event);

		if (event.isCancelled()) {
			plugin.debug("Reward " + name + " was cancelled");
			return;
		}

		if (!online && !user.isOnline()) {
			if (giveOffline) {
				user.setOfflineRewards(this, user.getOfflineRewards(this) + 1);
			}
			return;
		}

		if (checkDelayed(user)) {
			return;
		}

		if (checkTimed(user)) {
			return;
		}

		giveRewardReward(user, online);
	}

	/**
	 * Give reward reward.
	 *
	 * @param user
	 *            the user
	 * @param online
	 *            the online
	 */
	public void giveRewardReward(User user, boolean online) {
		plugin.debug("Attempting to give " + user.getPlayerName() + " reward "
				+ name);

		String type = getRewardType();
		if (online) {
			if (type.equalsIgnoreCase("offline")) {
				plugin.debug("Reward Type Don't match");
				return;
			}
		} else {
			if (type.equalsIgnoreCase("online")) {
				plugin.debug("Reward Type Don't match");
				return;
			}
		}

		if (checkChance()) {
			ArrayList<String> worlds = getWorlds();
			Player player = Bukkit.getPlayer(user.getPlayerName());
			if ((player != null) && (worlds != null) && !worlds.isEmpty()) {
				if (isGiveInEachWorld()) {
					for (String world : worlds) {
						if (player.getWorld().getName().equals(world)) {
							giveRewardUser(user);
						} else {
							user.setOfflineRewardWorld(getRewardName(), world,
									user.getOfflineRewardWorld(getRewardName(),
											world) + 1);
						}
					}
				} else {
					if (worlds.contains(player.getWorld().getName())) {
						giveRewardUser(user);

					} else {
						user.setOfflineRewardWorld(getRewardName(), null,
								user.getOfflineRewardWorld(getRewardName(),
										null) + 1);

					}
				}
			} else {
				giveRewardUser(user);

			}
		}
	}

	/**
	 * Give reward user.
	 *
	 * @param user
	 *            the user
	 */
	public void giveRewardUser(User user) {
		Player player = Bukkit.getPlayer(user.getPlayerName());
		if (player != null) {
			if (hasPermission(user)) {
				giveRandom(user, true);
				runJavascript(user, true);
				int money = getMoneyToGive();
				giveMoney(user, money);
				giveItems(user);
				int exp = getExpToGive();
				giveExp(user, exp);
				runCommands(user);
				givePotions(user);
				sendTitle(user);
				sendActionBar(user);
				playSound(user);
				playEffect(user);
				sendBossBar(user);
				sendMessage(user, money, exp);
				checkChoiceRewards(user);
				sendFirework(user);

				plugin.debug("Gave " + user.getPlayerName() + " reward " + name);

			}
		}
	}

	/**
	 * Checks for permission.
	 *
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public boolean hasPermission(User user) {
		if (!isRequirePermission()) {
			return true;
		}
		return Utils.getInstance().hasServerPermission(user.getPlayerName(),
				permission);
	}

	/**
	 * Checks if is boss bar enabled.
	 *
	 * @return true, if is boss bar enabled
	 */
	public boolean isBossBarEnabled() {
		return bossBarEnabled;
	}

	/**
	 * Checks if is choice rewards enabled.
	 *
	 * @return true, if is choice rewards enabled
	 */
	public boolean isChoiceRewardsEnabled() {
		return choiceRewardsEnabled;
	}

	/**
	 * Checks if is delay enabled.
	 *
	 * @return true, if is delay enabled
	 */
	public boolean isDelayEnabled() {
		return delayEnabled;
	}

	/**
	 * Checks if is firework enabled.
	 *
	 * @return true, if is firework enabled
	 */
	public boolean isFireworkEnabled() {
		return fireworkEnabled;
	}

	/**
	 * Checks if is firework flicker.
	 *
	 * @return true, if is firework flicker
	 */
	public boolean isFireworkFlicker() {
		return fireworkFlicker;
	}

	/**
	 * Checks if is firework trail.
	 *
	 * @return true, if is firework trail
	 */
	public boolean isFireworkTrail() {
		return fireworkTrail;
	}

	/**
	 * Checks if is give in each world.
	 *
	 * @return true, if is give in each world
	 */
	public boolean isGiveInEachWorld() {
		return giveInEachWorld;
	}

	/**
	 * Checks if is javascript enabled.
	 *
	 * @return true, if is javascript enabled
	 */
	public boolean isJavascriptEnabled() {
		return javascriptEnabled;
	}

	/**
	 * Checks if is require permission.
	 *
	 * @return true, if is require permission
	 */
	public boolean isRequirePermission() {
		return requirePermission;
	}

	/**
	 * Checks if is timed enabled.
	 *
	 * @return true, if is timed enabled
	 */
	public boolean isTimedEnabled() {
		return timedEnabled;
	}

	public boolean isUsesWorlds() {
		return usesWorlds;
	}

	/**
	 * Play effect.
	 *
	 * @param user
	 *            the user
	 */
	public void playEffect(User user) {
		if (ConfigRewards.getInstance().getEffectEnabled(file, name)) {
			user.playParticleEffect(ConfigRewards.getInstance()
					.getEffectEffect(file, name), ConfigRewards.getInstance()
					.getEffectData(file, name), ConfigRewards.getInstance()
					.getEffectParticles(file, name), ConfigRewards
					.getInstance().getEffectRadius(file, name));
		}
	}

	/**
	 * Play sound.
	 *
	 * @param user
	 *            the user
	 */
	public void playSound(User user) {
		if (ConfigRewards.getInstance().getSoundEnabled(file, name)) {
			try {
				user.playSound(
						ConfigRewards.getInstance().getSoundSound(file, name),
						ConfigRewards.getInstance().getSoundVolume(file, name),
						ConfigRewards.getInstance().getSoundPitch(file, name));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Run commands.
	 *
	 * @param user
	 *            the user
	 */
	public void runCommands(User user) {
		String playerName = user.getPlayerName();

		// Console commands
		ArrayList<String> consolecmds = getConsoleCommands();

		if (consolecmds != null) {
			for (String consolecmd : consolecmds) {
				if (consolecmd.length() > 0) {
					consolecmd = consolecmd.replace("%player%", playerName);
					final String cmd = consolecmd;
					Bukkit.getScheduler().runTask(plugin, new Runnable() {

						@Override
						public void run() {
							Bukkit.getServer().dispatchCommand(
									Bukkit.getConsoleSender(), cmd);
						}
					});

				}
			}
		}

		// Player commands
		ArrayList<String> playercmds = getPlayerCommands();

		Player player = Bukkit.getPlayer(playerName);
		if (playercmds != null) {
			for (String playercmd : playercmds) {
				if ((player != null) && (playercmd.length() > 0)) {
					playercmd = playercmd.replace("%player%", playerName);
					final String cmd = playercmd;
					Bukkit.getScheduler().runTask(plugin, new Runnable() {

						@Override
						public void run() {
							player.performCommand(cmd);
						}
					});

				}
			}
		}
	}

	/**
	 * Run javascript.
	 *
	 * @param user
	 *            the user
	 * @param online
	 *            the online
	 */
	public void runJavascript(User user, boolean online) {
		if (isJavascriptEnabled()) {
			new JavascriptHandler(user, online, getJavascriptExpression(),
					getJavascriptTrueRewards(), getJavascriptFalseRewards());
		}
	}

	/**
	 * Send action bar.
	 *
	 * @param user
	 *            the user
	 */
	public void sendActionBar(User user) {
		user.sendActionBar(getActionBarMsg(), getActionBarDelay());
	}

	/**
	 * Send boss bar.
	 *
	 * @param user
	 *            the user
	 */
	public void sendBossBar(User user) {
		if (isBossBarEnabled()) {
			user.sendBossBar(getBossBarMessage(), getBossBarColor(),
					getBossBarStyle(), getBossBarProgress(), getBossBarDelay());
		}
	}

	/**
	 * Send firework.
	 *
	 * @param user
	 *            the user
	 */
	public void sendFirework(User user) {
		if (isFireworkEnabled()) {
			Utils.getInstance().launchFirework(user.getPlayer().getLocation(),
					getFireworkPower(), getFireworkColors(),
					getFireworkFadeOutColors(), isFireworkTrail(),
					isFireworkFlicker(), getFireworkTypes());
		}
	}

	public void sendMessage(User user, int money, int exp) {
		ArrayList<String> itemsAndAmounts = new ArrayList<String>();
		for (Entry<String, Integer> entry : itemsAndAmountsGiven.entrySet()) {
			itemsAndAmounts.add(entry.getValue() + " " + entry.getKey());
		}
		String itemsAndAmountsMsg = Utils.getInstance().makeStringList(
				itemsAndAmounts);

		String broadcastMsg = this.broadcastMsg;
		broadcastMsg = Utils.getInstance().replacePlaceHolder(broadcastMsg,
				"player", user.getPlayerName());

		broadcastMsg = Utils.getInstance().replacePlaceHolder(broadcastMsg,
				"money", "" + money);
		broadcastMsg = Utils.getInstance().replacePlaceHolder(broadcastMsg,
				"exp", "" + exp);
		broadcastMsg = Utils.getInstance().replacePlaceHolder(broadcastMsg,
				"itemsandamount", itemsAndAmountsMsg);
		broadcastMsg = Utils.getInstance().replacePlaceHolder(
				broadcastMsg,
				"items",
				Utils.getInstance().makeStringList(
						Utils.getInstance().convert(getItems())));

		Utils.getInstance().broadcast(
				Utils.getInstance().replacePlaceHolders(user.getPlayer(),
						broadcastMsg));

		String msg = Utils.getInstance().replacePlaceHolder(rewardMsg,
				"player", user.getPlayerName());

		msg = Utils.getInstance().replacePlaceHolder(msg, "money", "" + money);
		msg = Utils.getInstance().replacePlaceHolder(msg, "exp", "" + exp);
		msg = Utils.getInstance().replacePlaceHolder(msg, "itemsandamount",
				itemsAndAmountsMsg);
		msg = Utils.getInstance().replacePlaceHolder(
				msg,
				"items",
				Utils.getInstance().makeStringList(
						Utils.getInstance().convert(getItems())));

		user.sendMessage(msg);

	}

	/**
	 * Send title.
	 *
	 * @param user
	 *            the user
	 */
	public void sendTitle(User user) {
		if (ConfigRewards.getInstance().getTitleEnabled(file, name)) {
			user.sendTitle(ConfigRewards.getInstance()
					.getTitleTitle(file, name),

			ConfigRewards.getInstance().getTitleSubTitle(file, name),

			ConfigRewards.getInstance().getTitleFadeIn(file, name),
					ConfigRewards.getInstance().getTitleShowTime(file, name),
					ConfigRewards.getInstance().getTitleFadeOut(file, name));
		}
	}

	public File getFile() {
		return file;
	}

	/**
	 * Sets the action bar delay.
	 *
	 * @param actionBarDelay
	 *            the new action bar delay
	 */
	public void setActionBarDelay(int actionBarDelay) {
		this.actionBarDelay = actionBarDelay;
	}

	/**
	 * Sets the action bar msg.
	 *
	 * @param actionBarMsg
	 *            the new action bar msg
	 */
	public void setActionBarMsg(String actionBarMsg) {
		this.actionBarMsg = actionBarMsg;
	}

	/**
	 * Sets the boss bar color.
	 *
	 * @param bossBarColor
	 *            the new boss bar color
	 */
	public void setBossBarColor(String bossBarColor) {
		this.bossBarColor = bossBarColor;
	}

	/**
	 * Sets the boss bar delay.
	 *
	 * @param bossBarDelay
	 *            the new boss bar delay
	 */
	public void setBossBarDelay(int bossBarDelay) {
		this.bossBarDelay = bossBarDelay;
	}

	/**
	 * Sets the boss bar enabled.
	 *
	 * @param bossBarEnabled
	 *            the new boss bar enabled
	 */
	public void setBossBarEnabled(boolean bossBarEnabled) {
		this.bossBarEnabled = bossBarEnabled;
	}

	/**
	 * Sets the boss bar message.
	 *
	 * @param bossBarMessage
	 *            the new boss bar message
	 */
	public void setBossBarMessage(String bossBarMessage) {
		this.bossBarMessage = bossBarMessage;
	}

	/**
	 * Sets the boss bar progress.
	 *
	 * @param bossBarProgress
	 *            the new boss bar progress
	 */
	public void setBossBarProgress(double bossBarProgress) {
		this.bossBarProgress = bossBarProgress;
	}

	/**
	 * Sets the boss bar style.
	 *
	 * @param bossBarStyle
	 *            the new boss bar style
	 */
	public void setBossBarStyle(String bossBarStyle) {
		this.bossBarStyle = bossBarStyle;
	}

	/**
	 * Sets the broadcast msg.
	 *
	 * @param broadcastMsg
	 *            the new broadcast msg
	 */
	public void setBroadcastMsg(String broadcastMsg) {
		this.broadcastMsg = broadcastMsg;
	}

	/**
	 * Sets the chance.
	 *
	 * @param chance
	 *            the new chance
	 */
	public void setChance(double chance) {
		this.chance = chance;
	}

	/**
	 * Sets the choice rewards enabled.
	 *
	 * @param choiceRewardsEnabled
	 *            the new choice rewards enabled
	 */
	public void setChoiceRewardsEnabled(boolean choiceRewardsEnabled) {
		this.choiceRewardsEnabled = choiceRewardsEnabled;
	}

	/**
	 * Sets the choice rewards rewards.
	 *
	 * @param choiceRewardsRewards
	 *            the new choice rewards rewards
	 */
	public void setChoiceRewardsRewards(ArrayList<String> choiceRewardsRewards) {
		this.choiceRewardsRewards = choiceRewardsRewards;
	}

	/**
	 * Sets the console commands.
	 *
	 * @param consoleCommands
	 *            the new console commands
	 */
	public void setConsoleCommands(ArrayList<String> consoleCommands) {
		this.consoleCommands = consoleCommands;
	}

	/**
	 * Sets the delay enabled.
	 *
	 * @param delayEnabled
	 *            the new delay enabled
	 */
	public void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
	}

	/**
	 * Sets the delay hours.
	 *
	 * @param delayHours
	 *            the new delay hours
	 */
	public void setDelayHours(int delayHours) {
		this.delayHours = delayHours;
	}

	/**
	 * Sets the delay minutes.
	 *
	 * @param delayMinutes
	 *            the new delay minutes
	 */
	public void setDelayMinutes(int delayMinutes) {
		this.delayMinutes = delayMinutes;
	}

	/**
	 * Sets the exp.
	 *
	 * @param exp
	 *            the new exp
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * Sets the firework colors.
	 *
	 * @param fireworkColors
	 *            the new firework colors
	 */
	public void setFireworkColors(ArrayList<String> fireworkColors) {
		this.fireworkColors = fireworkColors;
	}

	/**
	 * Sets the firework enabled.
	 *
	 * @param fireworkEnabled
	 *            the new firework enabled
	 */
	public void setFireworkEnabled(boolean fireworkEnabled) {
		this.fireworkEnabled = fireworkEnabled;
	}

	/**
	 * Sets the firework fade out colors.
	 *
	 * @param fireworkFadeOutColors
	 *            the new firework fade out colors
	 */
	public void setFireworkFadeOutColors(ArrayList<String> fireworkFadeOutColors) {
		this.fireworkFadeOutColors = fireworkFadeOutColors;
	}

	/**
	 * Sets the firework flicker.
	 *
	 * @param fireworkFlicker
	 *            the new firework flicker
	 */
	public void setFireworkFlicker(boolean fireworkFlicker) {
		this.fireworkFlicker = fireworkFlicker;
	}

	/**
	 * Sets the firework power.
	 *
	 * @param fireworkPower
	 *            the new firework power
	 */
	public void setFireworkPower(int fireworkPower) {
		this.fireworkPower = fireworkPower;
	}

	/**
	 * Sets the firework trail.
	 *
	 * @param fireworkTrail
	 *            the new firework trail
	 */
	public void setFireworkTrail(boolean fireworkTrail) {
		this.fireworkTrail = fireworkTrail;
	}

	/**
	 * Sets the firework types.
	 *
	 * @param fireworkTypes
	 *            the new firework types
	 */
	public void setFireworkTypes(ArrayList<String> fireworkTypes) {
		this.fireworkTypes = fireworkTypes;
	}

	/**
	 * Sets the give in each world.
	 *
	 * @param giveInEachWorld
	 *            the new give in each world
	 */
	public void setGiveInEachWorld(boolean giveInEachWorld) {
		this.giveInEachWorld = giveInEachWorld;
	}

	/**
	 * Sets the item amount.
	 *
	 * @param itemAmount
	 *            the item amount
	 */
	public void setItemAmount(HashMap<String, Integer> itemAmount) {
		this.itemAmount = itemAmount;
	}

	/**
	 * Sets the item data.
	 *
	 * @param itemData
	 *            the item data
	 */
	public void setItemData(HashMap<String, Integer> itemData) {
		this.itemData = itemData;
	}

	/**
	 * Sets the item durabilty.
	 *
	 * @param itemDurabilty
	 *            the item durabilty
	 */
	public void setItemDurabilty(HashMap<String, Integer> itemDurabilty) {
		this.itemDurabilty = itemDurabilty;
	}

	/**
	 * Sets the item enchants.
	 *
	 * @param itemEnchants
	 *            the item enchants
	 */
	public void setItemEnchants(
			HashMap<String, HashMap<String, Integer>> itemEnchants) {
		this.itemEnchants = itemEnchants;
	}

	/**
	 * Sets the item lore.
	 *
	 * @param itemLore
	 *            the item lore
	 */
	public void setItemLore(HashMap<String, ArrayList<String>> itemLore) {
		this.itemLore = itemLore;
	}

	/**
	 * Sets the item material.
	 *
	 * @param itemMaterial
	 *            the item material
	 */
	public void setItemMaterial(HashMap<String, String> itemMaterial) {
		this.itemMaterial = itemMaterial;
	}

	/**
	 * Sets the item max amount.
	 *
	 * @param itemMaxAmount
	 *            the item max amount
	 */
	public void setItemMaxAmount(HashMap<String, Integer> itemMaxAmount) {
		this.itemMaxAmount = itemMaxAmount;
	}

	/**
	 * Sets the item min amount.
	 *
	 * @param itemMinAmount
	 *            the item min amount
	 */
	public void setItemMinAmount(HashMap<String, Integer> itemMinAmount) {
		this.itemMinAmount = itemMinAmount;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName
	 *            the item name
	 */
	public void setItemName(HashMap<String, String> itemName) {
		this.itemName = itemName;
	}

	/**
	 * Sets the items.
	 *
	 * @param items
	 *            the new items
	 */
	public void setItems(Set<String> items) {
		this.items = items;
	}

	/**
	 * Sets the item skull.
	 *
	 * @param itemSkull
	 *            the item skull
	 */
	public void setItemSkull(HashMap<String, String> itemSkull) {
		this.itemSkull = itemSkull;
	}

	/**
	 * Sets the javascript enabled.
	 *
	 * @param javascriptEnabled
	 *            the new javascript enabled
	 */
	public void setJavascriptEnabled(boolean javascriptEnabled) {
		this.javascriptEnabled = javascriptEnabled;
	}

	/**
	 * Sets the javascript expression.
	 *
	 * @param javascriptExpression
	 *            the new javascript expression
	 */
	public void setJavascriptExpression(String javascriptExpression) {
		this.javascriptExpression = javascriptExpression;
	}

	/**
	 * Sets the javascript false rewards.
	 *
	 * @param javascriptFalseRewards
	 *            the new javascript false rewards
	 */
	public void setJavascriptFalseRewards(
			ArrayList<String> javascriptFalseRewards) {
		this.javascriptFalseRewards = javascriptFalseRewards;
	}

	/**
	 * Sets the javascript true rewards.
	 *
	 * @param javascriptTrueRewards
	 *            the new javascript true rewards
	 */
	public void setJavascriptTrueRewards(ArrayList<String> javascriptTrueRewards) {
		this.javascriptTrueRewards = javascriptTrueRewards;
	}

	/**
	 * Sets the max exp.
	 *
	 * @param maxExp
	 *            the new max exp
	 */
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	/**
	 * Sets the max money.
	 *
	 * @param maxMoney
	 *            the new max money
	 */
	public void setMaxMoney(int maxMoney) {
		MaxMoney = maxMoney;
	}

	/**
	 * Sets the min exp.
	 *
	 * @param minExp
	 *            the new min exp
	 */
	public void setMinExp(int minExp) {
		this.minExp = minExp;
	}

	/**
	 * Sets the min money.
	 *
	 * @param minMoney
	 *            the new min money
	 */
	public void setMinMoney(int minMoney) {
		MinMoney = minMoney;
	}

	/**
	 * Sets the money.
	 *
	 * @param money
	 *            the new money
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Sets the permission.
	 *
	 * @param permission
	 *            the new permission
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * Sets the player commands.
	 *
	 * @param playerCommands
	 *            the new player commands
	 */
	public void setPlayerCommands(ArrayList<String> playerCommands) {
		this.playerCommands = playerCommands;
	}

	/**
	 * Sets the potions.
	 *
	 * @param potions
	 *            the new potions
	 */
	public void setPotions(Set<String> potions) {
		this.potions = potions;
	}

	/**
	 * Sets the potions amplifier.
	 *
	 * @param potionsAmplifier
	 *            the potions amplifier
	 */
	public void setPotionsAmplifier(HashMap<String, Integer> potionsAmplifier) {
		this.potionsAmplifier = potionsAmplifier;
	}

	/**
	 * Sets the potions duration.
	 *
	 * @param potionsDuration
	 *            the potions duration
	 */
	public void setPotionsDuration(HashMap<String, Integer> potionsDuration) {
		this.potionsDuration = potionsDuration;
	}

	/**
	 * Sets the random chance.
	 *
	 * @param randomChance
	 *            the new random chance
	 */
	public void setRandomChance(double randomChance) {
		this.randomChance = randomChance;
	}

	/**
	 * Sets the random fall back.
	 *
	 * @param randomFallBack
	 *            the new random fall back
	 */
	public void setRandomFallBack(ArrayList<String> randomFallBack) {
		this.randomFallBack = randomFallBack;
	}

	/**
	 * Sets the random rewards.
	 *
	 * @param randomRewards
	 *            the new random rewards
	 */
	public void setRandomRewards(ArrayList<String> randomRewards) {
		this.randomRewards = randomRewards;
	}

	/**
	 * Sets the require permission.
	 *
	 * @param requirePermission
	 *            the new require permission
	 */
	public void setRequirePermission(boolean requirePermission) {
		this.requirePermission = requirePermission;
	}

	/**
	 * Sets the reward msg.
	 *
	 * @param rewardMsg
	 *            the new reward msg
	 */
	public void setRewardMsg(String rewardMsg) {
		this.rewardMsg = rewardMsg;
	}

	/**
	 * Sets the reward type.
	 *
	 * @param rewardType
	 *            the new reward type
	 */
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	/**
	 * Sets the timed enabled.
	 *
	 * @param timedEnabled
	 *            the new timed enabled
	 */
	public void setTimedEnabled(boolean timedEnabled) {
		this.timedEnabled = timedEnabled;
	}

	/**
	 * Sets the timed hour.
	 *
	 * @param timedHour
	 *            the new timed hour
	 */
	public void setTimedHour(int timedHour) {
		this.timedHour = timedHour;
	}

	/**
	 * Sets the timed minute.
	 *
	 * @param timedMinute
	 *            the new timed minute
	 */
	public void setTimedMinute(int timedMinute) {
		this.timedMinute = timedMinute;
	}

	public void setUsesWorlds(boolean usesWorlds) {
		this.usesWorlds = usesWorlds;
	}

	/**
	 * Sets the worlds.
	 *
	 * @param worlds
	 *            the new worlds
	 */
	public void setWorlds(ArrayList<String> worlds) {
		this.worlds = worlds;
	}

}
