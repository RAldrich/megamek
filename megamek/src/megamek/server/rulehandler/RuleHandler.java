/*
 * MegaMek -
 * Copyright (C) 2018 - The MegaMek Team
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

package megamek.server.rulehandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import megamek.common.Building;
import megamek.common.Coords;
import megamek.common.IGame;
import megamek.common.IHex;
import megamek.common.Report;
import megamek.common.net.Packet;

/**
 * Base class for a circumstance that requires resolution by applying one a rule of the game. Creating an
 * instance configures it with necessary details, then it is resolved in a separate {@link #resolve(IGame)}
 * action. The resolution may generate reports and packets.
 * 
 * @author Neancient
 *
 */
public abstract class RuleHandler {
    
    private final List<Report> reports = new ArrayList<>();
    private final List<Packet> packets = new ArrayList<>();
    
    /**
     * Adds to the list of reports generated by resolving this rule
     *  
     * @param r The report to add
     */
    protected void addReport(Report r) {
        reports.add(r);
    }
    
    /**
     * Adds to the list of reports generated by resolving this rule
     *  
     * @param r The reports to add
     */
    protected void addReport(List<Report> reports) {
        reports.addAll(reports);
    }
    
    /**
     * Increments the newline field of the last report in the list. Does nothing if there are
     * no reports.
     */
    protected void addNewLines() {
        if (reports.size() > 0) {
            reports.get(reports.size() - 1).newlines++;
        }
    }
    
    /**
     * Fetches the reports generated while resolving the rule.
     * 
     * @return An unmodifiable list of reports
     */
    public List<Report> getReports() {
        return Collections.unmodifiableList(reports);
    }
    
    /**
     * Adds a {@link Packet} that should be sent by the server when processed
     * 
     * @param packet A Packet for the server to send to connected clients
     */
    protected void addPacket(Packet packet) {
        packets.add(packet);
    }
    
    /**
     * Adds {@link Packet}s that should be sent by the server when processed
     * 
     * @param packet A {@link List} of Packets for the server to send to connected clients
     */
    protected void addPackets(List<Packet> packets) {
        packets.addAll(packets);
    }
    
    /**
     * Gets the list of packets generated by {@link #resolve(IGame)}
     * 
     * @return An unmodifiable list of packets.
     */
    public List<Packet> getPackets() {
        return Collections.unmodifiableList(packets);
    }
    
    /**
     * Applies the game rules to resolve the circumstance
     * 
     * @param game The server's {@link IGame game} instance
     */
    public abstract void resolve(IGame game);
    
    /**
     * Processes a RuleHandler that was generated in the process of resolving this one, and collects
     * all generated reports and packets.
     * 
     * @param child  A RuleHandler that is generated in the course of resolving this one.
     * @param game   The {@link Server server's} {@link IGame game} instance.
     */
    protected void process(RuleHandler child, IGame game) {
        resolve(game);
        addReport(child.getReports());
        addPackets(child.getPackets());
    }

    /**
     * Creates a packet containing the current turn vector
     *
     * @param game The server's {@link IGame game} instance
     * @return     A turn vector packet
     */
    protected Packet createTurnVectorPacket(IGame game) {
        return new Packet(Packet.COMMAND_SENDING_TURNS, game.getTurnVector());
    }
    
    /**
     * Creates a packet containing the current turn index
     * 
     * @param game     The server's {@link IGame game} instance
     * @param playerId The ID of the current player
     * @return         A turn index packet
     */
    protected Packet createTurnIndexPacket(IGame game, int playerId) {
        final Object[] data = new Object[3];
        data[0] = new Integer(game.getTurnIndex());
        data[1] = playerId;
        return new Packet(Packet.COMMAND_TURN, data);
    }

    /**
     * Creates a packet containing a hex, and the coordinates it goes at.
     */
    protected Packet createHexChangePacket(Coords coords, IHex hex) {
        final Object[] data = new Object[2];
        data[0] = coords;
        data[1] = hex;
        return new Packet(Packet.COMMAND_CHANGE_HEX, data);
    }

    /**
     * Tell the clients to update the CFs of the given buildings.
     *
     * @param buildings - a {@link Vector} of {@link Building}s that need to be updated.
     * @return a {@link Packet} for the command.
     */
    protected Packet createUpdateBuildingPacket(Vector<Building> buildings) {
        return new Packet(Packet.COMMAND_BLDG_UPDATE, buildings);
    }

}
