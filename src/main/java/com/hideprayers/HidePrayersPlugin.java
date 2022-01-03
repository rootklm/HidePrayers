package com.hideprayers;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HashTable;
import net.runelite.api.WidgetNode;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
		name = "Hide Prayers"
)

public class HidePrayersPlugin extends Plugin
{
	private static final List<WidgetInfo> PRAYER_WIDGET_INFO_LIST = ImmutableList.of(
			WidgetInfo.PRAYER_THICK_SKIN, //0
			WidgetInfo.PRAYER_BURST_OF_STRENGTH, //1
			WidgetInfo.PRAYER_CLARITY_OF_THOUGHT, //2
			WidgetInfo.PRAYER_SHARP_EYE, //3
			WidgetInfo.PRAYER_MYSTIC_WILL, //4
			WidgetInfo.PRAYER_ROCK_SKIN, //5
			WidgetInfo.PRAYER_SUPERHUMAN_STRENGTH, //6
			WidgetInfo.PRAYER_IMPROVED_REFLEXES, //7
			WidgetInfo.PRAYER_RAPID_RESTORE, //8
			WidgetInfo.PRAYER_RAPID_HEAL, //9
			WidgetInfo.PRAYER_PROTECT_ITEM, //10
			WidgetInfo.PRAYER_HAWK_EYE, //11
			WidgetInfo.PRAYER_MYSTIC_LORE, //12
			WidgetInfo.PRAYER_STEEL_SKIN, //13
			WidgetInfo.PRAYER_ULTIMATE_STRENGTH, //14
			WidgetInfo.PRAYER_INCREDIBLE_REFLEXES, //15
			WidgetInfo.PRAYER_PROTECT_FROM_MAGIC, //16
			WidgetInfo.PRAYER_PROTECT_FROM_MISSILES, //17
			WidgetInfo.PRAYER_PROTECT_FROM_MELEE, //18
			WidgetInfo.PRAYER_EAGLE_EYE, //19
			WidgetInfo.PRAYER_MYSTIC_MIGHT, //20
			WidgetInfo.PRAYER_RETRIBUTION, //21
			WidgetInfo.PRAYER_REDEMPTION, //22
			WidgetInfo.PRAYER_SMITE, //23
			WidgetInfo.PRAYER_PRESERVE, //24
			WidgetInfo.PRAYER_CHIVALRY, //25
			WidgetInfo.PRAYER_PIETY,  //26
			WidgetInfo.PRAYER_RIGOUR, //27
			WidgetInfo.PRAYER_AUGURY //28
	);

	@Inject
	private Client client;

	@Inject
	private HidePrayersConfig config;

	private boolean ShowTHICK_SKIN;
	private boolean ShowBURST_OF_STRENGTH;
	private boolean ShowCLARITY_OF_THOUGHT;
	private boolean ShowSHARP_EYE;
	private boolean ShowMYSTIC_WILL;
	private boolean ShowROCK_SKIN;
	private boolean ShowSUPERHUMAN_STRENGTH;
	private boolean ShowIMPROVED_REFLEXES;
	private boolean ShowRapidRestore;
	private boolean ShowRapidHeal;
	private boolean ShowProtectItem;
	private boolean ShowHAWK_EYE;
	private boolean ShowMYSTIC_LORE;
	private boolean ShowSteelSkin;
	private boolean ShowUltimateStrength;
	private boolean ShowIncredibleReflex;
	private boolean ShowPTFMagic;
	private boolean ShowPTFRange;
	private boolean ShowPTFMelee;
	private boolean ShowEagle;
	private boolean ShowMystic;
	private boolean ShowRETRIBUTION;
	private boolean ShowRedemption;
	private boolean ShowSmite;
	private boolean ShowPreserve;
	private boolean ShowChivalry;
	private boolean ShowPiety;
	private boolean ShowRigour;
	private boolean ShowAugury;

	private enum PrayerTabStates
	{
		NONE,
		PRAYERS,
		QUICK_PRAYERS
	}

	@Provides
	HidePrayersConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HidePrayersConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();

		hidePrayers();
	}

	@Override
	protected void shutDown()
	{
		restorePrayers();
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			reallyHidePrayers();
			hidePrayers();
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("hideprayers"))
		{
			updateConfig();
			hidePrayers();
		}
	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.PRAYER_GROUP_ID || event.getGroupId() == WidgetID.QUICK_PRAYERS_GROUP_ID)
		{
			hidePrayers();
		}
	}

	private PrayerTabStates getPrayerTabState()
	{
		HashTable<WidgetNode> componentTable = client.getComponentTable();
		for (WidgetNode widgetNode : componentTable)
		{
			if (widgetNode.getId() == WidgetID.PRAYER_GROUP_ID)
			{
				return PrayerTabStates.PRAYERS;
			}
			else if (widgetNode.getId() == WidgetID.QUICK_PRAYERS_GROUP_ID)
			{
				return PrayerTabStates.QUICK_PRAYERS;
			}
		}
		return PrayerTabStates.NONE;
	}

	private void restorePrayers()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS) {
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
					.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size()) {
				return;
			}

			for (Widget w : prayerWidgets) {
				w.setHidden(false);
			}
		}
	}

	private void reallyHidePrayers()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS) {
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
					.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size()) {
				return;
			}

			for (Widget w : prayerWidgets) {
				w.setHidden(true);
			}
		}
	}

	private void hidePrayers()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS) {
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
					.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size()) {
				return;
			}

			reallyHidePrayers();

			prayerWidgets.get(0).setHidden(!this.ShowTHICK_SKIN);   // Thick Skin
			prayerWidgets.get(1).setHidden(!this.ShowBURST_OF_STRENGTH);   // Burst of Strength
			prayerWidgets.get(2).setHidden(!this.ShowCLARITY_OF_THOUGHT);   // Clarity of Thought
			prayerWidgets.get(3).setHidden(!this.ShowSHARP_EYE);   // Sharp Eye
			prayerWidgets.get(4).setHidden(!this.ShowMYSTIC_WILL);   // Mystic Will
			prayerWidgets.get(5).setHidden(!this.ShowROCK_SKIN);   // Rock Skin
			prayerWidgets.get(6).setHidden(!this.ShowSUPERHUMAN_STRENGTH);   // Super Human Strength
			prayerWidgets.get(7).setHidden(!this.ShowIMPROVED_REFLEXES);   // Improved_Reflexes
			prayerWidgets.get(8).setHidden(!this.ShowRapidRestore);   // Rapid Restore
			prayerWidgets.get(9).setHidden(!this.ShowRapidHeal);   // Rapid Heal
			prayerWidgets.get(10).setHidden(!this.ShowProtectItem);   // Protect Item
			prayerWidgets.get(11).setHidden(!this.ShowHAWK_EYE);   // Hawk Eye
			prayerWidgets.get(12).setHidden(!this.ShowMYSTIC_LORE);   // Mystic Lore
			prayerWidgets.get(13).setHidden(!this.ShowSteelSkin);   // Steel Skin
			prayerWidgets.get(14).setHidden(!this.ShowUltimateStrength);   // Ultimate Strength
			prayerWidgets.get(15).setHidden(!this.ShowIncredibleReflex);   // Incredible Reflexes
			prayerWidgets.get(16).setHidden(!this.ShowPTFMagic);   // Protect from Magic
			prayerWidgets.get(17).setHidden(!this.ShowPTFRange);   // Protect from Range
			prayerWidgets.get(18).setHidden(!this.ShowPTFMelee);   // Protect from Melee
			prayerWidgets.get(19).setHidden(!this.ShowEagle);   // eagle eye
			prayerWidgets.get(20).setHidden(!this.ShowMystic);   // Mystic Might
			prayerWidgets.get(21).setHidden(!this.ShowRETRIBUTION);   // Retribution
			prayerWidgets.get(22).setHidden(!this.ShowRedemption);   // Redemption
			prayerWidgets.get(23).setHidden(!this.ShowSmite);   // Smite
			prayerWidgets.get(24).setHidden(!this.ShowPreserve);   // Preserve
			prayerWidgets.get(25).setHidden(!this.ShowChivalry);   // Chivalry
			prayerWidgets.get(26).setHidden(!this.ShowPiety);   // Piety
			prayerWidgets.get(27).setHidden(!this.ShowRigour);   // Rigour
			prayerWidgets.get(28).setHidden(!this.ShowAugury);   // Augury

		}
	}

	private void updateConfig()
	{
		this.ShowTHICK_SKIN = config.ShowTHICK_SKIN();
		this.ShowBURST_OF_STRENGTH = config.ShowBURST_OF_STRENGTH();
		this.ShowCLARITY_OF_THOUGHT = config.ShowCLARITY_OF_THOUGHT();
		this.ShowSHARP_EYE = config.ShowSHARP_EYE();
		this.ShowMYSTIC_WILL = config.ShowMYSTIC_WILL();
		this.ShowROCK_SKIN = config.ShowROCK_SKIN();
		this.ShowSUPERHUMAN_STRENGTH = config.ShowSUPERHUMAN_STRENGTH();
		this.ShowIMPROVED_REFLEXES = config.ShowIMPROVED_REFLEXES();
		this.ShowRapidRestore = config.ShowRapidRestore();
		this.ShowRapidHeal = config.ShowRapidHeal();
		this.ShowProtectItem = config.ShowProtectItem();
		this.ShowHAWK_EYE = config.ShowHAWK_EYE();
		this.ShowMYSTIC_LORE = config.ShowMYSTIC_LORE();
		this.ShowSteelSkin = config.ShowSteelSkin();
		this.ShowUltimateStrength = config.ShowUltimateStrength();
		this.ShowIncredibleReflex = config.ShowIncredibleReflex();
		this.ShowPTFMagic = config.ShowPTFMagic();
		this.ShowPTFRange = config.ShowPTFRange();
		this.ShowPTFMelee = config.ShowPTFMelee();
		this.ShowEagle = config.ShowEagle();
		this.ShowMystic = config.ShowMystic();
		this.ShowRETRIBUTION = config.ShowRETRIBUTION();
		this.ShowRedemption = config.ShowRedemption();
		this.ShowSmite = config.ShowSmite();
		this.ShowPreserve = config.ShowPreserve();
		this.ShowChivalry = config.ShowChivalry();
		this.ShowPiety = config.ShowPiety();
		this.ShowRigour = config.ShowRigour();
		this.ShowAugury = config.ShowAugury();
	}
}
