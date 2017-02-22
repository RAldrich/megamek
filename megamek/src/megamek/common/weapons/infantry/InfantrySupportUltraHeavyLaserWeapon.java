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
public class InfantrySupportUltraHeavyLaserWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantrySupportUltraHeavyLaserWeapon() {
        super();

        name = "Support Laser (Ultra-Heavy)";
        setInternalName(name);
        addLookupName("InfantryUltraHeavyLaser");
        addLookupName("InfantryHeavyMediumLaser");
        addLookupName("Infantry Ultra-Heavy Support Laser");
        ammoType = AmmoType.T_NA;
        cost = 100000;
        bv = 20.31;
        flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_ENERGY).or(F_LASER).or(F_INF_SUPPORT);
        infantryDamage = 1.72;
        infantryRange = 5;
        crew = 4;
        introDate = 3050;
        techLevel.put(3050, TechConstants.T_CLAN_EXPERIMENTAL);
        techLevel.put(3062, TechConstants.T_CLAN_ADVANCED);
        availRating = new int[] { RATING_X,RATING_X ,RATING_D ,RATING_D};
        techRating = RATING_F;
        rulesRefs = "273, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_CLAN);
        techProgression.setClanProgression(3050, 3062, DATE_NONE);
        techProgression.setTechRating(RATING_F);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_D, RATING_D });
    }
}
