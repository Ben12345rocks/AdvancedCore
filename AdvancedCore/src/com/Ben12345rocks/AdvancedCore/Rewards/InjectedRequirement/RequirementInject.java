package com.Ben12345rocks.AdvancedCore.Rewards.InjectedRequirement;

import java.util.ArrayList;

import org.bukkit.configuration.ConfigurationSection;

import com.Ben12345rocks.AdvancedCore.Rewards.Reward;
import com.Ben12345rocks.AdvancedCore.Rewards.RewardOptions;
import com.Ben12345rocks.AdvancedCore.UserManager.User;
import com.Ben12345rocks.AdvancedCore.Util.EditGUI.EditGUIButton;

import lombok.Getter;
import lombok.Setter;

public abstract class RequirementInject {
	@Getter
	@Setter
	private String path;

	@Getter
	@Setter
	private boolean internalReward = false;

	@Getter
	@Setter
	private ArrayList<EditGUIButton> editButtons = new ArrayList<EditGUIButton>();

	@Getter
	private int priority = 50;

	public RequirementInject(String path) {
		this.path = path;
	}

	public RequirementInject addEditButton(EditGUIButton button) {
		editButtons.add(button);
		return this;
	}

	public boolean isEditable() {
		return !editButtons.isEmpty();
	}

	public RequirementInject priority(int priority) {
		this.priority = priority;
		return this;
	}

	public RequirementInject alwaysForce() {
		this.alwaysForce = true;
		return this;
	}

	@Getter
	private boolean allowReattempt = false;

	public RequirementInject allowReattempt() {
		this.allowReattempt = true;
		return this;
	}

	@Getter
	private boolean alwaysForce = false;

	public abstract boolean onRequirementRequest(Reward reward, User user, ConfigurationSection data,
			RewardOptions rewardOptions);
}