package com.tigerbrokers.stock.openapi.client.util;

import com.tigerbrokers.stock.openapi.client.config.ClientConfig;
import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.domain.trade.item.PositionDetail;
import com.tigerbrokers.stock.openapi.client.https.domain.trade.item.PositionsItem;
import com.tigerbrokers.stock.openapi.client.https.request.trade.PositionsRequest;
import com.tigerbrokers.stock.openapi.client.https.response.trade.PositionsResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.Right;
import com.tigerbrokers.stock.openapi.client.struct.enums.SecType;
import com.tigerbrokers.stock.openapi.client.util.builder.AccountParamBuilder;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PositionUtils {

    @NonNull
    public static List<PositionDetail> getPositionDetails(TigerHttpClient client, String symbol) {
        String bizContent = AccountParamBuilder.instance()
                .account(ClientConfig.DEFAULT_CONFIG.defaultAccount)
                .symbol(symbol)
                .buildJson();
        PositionsRequest request = new PositionsRequest();
        request.setBizContent(bizContent);

        PositionsResponse response = client.executeSuccess(request);

        return Optional.ofNullable(response)
                .map(PositionsResponse::getItem)
                .map(PositionsItem::getPositions)
                .orElse(Collections.emptyList());
    }

    public static boolean isStk(@NonNull PositionDetail position) {
        return SecType.STK.name().equalsIgnoreCase(position.getSecType());
    }

    public static boolean isPut(@NonNull PositionDetail position) {
        return SecType.OPT.name().equalsIgnoreCase(position.getSecType()) &&
                Right.PUT.name().equalsIgnoreCase(position.getRight());
    }

    public static boolean isCall(@NonNull PositionDetail position) {
        return SecType.OPT.name().equalsIgnoreCase(position.getSecType()) &&
                Right.CALL.name().equalsIgnoreCase(position.getRight());
    }

    public static boolean isLong(@NonNull PositionDetail position) {
        return position.getPosition() > 0;
    }

    public static boolean isShort(@NonNull PositionDetail position) {
        return position.getPosition() < 0;
    }
}
