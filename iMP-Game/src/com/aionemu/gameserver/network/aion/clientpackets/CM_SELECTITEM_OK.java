/*
 *  This File is Part of iMPERIVM Aion <iMPERIVM.FUN>.
 *
 *  Emu Engine is based on the Aion-Lighting Source Code
 *  The ADev.Team is engaged in the processing of the emulator.
 *  ADev.Team Website: <ADevelopers.ru>
 *  Main developers of the project: MATTY, Yltramarine
 *
 *  iMPERIVM Emu Engine - Closed Development. 
 *  Publication of Files in WEB is prohibited. 
 *
 */
package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.dataholders.DataManager;
import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.templates.decomposable.SelectItem;
import com.aionemu.gameserver.model.templates.decomposable.SelectItems;
import com.aionemu.gameserver.network.PacketLoggerService;
import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.serverpackets.SM_ITEM_USAGE_ANIMATION;
import com.aionemu.gameserver.network.aion.serverpackets.SM_SELECT_ITEM_ADD;
import com.aionemu.gameserver.services.item.ItemService;


/**
 * @author Alcapwnd
 */
public class CM_SELECTITEM_OK extends AionClientPacket {

    private int uniqueItemId;
    private int index;
    @SuppressWarnings("unused")
    private int unk;

    /**
     * @param opcode
     * @param state
     * @param restStates
     */
    public CM_SELECTITEM_OK(int opcode, AionConnection.State state, AionConnection.State... restStates) {
        super(opcode, state, restStates);
    }

    @Override
    protected void readImpl() {
        PacketLoggerService.getInstance().logPacketCM(this.getPacketName());
        this.uniqueItemId = readD();
        this.unk = readD();
        this.index = readC();

    }

    @Override
    protected void runImpl() {
        Player player = ((AionConnection) getConnection()).getActivePlayer();
        Item item = player.getInventory().getItemByObjId(this.uniqueItemId);
        if (item == null) {
            return;
        }
        sendPacket(new SM_ITEM_USAGE_ANIMATION(player.getObjectId().intValue(), player.getObjectId().intValue(), this.uniqueItemId, item.getItemId(), 0, 1, 0));
        boolean delete = player.getInventory().decreaseByObjectId(this.uniqueItemId, 1L);
        if (delete) {
            SelectItems selectitem = DataManager.DECOMPOSABLE_SELECT_ITEM_DATA.getSelectItem(player.getPlayerClass(), item.getItemId());
            SelectItem st = (SelectItem) selectitem.getItems().get(this.index);
            ItemService.addItem(player, st.getSelectItemId(), st.getCount());
            sendPacket(new SM_SELECT_ITEM_ADD(this.uniqueItemId,0));
        }

    }


}
