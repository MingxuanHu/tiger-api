package com.tigerbrokers.stock.openapi.client.https.response.trade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tigerbrokers.stock.openapi.client.https.domain.trade.item.OrderCancelItm;
import com.tigerbrokers.stock.openapi.client.https.response.TigerResponse;

public class OrderCancelResponse extends TigerResponse {

    @JSONField(name = "data")
    private OrderCancelItm item;

    public OrderCancelItm getItem() {
        return item;
    }

    public void setItem(OrderCancelItm item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "TradeOrderResponse{" +
                "item='" + JSON.toJSONString(item, SerializerFeature.WriteEnumUsingToString) + '\'' +
                '}';
    }
}
