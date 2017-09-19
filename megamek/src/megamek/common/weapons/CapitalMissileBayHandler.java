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
package megamek.common.weapons;

import java.util.ArrayList;
import java.util.Vector;

import megamek.common.AmmoType;
import megamek.common.Compute;
import megamek.common.Coords;
import megamek.common.Entity;
import megamek.common.IGame;
import megamek.common.Mounted;
import megamek.common.Report;
import megamek.common.Targetable;
import megamek.common.ToHitData;
import megamek.common.WeaponType;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.options.OptionsConstants;
import megamek.server.Server;

/**
 * @author Jay Lawson
 */
public class CapitalMissileBayHandler extends AmmoBayWeaponHandler {

    /**
     * 
     */

    private static final long serialVersionUID = -1618484541772117621L;
    boolean advancedPD = false;

    /**
     * @param t
     * @param w
     * @param g
     * @param s
     */
    public CapitalMissileBayHandler(ToHitData t, WeaponAttackAction w, IGame g,
            Server s) {
        super(t, w, g, s);
        advancedPD = g.getOptions().booleanOption(OptionsConstants.ADVAERORULES_STRATOPS_ADV_POINTDEF);
    }
    
    @Override
    protected boolean specialResolution(Vector<Report> vPhaseReport,
            Entity entityTarget) {
        int counterAV = calcCounterAV();
        int CapMissileArmor = calcAttackValue();
        CapMissileAMSMod = calcCapMissileAMSMod();
        if (amsBayEngaged) {            
            if (counterAV >= CapMissileArmor) {
                Report r = new Report(3256);
                r.indent();
                r.subject = subjectId;
                vPhaseReport.addElement(r);
            } else if (counterAV > 0) {   
                Report r = new Report(3258);
                r.indent();
                r.add(CapMissileAMSMod);
                r.subject = subjectId;
                vPhaseReport.addElement(r);               
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected int calcCapMissileAMSMod() {
        CapMissileAMSMod = (int) Math.floor(CounterAV / 10);
        return CapMissileAMSMod;
    }
    
    @Override
    protected int getCapMissileAMSMod() {
        return CapMissileAMSMod;
    }

    @Override
    protected int getCapMisMod() {
        int mod = 0;
        for (int wId : weapon.getBayWeapons()) {
            int curr_mod = 0;
            Mounted bayW = ae.getEquipment(wId);
            // check the currently loaded ammo
            Mounted bayWAmmo = bayW.getLinked();
            AmmoType atype = (AmmoType) bayWAmmo.getType();
            curr_mod = getCritMod(atype);
            if (curr_mod > mod) {
                mod = curr_mod;
            }
        }
        return mod;
    }

    /*
     * get the cap mis mod given a single ammo type
     */
    protected int getCritMod(AmmoType atype) {
        if (atype == null || atype.getAmmoType() == AmmoType.T_PIRANHA)
            return 0;
        if (atype.getAmmoType() == AmmoType.T_WHITE_SHARK
                || atype.hasFlag(AmmoType.F_AR10_WHITE_SHARK)) {
            return 9;
        } else if (atype.getAmmoType() == AmmoType.T_KILLER_WHALE
                || atype.hasFlag(AmmoType.F_AR10_KILLER_WHALE)
                || atype.getAmmoType() == AmmoType.T_MANTA_RAY) {
            return 10;
        } else if (atype.getAmmoType() == AmmoType.T_KRAKEN_T
                || atype.getAmmoType() == AmmoType.T_KRAKENM) {
            return 8;
        } else if (atype.getAmmoType() == AmmoType.T_STINGRAY) {
            return 12;
        } else {
            return 11;
        }
    }
    
    @Override
    protected double updateAVforAmmo(double current_av, AmmoType atype,
            WeaponType bayWType, int range, int wId) {

    	if (atype.getAmmoType() == AmmoType.T_AR10) {
            if (atype.hasFlag(AmmoType.F_AR10_KILLER_WHALE)) {
                current_av = 4;
            } else if (atype.hasFlag(AmmoType.F_AR10_WHITE_SHARK)) {
                current_av = 3;
            } else {
                current_av = 2;
            }
        }
        return current_av;
    } 
    /**
     * Insert any additional attacks that should occur before this attack
     */
    @Override
    protected void insertAttacks(IGame.Phase phase, Vector<Report> vPhaseReport) {
        // If there are no other missiles in the bay that aren't inserted
        // attacks, there will be a spurious "no damage" report
        if (attackValue < 1) {
            vPhaseReport.clear();
        }

        for (int wId : insertedAttacks) {
            Mounted bayW = ae.getEquipment(wId);
            WeaponAttackAction newWaa = new WeaponAttackAction(ae.getId(),
                    waa.getTargetId(), wId);
            Weapon w = (Weapon) bayW.getType();
            // increase ammo by one, we'll use one that we shouldn't use
            // in the next line
            Vector<Report> newReports = new Vector<>();
            bayW.getLinked().setShotsLeft(
                    bayW.getLinked().getBaseShotsLeft() + 1);
            (w.fire(newWaa, game, server)).handle(phase, newReports);
            for (Report r : newReports) {
                r.indent();
            }
            vPhaseReport.addAll(newReports);
        }
    }
    
    // check for AMS and Point Defense Bay fire
    @Override
    protected int calcCounterAV () {
        if ((target == null)
                || (target.getTargetType() != Targetable.TYPE_ENTITY)
                || !advancedPD) {
            return 0;
        }
        int counterAV = 0;
        int amsAV = 0;
        int pdAV = 0;
        Entity entityTarget = (Entity) target;
        // any AMS bay attacks by the target?
        ArrayList<Mounted> lCounters = waa.getCounterEquipment();
        if (null != lCounters) {
            for (Mounted counter : lCounters) {               
                boolean isAMSBay = counter.getType().hasFlag(WeaponType.F_AMSBAY);
                boolean isPDBay = counter.getType().hasFlag(WeaponType.F_PDBAY);
                Entity pdEnt = counter.getEntity();
                boolean isInArc;
                // If the defending unit is the target, use attacker for arc
                if (entityTarget.equals(pdEnt)) {
                    isInArc = Compute.isInArc(game, pdEnt.getId(),
                            pdEnt.getEquipmentNum(counter),
                            ae);
                } else { // Otherwise, the attack must pass through an escort unit's hex
                	// TODO: We'll get here, eventually
                    isInArc = Compute.isInArc(game, pdEnt.getId(),
                            pdEnt.getEquipmentNum(counter),
                            entityTarget);
                }
                if (isAMSBay) {
                	amsAV = 0;
                    // Point defenses can't fire if they're not ready for any reason
		            if (!(counter.getType() instanceof WeaponType)
	                         || !counter.isReady() || counter.isMissing()
	                            // shutdown means no Point defenses
	                            || pdEnt.isShutDown()
	                            // Point defenses only fire vs attacks in arc covered by ams
	                            || !isInArc) {
	                        continue;
	                }
		            // Now for heat, damage and ammo we need the individual weapons in the bay
                    for (int wId : counter.getBayWeapons()) {
                        Mounted bayW = pdEnt.getEquipment(wId);
                        Mounted bayWAmmo = bayW.getLinked();
                        WeaponType bayWType = ((WeaponType) bayW.getType());
                        
                        // build up some heat (assume target is ams owner)		            
                        if (counter.getType().hasFlag(WeaponType.F_HEATASDICE)) {
		            		entityTarget.heatBuildup += Compute.d6(bayW
		            				.getCurrentHeat());	                    
		            	} else {
	                        entityTarget.heatBuildup += bayW.getCurrentHeat();
	                    }
                        
                        //Bays use lots of ammo. Check to make sure we haven't run out
                        if (bayWAmmo != null) {
                            if (bayWAmmo.getBaseShotsLeft() < counter.getBayWeapons().size()) {
                                continue;
                            }
                            // decrement the ammo
                        	bayWAmmo.setShotsLeft(Math.max(0,
                        		bayWAmmo.getBaseShotsLeft() - 1));
                        }
                        
                        // get the attack value
                        amsAV += bayWType.getShortAV();                                      
            		}
                    
                    // set the ams as having fired, if it did
                    if (amsAV > 0) {
                        amsBayEngaged = true;
                    }
                                        
                } else if (isPDBay && !pdBayEngaged) {
                    pdAV = 0;
                    // Point defenses can't fire if they're not ready for any reason
		            if (!(counter.getType() instanceof WeaponType)
	                         || !counter.isReady() || counter.isMissing()
	                            // shutdown means no Point defenses
	                            || pdEnt.isShutDown()
	                            // Point defenses only fire vs attacks in arc covered by ams
	                            || !isInArc) {
	                        continue;
	                }
		            // Now for heat, damage and ammo we need the individual weapons in the bay
                    for (int wId : counter.getBayWeapons()) {
                        Mounted bayW = pdEnt.getEquipment(wId);
                        Mounted bayWAmmo = bayW.getLinked();
                        WeaponType bayWType = ((WeaponType) bayW.getType());
                        
                        // build up some heat (assume target is ams owner)		            
                        if (counter.getType().hasFlag(WeaponType.F_HEATASDICE)) {
		            		entityTarget.heatBuildup += Compute.d6(bayW
		            				.getCurrentHeat());	                    
		            	} else {
	                        entityTarget.heatBuildup += bayW.getCurrentHeat();
	                    }
                        
                        //Bays use lots of ammo. Check to make sure we haven't run out
                        if (bayWAmmo != null) {
                            if (bayWAmmo.getBaseShotsLeft() < counter.getBayWeapons().size()) {
                                continue;
                            }
                            // decrement the ammo
                            bayWAmmo.setShotsLeft(Math.max(0,
                                bayWAmmo.getBaseShotsLeft() - 1));
                        }
                        
                        // get the attack value
                        pdAV += bayWType.getShortAV();                    
            		}
                    
                    // set the pdbay as having fired, if it was able to
                    if (pdAV > 0 ) {
                        counter.setUsedThisRound(true); 
                        pdBayEngaged = true;
                    }
                                 
                } //end PDBay fire 
                
                // non-AMS only add half their damage, rounded up
                counterAV += (int) Math.ceil(pdAV / 2); 
                // AMS add their full damage
                counterAV += amsAV;
            } //end "for Mounted counter"
        } // end check for counterfire
        CounterAV = (int) counterAV;
        return counterAV;
    } // end getAMSAV
    
    @Override
    protected int getCounterAV() {
    	return CounterAV;
    }
}
