/* MegaMek - Copyright (C) 2004,2005 Ben Mazur (bmazur@sev.org)
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
 * Created on Sep 25, 2004
 *
 */
package megamek.common.weapons;

import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author Jay Lawson
 */
public class ISNL35Weapon extends NavalLaserWeapon {
    /**
     * 
     */
    private static final long serialVersionUID = 8756042527483383101L;

    /**
     * 
     */
    public ISNL35Weapon() {
        super();
        this.techLevel.put(3071, TechConstants.T_IS_TW_NON_BOX);
        this.name = "Naval Laser 35";
        this.setInternalName(this.name);
        this.addLookupName("NL35");
        this.heat = 52;
        this.damage = 3;
        this.shortRange = 11;
        this.mediumRange = 22;
        this.longRange = 33;
        this.extremeRange = 44;
        this.tonnage = 700.0f;
        this.bv = 830;
        this.cost = 500000;
        this.shortAV = 3.5;
        this.medAV = 3.5;
        this.longAV = 3.5;
        this.maxRange = RANGE_LONG;
        introDate = 2305;
        techLevel.put(2305, techLevel.get(3071));
        availRating = new int[] { RATING_D, RATING_F, RATING_E };
        techRating = RATING_D;
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(DATE_NONE, DATE_NONE, 2305);
        techProgression.setTechRating(RATING_D);
        techProgression.setAvailability( new int[] { RATING_D, RATING_F, RATING_E, RATING_X });
    }
}
