package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShowSPProcedure {
	public static String execute() {
		return "SP: " + new java.text.DecimalFormat("###,###,###,###,###").format();
	}
}
