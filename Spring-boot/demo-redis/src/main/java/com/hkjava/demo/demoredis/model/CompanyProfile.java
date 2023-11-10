package com.hkjava.demo.demoredis.model;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class CompanyProfile implements Serializable {

  private String country;

  private String currency;

  private String estimateCurrency;

  private String exchange;

  private String finnhubIndustry;

  @JsonProperty(value = "ipo")
  private LocalDate ipoDate;

  private String logo;

  @JsonProperty(value = "marketCapitalization")
  private double marketCap;

  @JsonProperty(value = "name")
  private String companyName;

  private String phone;

  private double shareOutstanding;

  private String ticker;

  private String weburl;

  public CompanyProfile(String companyName, LocalDate ipoDate) {
    this.companyName = companyName;
    this.ipoDate = ipoDate;
  }

}
