package com.blakebr0.mysticalagradditions.items;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.cucumber.registry.Ore;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.lib.CropType;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.lib.ModToolMaterials;

import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;

public class ModItems {

	public static ItemInsanium itemInsanium = new ItemInsanium();
	public static ItemStuff itemStuff = new ItemStuff();

	public static ItemTier6Seed itemTier6InferiumSeeds = new ItemTier6Seed("tier6_inferium_seeds", ModBlocks.blockTier6InferiumCrop);


	public static void init() {
		final ModRegistry registry = MysticalAgradditions.REGISTRY;

		registry.register(itemInsanium, "insanium", Ore.of(0, "essenceInsanium"), Ore.of(2, "ingotInsanium"), Ore.of(3, "nuggetInsanium"));
		registry.register(itemStuff, "stuff");

		for (CropType.Type type : CropType.Type.values()) {
			if (type.isEnabled()) {
				registry.register(type.getCrop(), type.getName() + "_essence");
				if (MAHelper.config.confGenericOreDictEssence) {
					registry.addOre(type.getCrop(), "essenceTier6");
				}
			}
		}

		registry.register(itemTier6InferiumSeeds, "tier6_inferium_seeds");

		for (CropType.Type type : CropType.Type.values()) {
			if (type.isEnabled()) {
				registry.register(type.getSeed(), type.getName() + "_seeds");
				if (MAHelper.config.confGenericOreDictEssence) {
					registry.addOre(type.getSeed(), "seedsTier6");
				}
			}
		}

		if (MAHelper.config.confGearModuleOverride) {


		}
	}
}
