/**
 * MegaMek - Copyright (C) 2005 Ben Mazur (bmazur@sev.org)
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package megamek.common.weapons;

import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author Sebastian Brocks
 */
public class ISMRM30IOS extends MRMWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 7118245780649534184L;

    /**
     *
     */
    public ISMRM30IOS() {
        super();

        name = "MRM 30 (I-OS)";
        setInternalName(name);
        addLookupName("IOS MRM-30");
        addLookupName("ISMRM30 (IOS)");
        addLookupName("IS MRM 30 (IOS)");
        heat = 10;
        rackSize = 30;
        shortRange = 3;
        mediumRange = 8;
        longRange = 15;
        extremeRange = 16;
        tonnage = 9.5f;
        criticals = 5;
        bv = 34;
        flags = flags.or(F_ONESHOT);
        cost = 180000;
        shortAV = 18;
        medAV = 18;
        maxRange = RANGE_MED;
        introDate = 3056;
        techLevel.put(3056, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(3076, TechConstants.T_IS_ADVANCED);
        techLevel.put(3085, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_X ,RATING_X ,RATING_E ,RATING_D};
        techRating = RATING_C;
        rulesRefs = "327, TO";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(3056, 3076, 3085);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_E, RATING_D });
    }
}
