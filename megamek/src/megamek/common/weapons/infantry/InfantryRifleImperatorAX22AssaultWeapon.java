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
public class InfantryRifleImperatorAX22AssaultWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantryRifleImperatorAX22AssaultWeapon() {
        super();

        name = "Rifle (Imperator AX-22 Assault)";
        setInternalName(name);
        addLookupName("InfantryImperatorAX22");
        addLookupName("Imperator AX-22 Assault Rifle");
        ammoType = AmmoType.T_NA;
        cost = 200;
        bv = 1.59;
        flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_BALLISTIC);
        infantryDamage = 0.52;
        infantryRange = 1;
        introDate = 3047;
        techLevel.put(3047, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(3060, TechConstants.T_IS_ADVANCED);
        techLevel.put(3085, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_X,RATING_X ,RATING_B ,RATING_B};
        techRating = RATING_C;
        rulesRefs = "273, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(3047, 3060, 3085);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_B, RATING_B });
    }
}
