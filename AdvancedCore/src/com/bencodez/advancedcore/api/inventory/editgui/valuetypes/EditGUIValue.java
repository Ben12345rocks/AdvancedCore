package com.bencodez.advancedcore.api.inventory.editgui.valuetypes;

import java.util.ArrayList;

import com.bencodez.advancedcore.api.inventory.BInventory;
import com.bencodez.advancedcore.api.inventory.BInventory.ClickEvent;

import lombok.Getter;
import lombok.Setter;

public abstract class EditGUIValue {
	@Getter
	@Setter
	private String key;

	@Getter
	@Setter
	private Object currentValue;

	@Getter
	private ArrayList<String> options = new ArrayList<String>();

	@Getter
	@Setter
	private BInventory inv;

	public EditGUIValue addOptions(String... str) {
		for (String s : str) {
			options.add(s);
		}
		return this;
	}

	public abstract void onClick(ClickEvent event);
}
