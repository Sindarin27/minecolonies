package com.minecolonies.api.entity.citizen.citizenhandlers;

import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.colony.buildings.IBuilding;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

public interface ICitizenColonyHandler
{
    /**
     * calculate this worker building.
     *
     * @return the building or null if none present.
     */
    @Nullable
    IBuilding getWorkBuilding();

    @Nullable
    IBuilding getHomeBuilding();

    /**
     * Server-specific update for the EntityCitizen.
     *
     * @param colonyID  the colony id.
     * @param citizenID the citizen id.
     */
    void registerWithColony(final int colonyID, final int citizenID);

    /**
     * Update the client side of the citizen entity.
     */
    void updateColonyClient();

    /**
     * Get the amount the worker should decrease its saturation by each action done or x blocks traveled.
     *
     * @return the double describing it.
     */
    double getPerBuildingFoodCost();

    /**
     * Getter for the colony.
     *
     * @return the colony of the citizen or null.
     */
    @Nullable
    IColony getColony();

    /**
     * Getter for the colony id.
     *
     * @return the colony id.
     */
    int getColonyId();

    /**
     * Setter for the colony id.
     *
     * @param colonyId the new colonyId.
     */
    void setColonyId(int colonyId);

    /**
     * Actions when the entity is removed.
     */
    void onCitizenRemoved();

    /**
     * Entity data update callback
     *
     * @param dataAccessor
     */
    void onSyncDataUpdate(EntityDataAccessor<?> dataAccessor);

    boolean registered();

    /**
     * Get the citizen team.
     * @return the team.
     */
    PlayerTeam getTeam(final Level level);
}
