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
 * @author Sebastian Brocks
 */
public class ISLRT5 extends LRTWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 8732328051646920316L;

    /**
     *
     */
    public ISLRT5() {
        super();

        name = "LRT 5";
        setInternalName(name);
        addLookupName("IS LRT-5");
        addLookupName("ISLRTorpedo5");
        addLookupName("IS LRT 5");
        addLookupName("ISLRT5");
        heat = 2;
        rackSize = 5;
        minimumRange = 6;
        waterShortRange = 7;
        waterMediumRange = 14;
        waterLongRange = 21;
        waterExtremeRange = 28;
        tonnage = 2.0f;
        criticals = 1;
        bv = 45;
        cost = 30000;
        introDate = 2370;
        techLevel.put(2370, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(2380, TechConstants.T_IS_ADVANCED);
        techLevel.put(2400, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_C ,RATING_C ,RATING_C ,RATING_C};
        techRating = RATING_C;
        rulesRefs = "229, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(2370, 2380, 2400);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_C, RATING_C, RATING_C, RATING_C });
    }
}
