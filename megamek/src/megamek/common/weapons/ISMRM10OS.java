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
public class ISMRM10OS extends MRMWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 1980690855716987710L;

    /**
     *
     */
    public ISMRM10OS() {
        super();

        name = "MRM 10 (OS)";
        setInternalName(name);
        addLookupName("OS MRM-10");
        addLookupName("ISMRM10 (OS)");
        addLookupName("IS MRM 10 (OS)");
        heat = 4;
        rackSize = 10;
        shortRange = 3;
        mediumRange = 8;
        longRange = 15;
        extremeRange = 16;
        tonnage = 3.5f;
        criticals = 2;
        bv = 11;
        flags = flags.or(F_ONESHOT);
        cost = 25000;
        shortAV = 6;
        medAV = 6;
        maxRange = RANGE_MED;
        introDate = 3047;
        techLevel.put(3047, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(3058, TechConstants.T_IS_ADVANCED);
        techLevel.put(3063, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_X ,RATING_X ,RATING_E ,RATING_D};
        techRating = RATING_C;
        rulesRefs = "229, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(3047, 3058, 3063);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_E, RATING_D });
    }
}
