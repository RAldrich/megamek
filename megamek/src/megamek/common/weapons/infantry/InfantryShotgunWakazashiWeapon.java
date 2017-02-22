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
public class InfantryShotgunWakazashiWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantryShotgunWakazashiWeapon() {
        super();
        techLevel.put(3071,TechConstants.T_ALLOWED_ALL);
        name = "Shotgun (Wakazashi O-12)";
        setInternalName(name);
        addLookupName("WakazashiO12");
        ammoType = AmmoType.T_NA;
        cost = 180;
        bv = 0.35;
        flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_BALLISTIC);
        infantryDamage = 0.23;
        infantryRange = 0;
        introDate = 2100;
        techLevel.put(2100,TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[]{RATING_C,RATING_C,RATING_C,RATING_C};
        techRating = RATING_D;
        rulesRefs =" 273, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_ALL);
        techProgression.setProgression(DATE_NONE, DATE_NONE, 2100);
        techProgression.setTechRating(RATING_D);
        techProgression.setAvailability( new int[] { RATING_C, RATING_C, RATING_C, RATING_C });
    }
}
