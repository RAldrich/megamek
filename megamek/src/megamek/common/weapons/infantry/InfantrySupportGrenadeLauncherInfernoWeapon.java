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
public class InfantrySupportGrenadeLauncherInfernoWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantrySupportGrenadeLauncherInfernoWeapon() {
        super();

        name = "Grenade Launcher - Inferno";
        setInternalName(name);
        addLookupName("InfantryGrenadeLauncherInferno");
        addLookupName("InfantryInfernoGrenadeLauncher");
        addLookupName("Infantry Inferno Grenade Launcher");
        ammoType = AmmoType.T_NA;
        cost = 465;
        bv = 1.04;
        flags = flags.or(F_INFERNO).or(F_BALLISTIC).or(F_INF_SUPPORT);
        String[] modeStrings = { "Damage", "Heat" };
        setModes(modeStrings);
        infantryDamage = 0.34;
        infantryRange = 1;
        crew = 1;
        introDate = 1950;
        techLevel.put(1950,TechConstants.T_ALLOWED_ALL);
        availRating = new int[]{RATING_A,RATING_B,RATING_B,RATING_A};
        techRating = RATING_C;
        rulesRefs =" 273, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_ALL);
        techProgression.setProgression(DATE_NONE, DATE_NONE, 1950);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_A, RATING_B, RATING_B, RATING_A });
    }
}
