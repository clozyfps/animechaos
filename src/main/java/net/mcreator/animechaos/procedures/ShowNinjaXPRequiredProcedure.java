package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShowNinjaXPRequiredProcedure {
	public static String execute() {
		return "XP: " + new java.text.DecimalFormat("###,###,###,###").format() + "/" + new java.text.DecimalFormat("###,###,###,###").format();
	}
}
