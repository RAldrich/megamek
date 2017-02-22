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

import megamek.common.AmmoType;
import megamek.common.IGame;
import megamek.common.TechConstants;
import megamek.common.TechProgression;
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.server.Server;

/**
 * @author Deric "Netzilla" Page (deric dot page at usa dot net)
 */
public class ISLRM10Primitive extends LRMWeapon {
    /**
     *
     */
    private static final long serialVersionUID = 6236976752458107991L;

    public ISLRM10Primitive() {
        super();
  
        name = "Primitive Prototype LRM 10";
        setInternalName(name);
        addLookupName("IS LRM-10 Primitive");
        addLookupName("ISLRM10p");
        addLookupName("IS LRM 10 Primitive");
        heat = 4;
        rackSize = 10;
        minimumRange = 6;
        tonnage = 5.0f;
        criticals = 2;
        bv = 90;
        cost = 100000;
        shortAV = 6;
        medAV = 6;
        longAV = 6;
        maxRange = RANGE_LONG;
        ammoType = AmmoType.T_LRM_PRIMITIVE;
        //IO Doesn't strictly define when these weapons stop production so assigning a value of ten years.
        introDate = 2295;
        extinctDate = 2320;
        techLevel.put(2295, TechConstants.T_IS_EXPERIMENTAL);   ///EXP
        availRating = new int[] { RATING_F, RATING_X, RATING_X, RATING_X };
        techRating = RATING_C;
        rulesRefs = "217, IO";
        techProgression.setTechBase(TechProgression.TECH_BASE_IS);
        techProgression.setISProgression(2295, DATE_NONE, DATE_NONE, 2320);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_F, RATING_X, RATING_X, RATING_X });
    }

    @Override
    protected AttackHandler getCorrectHandler(ToHitData toHit,
                                              WeaponAttackAction waa, IGame game, Server server) {
        return new LRMHandler(toHit, waa, game, server, -2);
    }
}
