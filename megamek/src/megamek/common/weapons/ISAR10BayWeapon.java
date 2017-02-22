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

import megamek.common.IGame;
import megamek.common.TechConstants;
import megamek.common.TechProgression;
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.server.Server;

/**
 * @author Jay Lawson
 */
public class ISAR10BayWeapon extends AmmoBayWeapon {
    /**
     * 
     */
    private static final long serialVersionUID = 8756042527483383101L;

    /**
     * 
     */
    public ISAR10BayWeapon() {
        super();
        // tech levels are a little tricky
        this.techLevel.put(3071, TechConstants.T_ALL);
        this.name = "AR10 Bay";
        this.setInternalName(this.name);
        addLookupName("ISAR10Bay");
        this.heat = 0;
        this.damage = DAMAGE_VARIABLE;
        this.shortRange = 12;
        this.mediumRange = 24;
        this.longRange = 40;
        this.extremeRange = 50;
        this.tonnage = 0.0f;
        this.bv = 0;
        this.cost = 0;
        this.maxRange = RANGE_SHORT;
        this.atClass = CLASS_AR10;
        this.capital = true;
        introDate = 2550;
        techLevel.put(2550, techLevel.get(3071));
        extinctDate = 2850;
        reintroDate = 3051;
        availRating = new int[] { RATING_E, RATING_F, RATING_E };
        techProgression.setTechBase(TechProgression.TECH_BASE_ALL);
        techProgression.setProgression(DATE_NONE, DATE_NONE, 2550, 2850, 3051);
        techProgression.setTechRating(RATING_C);
        techProgression.setAvailability( new int[] { RATING_E, RATING_F, RATING_E, RATING_X });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * megamek.common.weapons.Weapon#getCorrectHandler(megamek.common.ToHitData,
     * megamek.common.actions.WeaponAttackAction, megamek.common.IGame)
     */
    @Override
    protected AttackHandler getCorrectHandler(ToHitData toHit,
            WeaponAttackAction waa, IGame game, Server server) {
        return new CapitalMissileBayHandler(toHit, waa, game, server);
    }
    
    @Override
    public int getBattleForceClass() {
        return BFCLASS_CAPITAL_MISSILE;
    }
}
