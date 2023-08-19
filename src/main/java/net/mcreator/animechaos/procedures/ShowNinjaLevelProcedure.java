package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShowNinjaLevelProcedure {
	public static String execute() {
		return "Level: " + new java.text.DecimalFormat("###,###,###,###").format();
	}
}
