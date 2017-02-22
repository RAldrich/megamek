/**
 * MegaMek -
 * Copyright (C) 2000,2001,2002,2003,2004,2005,2006,2007 Ben Mazur (bmazur@sev.org)
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
package megamek.common.weapons;

import megamek.common.EquipmentType;
import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author Deric "Netzilla" Page (deric dot page at usa dot net)
 */
public class ISMediumLaserPrimitive extends LaserWeapon {
    /**
     *
     */
    private static final long serialVersionUID = 1522567438781244152L;

    public ISMediumLaserPrimitive() {
        super();

        this.name = "Primitive Prototype Medium Laser";
        this.setInternalName(this.name);
        this.addLookupName("IS Medium Laser Prototype");
        this.addLookupName("ISMediumLaserPrototype");
        this.heat = 5;
        this.damage = 5;
        this.shortRange = 3;
        this.mediumRange = 6;
        this.longRange = 9;
        this.extremeRange = 12;
        this.waterShortRange = 2;
        this.waterMediumRange = 4;
        this.waterLongRange = 6;
        this.waterExtremeRange = 8;
        this.tonnage = 1.0f;
        this.criticals = 1;
        this.bv = 46;
        this.cost = 40000;
        this.shortAV = 5;
        this.maxRange = RANGE_SHORT;
        //IO Doesn't strictly define when these weapons stop production so assigning a value of ten years.
        introDate = 2290;
        extinctDate = 2310;
        techLevel.put(2290, TechConstants.T_IS_EXPERIMENTAL);   ///EXP
        availRating = new int[] { RATING_F, RATING_X, RATING_X, RATING_X };
        techRating = RATING_C;
        rulesRefs = "217, IO";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(2290, DATE_NONE, DATE_NONE, 2310);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_F, RATING_X, RATING_X, RATING_X });
    }
}
