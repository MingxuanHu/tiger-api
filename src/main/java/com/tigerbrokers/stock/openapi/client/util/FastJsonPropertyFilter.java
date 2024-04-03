package com.tigerbrokers.stock.openapi.client.util;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Set;

/**
 * Description:
 * Created by lijiawen on 2018/05/31.
 */
public class FastJsonPropertyFilter {

  private static final Set<String> CAN_NEGATIVE_FIELDS = ImmutableSet.of("adjust_limit", "limit_price");

  public static PropertyFilter getPropertyFilter() {
    return new PropertyFilter() {
      @Override
      public boolean apply(Object o, String key, Object value) {
        if (value == null) {
          return false;
        }
        if (value instanceof Integer) {
          if ((Integer) value <= 0) {
            return false;
          }
        } else if (value instanceof Double) {
          if ((Double) value <= 0.0D && !CAN_NEGATIVE_FIELDS.contains(key)) {
            return false;
          }
        } else if (value instanceof Float) {
          if ((Float) value <= 0.0F) {
            return false;
          }
        }
        return true;
      }
    };
  }

  public static PropertyFilter getExcludeFilter(List<String> excludeKeys) {
    return new PropertyFilter() {
      @Override
      public boolean apply(Object o, String key, Object value) {
        if (value == null) {
          return false;
        }
        if (value instanceof Integer) {
          if ((Integer) value <= 0) {
            return false;
          }
        } else if (value instanceof Double) {
          if ((Double) value <= 0.0D) {
            return false;
          }
        } else if (value instanceof Float) {
          if ((Float) value <= 0.0F) {
            return false;
          }
        }
        if (excludeKeys != null) {
          for (String excludeKey : excludeKeys) {
            if (excludeKey.equals(key)) {
              return false;
            }
          }
        }
        return true;
      }
    };
  }
}
