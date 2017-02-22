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
 * Created on Oct 15, 2004
 *
 */
package megamek.common.weapons;

import megamek.common.AmmoType;
import megamek.common.TechConstants;
import megamek.common.TechProgression;

/**
 * @author Andrew Hunter
 */
public class ISTHBLB20XAC extends LBXACWeapon {
    /**
     *
     */
    private static final long serialVersionUID = 1568107024307749233L;

    /**
     *
     */
    public ISTHBLB20XAC() {
        super();
        techLevel.put(3071, TechConstants.T_IS_UNOFFICIAL);
        name = "LB 20-X AC (THB)";
        setInternalName("ISTHBLBXAC20");
        addLookupName("IS LB 20-X AC (THB)");
        heat = 6;
        damage = 20;
        rackSize = 20;
        ammoType = AmmoType.T_AC_LBX_THB;
        shortRange = 4;
        mediumRange = 7;
        longRange = 12;
        extremeRange = 14;
        tonnage = 14.0f;
        criticals = 10;
        bv = 204;
        cost = 700000;
        //Since this are the Tactical Handbook Weapons I'm using the TM Stats.
        introDate = 3058;
        techLevel.put(3058, techLevel.get(3071));
        availRating = new int[] { RATING_X, RATING_X, RATING_E };
        techRating = RATING_E;
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(DATE_NONE, DATE_NONE, 3058);
        techProgression.setTechRating(RATING_E);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_E, RATING_X });
    }
}
