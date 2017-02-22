/**
 * MegaMek - Copyright (C) 2004,2005 Ben Mazur (bmazur@sev.org)
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
/*
 * Created on Sep 25, 2004
 */
package megamek.common.weapons;

import megamek.common.EquipmentType;
import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author BATTLEMASTER IIC
 */
public class ISAC15 extends ACWeapon {
    /**
     * 
     */
    private static final long serialVersionUID = 814114264108820161L;

    /**
     * 
     */
    public ISAC15() {
        super();
        techLevel.put(3071, TechConstants.T_IS_UNOFFICIAL);
        name = "AC/15";
        setInternalName("Autocannon/15");
        addLookupName("IS Auto Cannon/15");
        addLookupName("Auto Cannon/15");
        addLookupName("AutoCannon/15");
        addLookupName("AC/15");
        addLookupName("ISAC15");
        addLookupName("IS Autocannon/15");
        heat = 5;
        damage = 15;
        rackSize = 15;
        shortRange = 4;
        mediumRange = 8;
        longRange = 12;
        extremeRange = 16;
        tonnage = 13.0f;
        criticals = 8;
        bv = 178;
        cost = 250000;
        shortAV = 15;
        medAV = 15;
        maxRange = RANGE_MED;
        explosionDamage = damage;
        //This being an official Weapon I'm using the AC20 information
        availRating = new int[] { EquipmentType.RATING_D,
                EquipmentType.RATING_E, EquipmentType.RATING_D };
        introDate = 2500;
        techLevel.put(2500, techLevel.get(3071));
        techRating = RATING_C;
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(DATE_NONE, DATE_NONE, 2500);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_D, RATING_E, RATING_D, RATING_X });
    }
}
