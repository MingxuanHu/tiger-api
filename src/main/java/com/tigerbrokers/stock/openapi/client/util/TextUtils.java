package com.tigerbrokers.stock.openapi.client.util;

import org.slf4j.helpers.MessageFormatter;

public abstract class TextUtils {
    public static String format(String msg, Object... args) {
        return MessageFormatter.arrayFormat(msg, args).getMessage();
    }
}
