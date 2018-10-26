package com.tigerbrokers.stock.openapi.client.util.builder;

import com.alibaba.fastjson.JSONObject;
import com.tigerbrokers.stock.openapi.client.struct.enums.ActionType;
import com.tigerbrokers.stock.openapi.client.struct.enums.Currency;
import com.tigerbrokers.stock.openapi.client.struct.enums.Market;
import com.tigerbrokers.stock.openapi.client.struct.enums.OrderType;
import com.tigerbrokers.stock.openapi.client.struct.enums.SecType;
import com.tigerbrokers.stock.openapi.client.struct.param.OrderParameter;
import com.tigerbrokers.stock.openapi.client.struct.TagValue;
import com.tigerbrokers.stock.openapi.client.struct.enums.TimeInForce;
import com.tigerbrokers.stock.openapi.client.util.FastJsonPropertyFilter;
import java.util.List;

/**
 * Description:
 * Created by lijiawen on 2018/05/31.
 */
public class TradeParamBuilder {

  private OrderParameter orderParameter;

  private TradeParamBuilder() {
    orderParameter = new OrderParameter();
  }

  public static TradeParamBuilder instance() {
    return new TradeParamBuilder();
  }

  public TradeParamBuilder orderId(Integer orderId) {
    if (orderId != null) {
      this.orderParameter.setOrderId(orderId);
    }
    return this;
  }

  public TradeParamBuilder symbol(String symbol) {
    if (symbol != null) {
      this.orderParameter.setSymbol(symbol);
    }
    return this;
  }

  public TradeParamBuilder orderType(OrderType orderType) {
    if (orderType != null) {
      this.orderParameter.setOrderType(orderType);
    }
    return this;
  }

  public TradeParamBuilder limitPrice(Double limitPrice) {
    if (limitPrice != null) {
      this.orderParameter.setLimitPrice(limitPrice);
    }
    return this;
  }

  public TradeParamBuilder auxPrice(Double auxPrice) {
    if (auxPrice != null) {
      this.orderParameter.setAuxPrice(auxPrice);
    }
    return this;
  }

  public TradeParamBuilder trailingPercent(Double trailingPercent) {
    if (trailingPercent != null) {
      this.orderParameter.setTrailingPercent(trailingPercent);
    }
    return this;
  }

  public TradeParamBuilder secType(SecType secType) {
    if (secType != null) {
      this.orderParameter.setSecType(secType);
    }
    return this;
  }

  public TradeParamBuilder outsideRth(Boolean outsideRth) {
    if (outsideRth != null) {
      this.orderParameter.setOutsideRth(outsideRth);
    }
    return this;
  }

  public TradeParamBuilder totalQuantity(Integer totalQuantity) {
    if (totalQuantity != null) {
      this.orderParameter.setTotalQuantity(totalQuantity);
    }
    return this;
  }

  public TradeParamBuilder action(ActionType action) {
    if (action != null) {
      this.orderParameter.setAction(action);
    }
    return this;
  }

  public TradeParamBuilder currency(Currency currency) {
    if (currency != null) {
      this.orderParameter.setCurrency(currency);
    }
    return this;
  }

  public TradeParamBuilder timeInForce(TimeInForce timeInForce) {
    if (timeInForce != null) {
      this.orderParameter.setTimeInForce(timeInForce);
    }
    return this;
  }

  public TradeParamBuilder account(String account) {
    if (account != null) {
      this.orderParameter.setAccount(account);
    }
    return this;
  }

  public TradeParamBuilder market(Market market) {
    if (market != null) {
      this.orderParameter.setMarket(market.name());
    }
    return this;
  }

  public TradeParamBuilder exchange(String exchange) {
    if (exchange != null) {
      this.orderParameter.setExchange(exchange);
    }
    return this;
  }

  public TradeParamBuilder expiry(String expiry) {
    if (expiry != null) {
      this.orderParameter.setExpiry(expiry);
    }
    return this;
  }

  public TradeParamBuilder strike(String strike) {
    if (strike != null) {
      this.orderParameter.setStrike(strike);
    }
    return this;
  }

  public TradeParamBuilder right(String right) {
    if (right != null) {
      this.orderParameter.setRight(right);
    }
    return this;
  }

  public TradeParamBuilder multiplier(Float multiplier) {
    if (multiplier != null) {
      this.orderParameter.setMultiplier(multiplier);
    }
    return this;
  }

  public TradeParamBuilder localSymbol(String localSymbol) {
    if (localSymbol != null) {
      this.orderParameter.setLocalSymbol(localSymbol);
    }
    return this;
  }

  public TradeParamBuilder allocAccounts(List<String> allocAccounts) {
    if (allocAccounts != null) {
      this.orderParameter.setAllocAccounts(allocAccounts);
    }
    return this;
  }

  public TradeParamBuilder allocShares(List<Double> allocShares) {
    if (allocShares != null) {
      this.orderParameter.setAllocShares(allocShares);
    }
    return this;
  }

  public TradeParamBuilder algoStrategy(String algoStrategy) {
    if (algoStrategy != null) {
      this.orderParameter.setAlgoStrategy(algoStrategy);
    }
    return this;
  }

  public TradeParamBuilder algoParams(List<TagValue> algoParams) {
    if (algoParams != null) {
      this.orderParameter.setAlgoParams(algoParams);
    }
    return this;
  }

  public TradeParamBuilder source(String source) {
    if (source != null) {
      this.orderParameter.setSource(source);
    }
    return this;
  }

  public OrderParameter build() {
    return this.orderParameter;
  }

  public String buildJson() {
    return JSONObject.toJSONString(orderParameter, FastJsonPropertyFilter.getPropertyFilter());
  }
}