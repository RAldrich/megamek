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
public class InfantrySMGKA23SubgunWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantrySMGKA23SubgunWeapon() {
        super();

        name = "SMG (KA-23 Subgun)";
        setInternalName(name);
        addLookupName("InfantryKA23");
        addLookupName("KA-23 Subgun");
        ammoType = AmmoType.T_NA;
        cost = 350;
        bv = 0.20;
        flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_BALLISTIC);
        infantryDamage = 0.22;
        infantryRange = 0;
        introDate = 2885;
        techLevel.put(2885, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(2895, TechConstants.T_IS_ADVANCED);
        techLevel.put(2950, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_X,RATING_C ,RATING_D ,RATING_D};
        techRating = RATING_D;
        rulesRefs = "273, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(2885, 2895, 2950);
        techProgression.setTechRating(RATING_D);
        techProgression.setAvailability( new int[] { RATING_X, RATING_C, RATING_D, RATING_D });
    }
}
