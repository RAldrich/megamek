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
public class InfantrySupportVintageGatlingGunWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantrySupportVintageGatlingGunWeapon() {
        super();

        name = "Vintage Gatling Gun";
        setInternalName(name);
        addLookupName("InfantryVintageGatlingGun");
        addLookupName("Vintage Gatling Gun");
        ammoType = AmmoType.T_NA;
        cost = 450000;
        tonnage = 0.296f;
        bv = 0.0;
        flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_INF_SUPPORT).or(F_BALLISTIC);
        infantryDamage = 0.17;
        infantryRange = 2;
        crew = 4;
        introDate = 1950;
        techLevel.put(1950,TechConstants.T_ALLOWED_ALL);
        availRating = new int[]{RATING_E,RATING_E,RATING_F,RATING_F};
        techRating = RATING_B;
        rulesRefs =" 273, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_ALL);
        techProgression.setProgression(DATE_NONE, DATE_NONE, 1950);
        techProgression.setTechRating(RATING_B);
        techProgression.setAvailability( new int[] { RATING_E, RATING_E, RATING_F, RATING_F });
    }
}
