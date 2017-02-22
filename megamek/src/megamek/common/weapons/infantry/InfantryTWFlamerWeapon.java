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

import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author Sebastian Brocks
 */
public class InfantryTWFlamerWeapon extends InfantryWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -5741978934100309295L;

    public InfantryTWFlamerWeapon() {
        super();
        //Range 1, reduced damage flamer for TW Platoon support

        name = "Total Warfare Flamer";
        setInternalName(name);
        addLookupName("InfantryTWFlamer");
        addLookupName("InfantryTWPortableFlamer");
        cost = 100;
        bv = 0.36;
        flags = flags.or(F_DIRECT_FIRE).or(F_FLAMER).or(F_ENERGY).or(F_INF_ENCUMBER).or(F_INF_SUPPORT);
        String[] modeStrings = { "Damage", "Heat" };
        setModes(modeStrings);
        infantryDamage = 0.35;
        infantryRange = 1;
        crew = 1;
        //This Weapon has been replaced by the Flamer Pistol. Moving to Unofficial.
        introDate = 2100;
        techLevel.put(2100,TechConstants.T_IS_UNOFFICIAL);
        availRating = new int[]{RATING_B,RATING_B,RATING_B,RATING_B};
        techRating = RATING_C;
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(DATE_NONE, DATE_NONE, 2100);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_B, RATING_B, RATING_B, RATING_B });
    }
}
