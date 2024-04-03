package com.tigerbrokers.stock.openapi.client.https.request.trade;

import com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants;
import com.tigerbrokers.stock.openapi.client.https.request.TigerCommonRequest;
import com.tigerbrokers.stock.openapi.client.https.request.TigerRequest;
import com.tigerbrokers.stock.openapi.client.https.response.trade.OrderCancelResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.MethodName;
import com.tigerbrokers.stock.openapi.client.util.builder.TradeParamBuilder;
import lombok.NonNull;

public class OrderCancelRequest extends TigerCommonRequest implements TigerRequest<OrderCancelResponse> {

    private final long id;
    private final String account;

    /**
     * @param id      the id of the order to be canceled
     * @param account
     */
    public OrderCancelRequest(long id, @NonNull String account) {
        setApiVersion(TigerApiConstants.DEFAULT_VERSION);
        setApiMethodName(MethodName.CANCEL_ORDER);
        this.id = id;
        this.account = account;
    }

    @Override
    public String getBizContent() {
        return TradeParamBuilder.instance()
                .account(account)
                .id(id)
                .buildJson();
    }

    @Override
    public Class<OrderCancelResponse> getResponseClass() {
        return OrderCancelResponse.class;
    }
}
