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
import megamek.common.weapons.SRMWeapon;


/**
 * @author Sebastian Brocks
 */
public class CLBASRM2OS extends SRMWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 3798165725512473586L;

    /**
     *
     */
    public CLBASRM2OS() {
        super();
        name = "SRM 2 (OS)";
        setInternalName("CLBASRM2 (OS)");
        addLookupName("CLBASRM2OS");
        addLookupName("Clan BA OS SRM-2");
        addLookupName("Clan BA SRM 2 (OS)");
        heat = 2;
        rackSize = 2;
        shortRange = 3;
        mediumRange = 6;
        longRange = 9;
        extremeRange = 12;
        tonnage = .04f;
        criticals = 2;
        bv = 4;
        flags = flags.or(F_NO_FIRES).or(F_BA_WEAPON).or(F_ONESHOT).andNot(F_MECH_WEAPON).andNot(F_TANK_WEAPON).andNot(F_AERO_WEAPON).andNot(F_PROTO_WEAPON);
        cost = 5000;
        shortAV = 2;
        maxRange = RANGE_SHORT;
        introDate = 2860;
		techLevel.put(2860, TechConstants.T_CLAN_EXPERIMENTAL);
		techLevel.put(2868, TechConstants.T_CLAN_ADVANCED);	
		techLevel.put(2870, TechConstants.T_CLAN_TW);	
		availRating = new int[] { RATING_X ,RATING_D ,RATING_C ,RATING_B};	
		techRating = RATING_F;
		rulesRefs = "261, TM";
        techProgression.setTechBase(TechProgression.TECH_BASE_CLAN);
        techProgression.setClanProgression(2860, 2868, 2870);
        techProgression.setTechRating(RATING_F);
        techProgression.setAvailability( new int[] { RATING_X, RATING_D, RATING_C, RATING_B });
    }
}
