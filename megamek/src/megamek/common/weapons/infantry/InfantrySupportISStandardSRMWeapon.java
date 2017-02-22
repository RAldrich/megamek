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
 * Created on Sep 7, 2005
 *
 */
package megamek.common.weapons.infantry;

import megamek.common.AmmoType;
import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author Ben Grills
 */
public class InfantrySupportISStandardSRMWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantrySupportISStandardSRMWeapon() {
        super();
 
        name = "SRM Launcher (Std, Two-Shot)";
        setInternalName(name);
        addLookupName("InfantryStandardSRM");
        addLookupName("Infantry2ShotSRM");
        addLookupName("Infantry Two-Shot SRM Launcher");
        ammoType = AmmoType.T_NA;
        cost = 1500;
        bv = 5.83;
        flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_MISSILE).or(F_INF_ENCUMBER).or(F_INF_SUPPORT);
        infantryDamage = 1.14;
        infantryRange = 2;
        crew = 1;
        introDate = 2360;
        techLevel.put(2360, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(2370, TechConstants.T_IS_ADVANCED);
        techLevel.put(2400, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_C,RATING_C ,RATING_D ,RATING_C};
        techRating = RATING_C;
        rulesRefs = "273, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(2360, 2370, 2400);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_C, RATING_C, RATING_D, RATING_C });
    }
}
