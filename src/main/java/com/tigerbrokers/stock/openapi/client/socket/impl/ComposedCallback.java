package com.tigerbrokers.stock.openapi.client.socket.impl;

import com.tigerbrokers.stock.openapi.client.socket.ApiComposeCallback;
import com.tigerbrokers.stock.openapi.client.socket.data.TradeTick;
import com.tigerbrokers.stock.openapi.client.socket.data.pb.*;
import com.tigerbrokers.stock.openapi.client.struct.SubscribedSymbol;
import lombok.NonNull;

import java.util.List;

public class ComposedCallback implements ApiComposeCallback {

    private final List<ApiComposeCallback> callbacks;

    public ComposedCallback(@NonNull List<ApiComposeCallback> callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    public void error(String errorMsg) {
        callbacks.forEach(callback -> callback.error(errorMsg));
    }

    @Override
    public void error(int id, int errorCode, String errorMsg) {
        callbacks.forEach(callback -> callback.error(id, errorCode, errorMsg));
    }

    @Override
    public void connectionClosed() {
        callbacks.forEach(ApiComposeCallback::connectionClosed);
    }

    @Override
    public void connectionKickout(int errorCode, String errorMsg) {
        callbacks.forEach(callback -> callback.connectionKickout(errorCode, errorMsg));
    }

    @Override
    public void connectionAck() {
        callbacks.forEach(ApiComposeCallback::connectionAck);
    }

    @Override
    public void connectionAck(int serverSendInterval, int serverReceiveInterval) {
        callbacks.forEach(callback -> callback.connectionAck(serverSendInterval, serverReceiveInterval));
    }

    @Override
    public void hearBeat(String heartBeatContent) {
        callbacks.forEach(callback -> callback.hearBeat(heartBeatContent));
    }

    @Override
    public void serverHeartBeatTimeOut(String channelId) {
        callbacks.forEach(callback -> callback.serverHeartBeatTimeOut(channelId));
    }

    @Override
    public void orderStatusChange(OrderStatusData data) {
        callbacks.forEach(callback -> callback.orderStatusChange(data));
    }

    @Override
    public void orderTransactionChange(OrderTransactionData data) {
        callbacks.forEach(callback -> callback.orderTransactionChange(data));
    }

    @Override
    public void positionChange(PositionData data) {
        callbacks.forEach(callback -> callback.positionChange(data));
    }

    @Override
    public void assetChange(AssetData data) {
        callbacks.forEach(callback -> callback.assetChange(data));
    }

    @Override
    public void tradeTickChange(TradeTick data) {
        callbacks.forEach(callback -> callback.tradeTickChange(data));
    }

    @Override
    public void quoteChange(QuoteBasicData data) {
        callbacks.forEach(callback -> callback.quoteChange(data));
    }

    @Override
    public void quoteAskBidChange(QuoteBBOData data) {
        callbacks.forEach(callback -> callback.quoteAskBidChange(data));
    }

    @Override
    public void optionChange(QuoteBasicData data) {
        callbacks.forEach(callback -> callback.optionChange(data));
    }

    @Override
    public void optionAskBidChange(QuoteBBOData data) {
        callbacks.forEach(callback -> callback.optionAskBidChange(data));
    }

    @Override
    public void futureChange(QuoteBasicData data) {
        callbacks.forEach(callback -> callback.futureChange(data));
    }

    @Override
    public void futureAskBidChange(QuoteBBOData data) {
        callbacks.forEach(callback -> callback.futureAskBidChange(data));
    }

    @Override
    public void depthQuoteChange(QuoteDepthData data) {
        callbacks.forEach(callback -> callback.depthQuoteChange(data));
    }

    @Override
    public void stockTopPush(StockTopData data) {
        callbacks.forEach(callback -> callback.stockTopPush(data));
    }

    @Override
    public void optionTopPush(OptionTopData data) {
        callbacks.forEach(callback -> callback.optionTopPush(data));
    }

    @Override
    public void subscribeEnd(int id, String subject, String result) {
        callbacks.forEach(callback -> callback.subscribeEnd(id, subject, result));
    }

    @Override
    public void cancelSubscribeEnd(int id, String subject, String result) {
        callbacks.forEach(callback -> callback.cancelSubscribeEnd(id, subject, result));
    }

    @Override
    public void getSubscribedSymbolEnd(SubscribedSymbol subscribedSymbol) {
        callbacks.forEach(callback -> callback.getSubscribedSymbolEnd(subscribedSymbol));
    }
}
