package com.tigerbrokers.stock.openapi.client.struct.enums;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * Created by lijiawen on 2018/05/16.
 */
public enum OrderStatus implements CodeEnumType {
  Invalid(-2),
  Initial(-1),
  PendingCancel(3),
  Cancelled(4),
  Submitted(5),
  Filled(6),
  Inactive(7),
  PendingSubmit(8);

  private final int code;

  OrderStatus(int code) {
    this.code = code;
  }

  @Override
  public int getCode() {
    return this.code;
  }

  private static final Set<OrderStatus> ACTIVE = ImmutableSet.of(Initial, PendingSubmit, PendingCancel, Submitted);

  public static boolean isActive(OrderStatus status) {
    return ACTIVE.contains(status);
  }
}
