/**
 * MegaMek - Copyright (C) 2005 Ben Mazur (bmazur@sev.org)
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
package megamek.common.weapons.battlearmor;

import megamek.common.TechConstants;
import megamek.common.TechProgression;
import megamek.common.weapons.LRMWeapon;


/**
 * @author Sebastian Brocks
 */
public class ISBALRM5 extends LRMWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 1922843634155860893L;

    /**
     *
     */
    public ISBALRM5() {
        super();
        name = "LRM 5";
        setInternalName("ISBALRM5");
        addLookupName("IS BA LRM-5");
        addLookupName("IS BA LRM 5");
        heat = 2;
        rackSize = 5;
        minimumRange = 6;
        bv = 45;
        cost = 30000;
        tonnage = .300f;
        criticals = 4;
        flags = flags.or(F_NO_FIRES).or(F_BA_WEAPON).andNot(F_MECH_WEAPON).andNot(F_TANK_WEAPON).andNot(F_AERO_WEAPON).andNot(F_PROTO_WEAPON);
        introDate = 3050;
        techLevel.put(3050, TechConstants.T_IS_EXPERIMENTAL);
        techLevel.put(3057, TechConstants.T_IS_ADVANCED);
        techLevel.put(3060, TechConstants.T_IS_TW_NON_BOX);
        availRating = new int[] { RATING_X ,RATING_X ,RATING_E ,RATING_D};
        techRating = RATING_E;
        rulesRefs = "261, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(3050, 3057, 3060);
        techProgression.setTechRating(RATING_E);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_E, RATING_D });
    }
}
