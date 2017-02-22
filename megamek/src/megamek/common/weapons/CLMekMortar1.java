/**
 * MegaMek - Copyright (C) 2005 Ben Mazur (bmazur@sev.org)
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
package megamek.common.weapons;

import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author Jason Tighe
 */
public class CLMekMortar1 extends MekMortarWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -2449264496450109574L;

    /**
     *
     */
    public CLMekMortar1() {
        super();

        name = "'Mech Mortar 1";
        setInternalName("Clan Mech Mortar-1");
        addLookupName("CLMekMortar1");
        addLookupName("Clan Mek Mortar 1");
        rackSize = 1;
        minimumRange = 6;
        shortRange = 7;
        mediumRange = 14;
        longRange = 21;
        extremeRange = 28;
        bv = 10;
        heat = 1;
        criticals = 1;
        tonnage = 1;
        cost = 7000;
        introDate = 2830;
        techLevel.put(2830, TechConstants.T_CLAN_EXPERIMENTAL);
        techLevel.put(2840, TechConstants.T_CLAN_ADVANCED);
        availRating = new int[] { RATING_X ,RATING_F ,RATING_F ,RATING_E};
        techRating = RATING_B;
        rulesRefs = "263, TM";

        techProgression.setTechBase(TechProgression.TECH_BASE_CLAN);
        techProgression.setClanProgression(2830, 2840, DATE_NONE);
        techProgression.setTechRating(RATING_B);
        techProgression.setAvailability( new int[] { RATING_X, RATING_F, RATING_F, RATING_E });
    }
}
