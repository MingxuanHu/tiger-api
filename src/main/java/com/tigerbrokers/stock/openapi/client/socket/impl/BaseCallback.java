package com.tigerbrokers.stock.openapi.client.socket.impl;

import com.tigerbrokers.stock.openapi.client.socket.ApiComposeCallback;
import com.tigerbrokers.stock.openapi.client.socket.data.TradeTick;
import com.tigerbrokers.stock.openapi.client.socket.data.pb.*;
import com.tigerbrokers.stock.openapi.client.struct.SubscribedSymbol;

/**
 * a callback does nothing
 */
public class BaseCallback implements ApiComposeCallback {

    @Override
    public void error(String errorMsg) {

    }

    @Override
    public void error(int id, int errorCode, String errorMsg) {

    }

    @Override
    public void connectionClosed() {

    }

    @Override
    public void connectionKickout(int errorCode, String errorMsg) {

    }

    @Override
    public void connectionAck() {

    }

    @Override
    public void connectionAck(int serverSendInterval, int serverReceiveInterval) {

    }

    @Override
    public void hearBeat(String heartBeatContent) {

    }

    @Override
    public void serverHeartBeatTimeOut(String channelId) {

    }

    @Override
    public void orderStatusChange(OrderStatusData data) {

    }

    @Override
    public void orderTransactionChange(OrderTransactionData data) {

    }

    @Override
    public void positionChange(PositionData data) {

    }

    @Override
    public void assetChange(AssetData data) {

    }

    @Override
    public void tradeTickChange(TradeTick data) {

    }

    @Override
    public void quoteChange(QuoteBasicData data) {

    }

    @Override
    public void quoteAskBidChange(QuoteBBOData data) {

    }

    @Override
    public void optionChange(QuoteBasicData data) {

    }

    @Override
    public void optionAskBidChange(QuoteBBOData data) {

    }

    @Override
    public void futureChange(QuoteBasicData data) {

    }

    @Override
    public void futureAskBidChange(QuoteBBOData data) {

    }

    @Override
    public void depthQuoteChange(QuoteDepthData data) {

    }

    @Override
    public void stockTopPush(StockTopData data) {

    }

    @Override
    public void optionTopPush(OptionTopData data) {

    }

    @Override
    public void subscribeEnd(int id, String subject, String result) {

    }

    @Override
    public void cancelSubscribeEnd(int id, String subject, String result) {

    }

    @Override
    public void getSubscribedSymbolEnd(SubscribedSymbol subscribedSymbol) {

    }
}
