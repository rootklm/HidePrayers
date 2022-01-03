/*
 * Copyright (c) 2018, https://openosrs.com
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2018, Raiever <https://github.com/Raieverr>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.hideprayers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(HidePrayersConfig.GROUP)
public interface HidePrayersConfig extends Config
{
	String GROUP = "hideprayers";

	@ConfigItem(
			position = 1,
			keyName = "ShowTHICK_SKIN",
			name = "Show Thick Skin",
			description = "Hide/Show Thick Skin"
	)
	default boolean ShowTHICK_SKIN()
	{
		return false;
	}

	@ConfigItem(
			position = 2,
			keyName = "ShowBURST_OF_STRENGTH",
			name = "Show Burst of Strength",
			description = "Hide/Show Burst of Strength"
	)
	default boolean ShowBURST_OF_STRENGTH()
	{
		return false;
	}

	@ConfigItem(
			position = 3,
			keyName = "ShowCLARITY_OF_THOUGHT",
			name = "Show Clarity of Thought",
			description = "Hide/Show Clarity of Thought"
	)
	default boolean ShowCLARITY_OF_THOUGHT()
	{
		return false;
	}

	@ConfigItem(
			position = 4,
			keyName = "ShowSHARP_EYE",
			name = "Show Sharp Eye",
			description = "Hide/Show Sharp Eye"
	)
	default boolean ShowSHARP_EYE()
	{
		return false;
	}

	@ConfigItem(
			position = 5,
			keyName = "ShowMYSTIC_WILL",
			name = "Show Mystic Will",
			description = "Hide/Show Mystic Will"
	)
	default boolean ShowMYSTIC_WILL()
	{
		return false;
	}

	@ConfigItem(
			position = 6,
			keyName = "ShowROCK_SKIN",
			name = "Show Rock Skin",
			description = "Hide/Show Rock Skin"
	)
	default boolean ShowROCK_SKIN()
	{
		return false;
	}

	@ConfigItem(
			position = 7,
			keyName = "ShowSUPERHUMAN_STRENGTH",
			name = "Show Super Human Strength",
			description = "Hide/Show Super Human Strength"
	)
	default boolean ShowSUPERHUMAN_STRENGTH()
	{
		return false;
	}

	@ConfigItem(
			position = 8,
			keyName = "ShowIMPROVED_REFLEXES",
			name = "Show Improved_Reflexes",
			description = "Hide/Show Improved_Reflexes"
	)
	default boolean ShowIMPROVED_REFLEXES()
	{
		return false;
	}

	@ConfigItem(
			position = 9,
			keyName = "ShowRapidRestore",
			name = "Show Rapid Restore",
			description = "Hide/Show Rapid Restore"
	)
	default boolean ShowRapidRestore()
	{
		return false;
	}

	@ConfigItem(
			position = 10,
			keyName = "ShowRapidHeal",
			name = "Show Rapid Heal",
			description = "Hide/Show Rapid Heal"
	)
	default boolean ShowRapidHeal()
	{
		return false;
	}

	@ConfigItem(
			position = 11,
			keyName = "ShowProtectItem",
			name = "Show Protect Item",
			description = "Hide/Show Protect Item"
	)
	default boolean ShowProtectItem()
	{
		return false;
	}

	@ConfigItem(
			position = 12,
			keyName = "ShowHAWK_EYE",
			name = "Show Hawk Eye",
			description = "Hide/Show Hawk Eye"
	)
	default boolean ShowHAWK_EYE()
	{
		return false;
	}

	@ConfigItem(
			position = 13,
			keyName = "ShowMYSTIC_LORE",
			name = "Show Mystic Lore",
			description = "Hide/Show Mystic Lore"
	)
	default boolean ShowMYSTIC_LORE()
	{
		return false;
	}


	@ConfigItem(
			position = 14,
			keyName = "ShowSteelSkin",
			name = "Show Steel Skin",
			description = "Hide/Show Steel skin"
	)
	default boolean ShowSteelSkin()
	{
		return false;
	}

	@ConfigItem(
			position = 15,
			keyName = "ShowUltimateStrength",
			name = "Show Ultimate Strength",
			description = "Hide/Show Ultimate strength"
	)
	default boolean ShowUltimateStrength()
	{
		return false;
	}

	@ConfigItem(
			position = 16,
			keyName = "ShowIncredibleReflex",
			name = "Show Incredible Reflex",
			description = "Hide/Show Incredible Reflex"
	)
	default boolean ShowIncredibleReflex()
	{
		return false;
	}

	@ConfigItem(
			position = 17,
			keyName = "ShowPTFMagic",
			name = "Show Protect From Magic",
			description = "Hide/Show Protect From Magic"
	)
	default boolean ShowPTFMagic()
	{
		return false;
	}

	@ConfigItem(
			position = 18,
			keyName = "ShowPTFRange",
			name = "Show Protect From Range",
			description = "Hide/Show Protect from Range"
	)
	default boolean ShowPTFRange()
	{
		return false;
	}

	@ConfigItem(
			position = 19,
			keyName = "ShowPTFMelee",
			name = "Show Protect From Melee",
			description = "Hide/Show Protect From Melee"
	)
	default boolean ShowPTFMelee()
	{
		return false;
	}

	@ConfigItem(
			position = 20,
			keyName = "ShowEagle",
			name = "Show Eagle Eye",
			description = "Hide/Show Eagle Eye"
	)
	default boolean ShowEagle()
	{
		return false;
	}

	@ConfigItem(
			position = 19,
			keyName = "ShowMystic",
			name = "Show Mystic Might",
			description = "Hide/Show Mystic Might"
	)
	default boolean ShowMystic()
	{
		return false;
	}

	@ConfigItem(
			position = 21,
			keyName = "ShowRETRIBUTION",
			name = "Show Retribution",
			description = "Hide/Show Retribution"
	)
	default boolean ShowRETRIBUTION()
	{
		return false;
	}

	@ConfigItem(
			position = 22,
			keyName = "ShowRedemption",
			name = "Show Redemption",
			description = "Hide/Show Redemption"
	)
	default boolean ShowRedemption()
	{
		return false;
	}

	@ConfigItem(
			position = 23,
			keyName = "ShowSmite",
			name = "Show Smite",
			description = "Hide/Show Smite"
	)
	default boolean ShowSmite()
	{
		return false;
	}

	@ConfigItem(
			position = 24,
			keyName = "ShowPreserve",
			name = "Show Preserve",
			description = "Hide/Show Preserve"
	)
	default boolean ShowPreserve()
	{
		return false;
	}

	@ConfigItem(
			position = 25,
			keyName = "ShowChivalry",
			name = "Show Chivalry",
			description = "Hide/Show Chivalry"
	)
	default boolean ShowChivalry()
	{
		return false;
	}

	@ConfigItem(
			position = 26,
			keyName = "ShowPiety",
			name = "Show Piety",
			description = "Hide/Show Piety"
	)
	default boolean ShowPiety()
	{
		return false;
	}

	@ConfigItem(
			position = 27,
			keyName = "ShowRigour",
			name = "Show Rigour",
			description = "Hide/Show Rigour"
	)
	default boolean ShowRigour()
	{
		return false;
	}

	@ConfigItem(
			position = 28,
			keyName = "ShowAugury",
			name = "Show Augury",
			description = "Hide/Show Augury"
	)
	default boolean ShowAugury()
	{
		return false;
	}
}
