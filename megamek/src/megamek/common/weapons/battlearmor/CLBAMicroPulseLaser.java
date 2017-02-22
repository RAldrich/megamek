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
 * Created on Sep 12, 2004
 *
 */
package megamek.common.weapons.battlearmor;

import megamek.common.EquipmentType;
import megamek.common.TechConstants;
import megamek.common.TechProgression;
import megamek.common.WeaponType;
import megamek.common.weapons.PulseLaserWeapon;

/**
 * @author Andrew Hunter
 */
public class CLBAMicroPulseLaser extends PulseLaserWeapon {
    /**
     *
     */
    private static final long serialVersionUID = -3335298535182304490L;

    /**
     *
     */
    public CLBAMicroPulseLaser() {
        super();
        name = "Micro Pulse Laser";
        setInternalName("CLBAMicroPulseLaser");
        addLookupName("Clan BA Micro Pulse Laser");
        heat = 1;
        damage = 3;
        infDamageClass = WeaponType.WEAPON_BURST_2D6;
        toHitModifier = -2;
        shortRange = 1;
        mediumRange = 2;
        longRange = 3;
        extremeRange = 4;
        waterShortRange = 1;
        waterMediumRange = 2;
        waterLongRange = 2;
        waterExtremeRange = 4;
        tonnage = 0.160f;
        criticals = 1;
        flags = flags.or(F_NO_FIRES).or(F_BURST_FIRE).or(F_BA_WEAPON).andNot(F_MECH_WEAPON).andNot(F_TANK_WEAPON).andNot(F_AERO_WEAPON).andNot(F_PROTO_WEAPON);
        bv = 12;
        cost = 12500;
        shortAV = 3;
        maxRange = RANGE_SHORT;
        atClass = CLASS_POINT_DEFENSE;
        introDate = 3050;
        techLevel.put(3050, TechConstants.T_CLAN_EXPERIMENTAL);
        techLevel.put(3060, TechConstants.T_CLAN_ADVANCED);
        techLevel.put(3063, TechConstants.T_CLAN_TW);
        availRating = new int[] { RATING_X ,RATING_X ,RATING_D ,RATING_C};
        techRating = RATING_F;


        techProgression.setTechBase(TechProgression.TECH_BASE_CLAN);
        techProgression.setClanProgression(3050, 3060, 3063);
        techProgression.setTechRating(RATING_F);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_D, RATING_C });
    }

}
