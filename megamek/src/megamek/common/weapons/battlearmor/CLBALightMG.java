/**
 * MegaMek - Copyright (C) 2004,2005 Ben Mazur (bmazur@sev.org)
 *
 *  This program is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the Free
 *  Software Foundation; either version 2 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *  or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 *  for more details.
 */
/*
 * Created on Oct 20, 2004
 *
 */
package megamek.common.weapons.battlearmor;

import megamek.common.TechConstants;
import megamek.common.TechProgression;
import megamek.common.WeaponType;

/**
 * @author Sebastian Brocks
 */
public class CLBALightMG extends BAMGWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 1810341654439496432L;

    /**
     *
     */
    public CLBALightMG() {
        super();
        name = "Machine Gun (Light)";
        setInternalName("CLBALightMG");
        addLookupName("Clan BA Light Machine Gun");
        heat = 0;
        damage = 1;
        infDamageClass = WeaponType.WEAPON_BURST_HALFD6;
        rackSize = 1;
        shortRange = 2;
        mediumRange = 4;
        longRange = 6;
        extremeRange = 8;
        tonnage = 0.075f;
        criticals = 1;
        bv = 5;
        cost = 5000;
        introDate = 3050;
        techLevel.put(3050, TechConstants.T_CLAN_EXPERIMENTAL);
        techLevel.put(3060, TechConstants.T_CLAN_ADVANCED);
        techLevel.put(3068, TechConstants.T_CLAN_TW);
        availRating = new int[] { RATING_X ,RATING_X ,RATING_C ,RATING_B};
        techRating = RATING_C;
        rulesRefs = "258, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_CLAN);
        techProgression.setClanProgression(3050, 3060, 3068);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_C, RATING_B });
    }

}
