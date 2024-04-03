package com.tigerbrokers.stock.openapi.client.util;

import com.tigerbrokers.stock.openapi.client.config.ClientConfig;
import com.tigerbrokers.stock.openapi.client.struct.OptionSymbol;
import com.tigerbrokers.stock.openapi.client.struct.enums.Right;
import com.tigerbrokers.stock.openapi.client.struct.enums.TimeZoneId;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * author：ltc
 * date：2019/09/04
 */
public class SymbolUtil {

  private static Pattern CHAR_SYMBOL_PATTERN = Pattern.compile("[A-Z]+(.[A-Z0-9]+)?");
  private static Pattern FUTURE_SYMBOL_PATTERN = Pattern.compile("^[0-9A-Z]+([0-9]{4}|main){1}$");

  public static OptionSymbol convertToOptionSymbolObject(String identifier) {
    if (identifier == null || identifier.length() != 21) {
      throw new RuntimeException("option identifier format error");
    }

    String[] symbolKeys = identifier.split(" +");
    if (symbolKeys != null && symbolKeys.length != 1 && symbolKeys.length != 2) {
      throw new RuntimeException("option identifier format error");
    }

    String expiryRightStrike = identifier.substring(6);

    OptionSymbol optionSymbol = new OptionSymbol();
    optionSymbol.setSymbol(identifier.substring(0, 6).trim());
    optionSymbol.setExpiry("20" + expiryRightStrike.substring(0, 2) + "-"
        + expiryRightStrike.substring(2, 4) + "-"
        + expiryRightStrike.substring(4, 6));
    optionSymbol.setRight(expiryRightStrike.charAt(6) == 'C' ? "CALL" : "PUT");
    optionSymbol.setStrike(
        Integer.parseInt(expiryRightStrike.substring(7, 12)) + "." + expiryRightStrike.charAt(12));

    return optionSymbol;
  }

  // identifier格式参考：
  // https://quant.itigerup.com/openapi/zh/python/operation/trade/getContract.html#%E5%90%88%E7%BA%A6%E4%BB%8B%E7%BB%8D
  public static String convertToIdentifier(OptionSymbol optionSymbol) {
    //6
    // 在%后加上 - 表示左对齐，然后指定宽度为N
    String symbol = String.format("%-6s", optionSymbol.getSymbol());

    //6
    String expiry = optionSymbol.getExpiry();
    expiry = expiry.replaceAll("-", "");
    if (expiry.length() > 6) {
      expiry = expiry.substring(expiry.length() - 6);
    }
    //1
    String right = Right.PUT.name().equalsIgnoreCase(optionSymbol.getRight()) ? "P" :"C";
    //8
    BigDecimal strike = new BigDecimal(optionSymbol.getStrike());
    strike = strike.multiply(new BigDecimal(1_000));
    String strikeStr = String.format("%08d", strike.longValue());

    String identifier = symbol + expiry + right + strikeStr;
    if (identifier.length() != 21) {
      throw new RuntimeException(TextUtils.format("invalid identifier, symbol={}, expiry={}, right={}, strikeStr={}",
              symbol, expiry, right, strikeStr));
    }
    return identifier;
  }

  public static void main(String[] args) {
    System.out.println("^"+ String.format("%08d", 1) + "$");
    System.out.println("^"+ String.format("%08d", 12) +"$");
    System.out.println("^"+ String.format("%08d", 123) +"$");
  }

  public static boolean isUsStockSymbol(String symbol) {
    if (symbol == null || symbol.isEmpty()) {
      return false;
    }
    if (CHAR_SYMBOL_PATTERN.matcher(symbol).matches()) {
      return true;
    }
    return false;
  }

  public static TimeZoneId getZoneIdBySymbol(String symbol) {
    if (StringUtils.isEmpty(symbol)) {
      return ClientConfig.DEFAULT_CONFIG.getDefaultTimeZone();
    }
    return SymbolUtil.isUsStockSymbol(symbol) ? TimeZoneId.NewYork : TimeZoneId.Shanghai;
  }

  public static boolean isFutureSymbol(String symbol) {
    if (symbol == null || symbol.isEmpty()
        || symbol.length() <= 4 || symbol.length() >= 12
        || symbol.startsWith("BK") || StringUtils.isNumeric(symbol)) {
      return false;
    }
    return FUTURE_SYMBOL_PATTERN.matcher(symbol).matches();
  }
}
