package com.tigerbrokers.stock.openapi.client.util;

import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.domain.trade.item.BatchOrderItem;
import com.tigerbrokers.stock.openapi.client.https.domain.trade.item.TradeOrder;
import com.tigerbrokers.stock.openapi.client.https.request.trade.QueryOrderRequest;
import com.tigerbrokers.stock.openapi.client.https.response.trade.BatchOrderResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.MethodName;
import com.tigerbrokers.stock.openapi.client.util.builder.AccountParamBuilder;
import lombok.NonNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class PageQueryUtil {

    public static List<TradeOrder> queryOrder(@NonNull TigerHttpClient client,
                                              @NonNull MethodName methodName,
                                              @NonNull AccountParamBuilder paramBuilder) {
        return queryOrder(client, methodName, paramBuilder, null);
    }

    private static List<TradeOrder> queryOrder(@NonNull TigerHttpClient client,
                                               @NonNull MethodName methodName,
                                               @NonNull AccountParamBuilder paramBuilder,
                                               @Nullable String nextPageToken) {
        List<TradeOrder> result = new LinkedList<>();

        QueryOrderRequest request = new QueryOrderRequest(methodName);
        request.setBizContent(paramBuilder
                .pageToken(nextPageToken)
                .buildJson());
        BatchOrderResponse response = client.execute(request);
        if (!response.isSuccess()) {
            throw new RuntimeException(TextUtils.format("batch query failed, code={}, message={}",
                    response.getCode(), response.getMessage()));
        }
        BatchOrderItem item = response.getItem();
        if (item == null) {
            return result;
        }

        String newNextPageToken = item.getNextPageToken();
        if (StringUtils.isEqual(nextPageToken, newNextPageToken)) {
            return result;
        }

        List<TradeOrder> batchResult = item.getOrders();
        if (batchResult != null && !batchResult.isEmpty()) {
            result.addAll(batchResult);
        } else {
            return result;
        }

        if (newNextPageToken != null && !newNextPageToken.isEmpty()) {
            result.addAll(queryOrder(client, methodName, paramBuilder, newNextPageToken));
        }
        return new ArrayList<>(result);
    }
}
