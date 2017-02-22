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
public class InfantrySupportHeavyAutoGrenadeLauncherWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantrySupportHeavyAutoGrenadeLauncherWeapon() {
        super();

        name = "Grenade Launcher (Heavy Auto)";
        setInternalName(name);
        addLookupName("InfantryHeavyAutoGrenadeLauncher");
        addLookupName("Infantry Heavy Auto Grenade Launcher");
        ammoType = AmmoType.T_NA;
        cost = 4500;
        bv = 5.90;
        flags = flags.or(F_NO_FIRES).or(F_BALLISTIC).or(F_INF_ENCUMBER).or(F_INF_SUPPORT);
        infantryDamage = 1.93;
        infantryRange = 1;
        crew = 1;
        introDate = 2891;
        techLevel.put(2891, TechConstants.T_CLAN_EXPERIMENTAL);
        techLevel.put(2900, TechConstants.T_CLAN_ADVANCED);
        availRating = new int[] { RATING_X,RATING_X ,RATING_D ,RATING_D};
        techRating = RATING_D;
        rulesRefs = "273, TM";

        techProgression.setTechBase(TechProgression.TECH_BASE_CLAN);
        techProgression.setClanProgression(2891, 2900, DATE_NONE);
        techProgression.setTechRating(RATING_D);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_D, RATING_D });
    }
}
