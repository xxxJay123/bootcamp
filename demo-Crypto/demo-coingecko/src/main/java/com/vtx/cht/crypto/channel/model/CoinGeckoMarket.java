package com.vtx.cht.crypto.channel.model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 规范实体类注解, 属性名策略说明: CamelCase策略，Java对象属性：personId，序列化后属性：persionId
 * PascalCase策略，Java对象属性：personId，序列化后属性：PersonId
 * SnakeCaseStrategy，Java对象属性：personId，序列化后属性：person_id
 * KebabCaseStrategy，Java对象属性：personId，序列化后属性：person-id
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class CoinGeckoMarket {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private BigDecimal currentPrice;
  private BigDecimal marketCap;
  private Integer marketCapRank;
  private BigDecimal fullyDilutedValuation;
  private BigDecimal totalVolume;
  @JsonProperty("high_24h")
  private BigDecimal high24h;
  @JsonProperty("low_24h")
  private BigDecimal low24h;
  @JsonProperty("price_change_24h")
  private BigDecimal priceChange24h;
  @JsonProperty("price_change_percentage_24h")
  private BigDecimal priceChangePercentage24h;
  @JsonProperty("market_cap_change_24h")
  private BigDecimal marketCapChange24h;
  @JsonProperty("market_cap_change_percentage_24h")
  private BigDecimal marketCapChangePercentage24h;
  private BigDecimal circulatingSupply;
  private BigDecimal totalSupply;
  private BigDecimal maxSupply;
  private BigDecimal ath;
  private BigDecimal athChangePercentage;
  private String athDate;
  private BigDecimal atl;
  private BigDecimal atlChangePercentage;
  private String atlDate;
  private Roi roi;
  private String lastUpdated;
  @JsonProperty("price_change_percentage_1h_in_currency")
  private BigDecimal priceChangePercentage1hInCurrency;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Roi {
    private BigDecimal times;
    private String currency;
    private BigDecimal percentage;
  }
}
