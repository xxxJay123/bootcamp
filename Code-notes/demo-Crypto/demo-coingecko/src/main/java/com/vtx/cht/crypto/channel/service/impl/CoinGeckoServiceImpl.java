package com.vtx.cht.crypto.channel.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtx.cht.crypto.channel.model.CoinGeckoMarket;
import com.vtx.cht.crypto.channel.service.CoinGeckoService;

@Service
public class CoinGeckoServiceImpl implements CoinGeckoService {
  // https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&price_change_percentage=1h

  @Value("${api.coingecko.coin-market.url.base}")
  String baseUrl;
  // api version
  @Value("${api.coingecko.coin-market.url.version}")
  String versionUrl;
  // coinsMarketsEndpoint
  @Value("${api.coingecko.coin-market.url.coinsMarketsEndpoint}")
  String coinsMarketsEndpointUrl;

  @Value("${api.coingecko.coin-market.param.vsCurrency}")
  String vsCurrency;

  @Value("${api.coingecko.coin-market.param.ids:NULL}")
  String ids;

  @Value("${api.coingecko.coin-market.param.order}")
  String order;

  @Value("${api.coingecko.coin-market.param.per-page}")
  String perPage;

  @Value("${api.coingecko.coin-market.param.page}")
  String page;

  @Value("${api.coingecko.coin-market.param.sparkline}")
  String sparkline;

  @Value("${api.coingecko.coin-market.param.price-change-percentage}")
  String priceChangePercentage;

  @Value("${api.coingecko.coin-market.return.no-of-items}")
  Integer noOfItems;

  @Override
  public CoinGeckoMarket[] getCoinMarket() {
    // 組裝工具
    String url = UriComponentsBuilder.fromUriString(baseUrl)
        .pathSegment(versionUrl).path(coinsMarketsEndpointUrl)
        .queryParam("vs_currency", Optional.ofNullable(vsCurrency))
        .queryParamIfPresent("ids", Optional.ofNullable(ids))
        .queryParamIfPresent("order", Optional.ofNullable(order))
        .queryParamIfPresent("per_page", Optional.ofNullable(perPage))
        .queryParamIfPresent("page", Optional.ofNullable(page))
        .queryParamIfPresent("sparkline", Optional.ofNullable(sparkline))
        .queryParamIfPresent("price_change_percentage", Optional.ofNullable(priceChangePercentage))
        .build()
        .toUriString();

    // 調用三方 Crypto Service
    RestTemplate restTemplate = new RestTemplate();
    List<CoinGeckoMarket> coinMarkets = Arrays.asList(restTemplate.getForObject(url, CoinGeckoMarket[].class));

    // 返回數據
    return coinMarkets.stream()
        .limit(noOfItems)
        .collect(Collectors.toList())
        .toArray(new CoinGeckoMarket[noOfItems]);
  }
}
