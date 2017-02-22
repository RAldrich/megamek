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
public class CLBALRM5 extends LRMWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -2860859814228145513L;

    /**
     *
     */
    public CLBALRM5() {
        super();
        name = "LRM 5";
        setInternalName("CLBALRM5");
        addLookupName("Clan BA LRM-5");
        addLookupName("Clan BA LRM 5");
        heat = 2;
        rackSize = 5;
        minimumRange = WEAPON_NA;
        tonnage = .175f;
        criticals = 4;
        bv = 0;
        cost = 30000;
        flags = flags.or(F_NO_FIRES).or(F_BA_WEAPON).andNot(F_MECH_WEAPON).andNot(F_TANK_WEAPON).andNot(F_AERO_WEAPON).andNot(F_PROTO_WEAPON);
        introDate = 3053;
		techLevel.put(3053, TechConstants.T_CLAN_EXPERIMENTAL);	
		techLevel.put(3060, TechConstants.T_CLAN_ADVANCED);
		techLevel.put(3062, TechConstants.T_CLAN_TW);	
		availRating = new int[] { RATING_X ,RATING_X ,RATING_F ,RATING_D};	
		techRating = RATING_F;	
		rulesRefs = "261, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_CLAN);
        techProgression.setClanProgression(3053, 3060, 3062);
        techProgression.setTechRating(RATING_F);
        techProgression.setAvailability( new int[] { RATING_X, RATING_X, RATING_F, RATING_D });
    }
}
