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
public class ISStreakSRM4 extends StreakSRMWeapon {

    /**
     * 
     */
    private static final long serialVersionUID = 2884956805670848621L;

    /**
     * 
     */
    public ISStreakSRM4() {
        super();

        this.name = "Streak SRM 4";
        this.setInternalName("ISStreakSRM4");
        this.addLookupName("IS Streak SRM-4");
        this.addLookupName("IS Streak SRM 4");
        this.heat = 3;
        this.rackSize = 4;
        this.shortRange = 3;
        this.mediumRange = 6;
        this.longRange = 9;
        this.extremeRange = 12;
        this.tonnage = 3.0f;
        this.criticals = 1;
        this.bv = 59;
        this.cost = 90000;
        this.shortAV = 8;
        this.maxRange = RANGE_SHORT;
        introDate = 3055;
        techLevel.put(3055, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(3058, TechConstants.T_IS_ADVANCED);
        techLevel.put(3060, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_E ,RATING_E ,RATING_D ,RATING_D};
        techRating = RATING_E;
        rulesRefs = "230, TM";;
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(3055, 3058, 3060);
        techProgression.setTechRating(RATING_E);
        techProgression.setAvailability( new int[] { RATING_E, RATING_E, RATING_D, RATING_D });
    }
}
