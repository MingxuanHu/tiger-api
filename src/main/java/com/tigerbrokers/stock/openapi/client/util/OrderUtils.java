package com.tigerbrokers.stock.openapi.client.util;

import com.tigerbrokers.stock.openapi.client.config.ClientConfig;
import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.domain.contract.item.ContractItem;
import com.tigerbrokers.stock.openapi.client.https.domain.trade.model.TradeOrderModel;
import com.tigerbrokers.stock.openapi.client.https.request.trade.TradeOrderRequest;
import com.tigerbrokers.stock.openapi.client.https.response.trade.TradeOrderResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.ActionType;
import com.tigerbrokers.stock.openapi.client.struct.enums.OrderType;
import com.tigerbrokers.stock.openapi.client.struct.enums.SecType;

public abstract class OrderUtils {

    public static long placeLimitOrder(TigerHttpClient client,
                                       ContractItem contract,
                                       ActionType action,
                                       double limitPrice,
                                       int qty) {
        TradeOrderModel model = new TradeOrderModel();
        model.setAccount(ClientConfig.DEFAULT_CONFIG.defaultAccount);
        model.setAction(action);
        model.setOrderType(OrderType.LMT);
        model.setLimitPrice(limitPrice);
        model.setTotalQuantity(qty);
        model.setSymbol(contract.getSymbol());
        SecType secType = SecType.valueOf(contract.getSecType());
        model.setSecType(secType);
        if (secType == SecType.OPT) {
            model.setStrike(contract.getStrikeStr());
            model.setExpiry(contract.getExpiry());
            model.setRight(contract.getRight());
        }

        TradeOrderRequest orderRequest = TradeOrderRequest.newRequest(model);
        TradeOrderResponse orderResponse = client.executeSuccess(orderRequest);
        return orderResponse.getItem().getId();
    }

}
