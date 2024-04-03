package com.tigerbrokers.stock.openapi.client.struct.enums;

public enum MarketStatus {
    // 未开盘
    NOT_YET_OPEN,
    // 盘前交易
    PRE_HOUR_TRADING,
    // 交易中
    TRADING,
    // 午间休市
    MIDDLE_CLOSE,
    // 盘后交易
    POST_HOUR_TRADING,
    // 已收盘
    CLOSING,
    // 提前休市
    EARLY_CLOSED,
    // 休市
    MARKET_CLOSED
}
