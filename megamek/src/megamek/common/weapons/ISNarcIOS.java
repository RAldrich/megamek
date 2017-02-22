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
public class ISNarcIOS extends NarcWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 8610275030183400408L;

    /**
     *
     */
    public ISNarcIOS() {
        super();

        name = "Narc (I-OS)";
        setInternalName("ISNarcBeacon (I-OS)");
        addLookupName("IS I-OS Narc Beacon");
        addLookupName("IS Narc Missile Beacon (I-OS)");
        heat = 0;
        rackSize = 1;
        shortRange = 3;
        mediumRange = 6;
        longRange = 9;
        extremeRange = 12;
        tonnage = 2.5f;
        criticals = 2;
        flags = flags.or(F_ONESHOT);
        bv = 6;
        cost = 100000;
        introDate = 3056;
        techLevel.put(3056, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(3076, TechConstants.T_IS_ADVANCED);
        techLevel.put(3085, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_E ,RATING_F ,RATING_D ,RATING_C};
        techRating = RATING_B;
        rulesRefs = "232, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(3056, 3076, 3085);
        techProgression.setTechRating(RATING_B);
        techProgression.setAvailability( new int[] { RATING_E, RATING_F, RATING_D, RATING_C });
    }
}
