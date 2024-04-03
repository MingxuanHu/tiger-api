package com.tigerbrokers.stock.openapi.client.struct;

/**
 * author：ltc
 * date：2019/09/04
 */
public class OptionSymbol {

  private String symbol;
  private String expiry;
  private String strike;
  private String right;

  /**
   * @param optSymbol "AAPL 20230317 150.0 CALL"
   */
  public static OptionSymbol of(String optSymbol) {
    String[] parts = optSymbol.split("\\s+");
    OptionSymbol symbol = new OptionSymbol();
    symbol.setSymbol(parts[0]);
    symbol.setExpiry(parts[1]);
    symbol.setStrike(parts[2]);
    symbol.setRight(parts[3]);
    return symbol;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getExpiry() {
    return expiry;
  }

  public void setExpiry(String expiry) {
    this.expiry = expiry;
  }

  public String getStrike() {
    return strike;
  }

  public void setStrike(String strike) {
    this.strike = strike;
  }

  public String getRight() {
    return right;
  }

  public void setRight(String right) {
    this.right = right;
  }
}
