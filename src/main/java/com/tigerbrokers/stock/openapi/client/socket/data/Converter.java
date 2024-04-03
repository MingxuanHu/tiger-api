package com.tigerbrokers.stock.openapi.client.socket.data;

import com.tigerbrokers.stock.openapi.client.https.domain.trade.item.PositionDetail;
import com.tigerbrokers.stock.openapi.client.socket.data.pb.PositionData;

public abstract class Converter {

    public static PositionDetail convert(PositionData data) {
        PositionDetail detail = new PositionDetail();
        detail.setAccount(data.getAccount());
        detail.setSymbol(data.getSymbol());
        detail.setExpiry(data.getExpiry());
        detail.setStrike(data.getStrike());
        detail.setRight(data.getRight());
        detail.setIdentifier(data.getIdentifier());
        detail.setMultiplier((double) data.getMultiplier());
        detail.setMarket(data.getMarket());
        detail.setCurrency(data.getCurrency());
        detail.setSecType(data.getSecType());
        detail.setPosition(data.getPosition());
        detail.setPositionScale(data.getPositionScale());
        detail.setSalable((int) data.getSaleable());
        detail.setAverageCost(data.getAverageCost());
        detail.setLatestPrice(data.getLatestPrice());
        detail.setMarketValue(data.getMarketValue());
        detail.setUnrealizedPnl(data.getUnrealizedPnl());
        detail.setUpdateTimestamp(data.getTimestamp());
        return detail;
    }
}
