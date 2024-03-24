package com.vtx.cht.crypto.channel.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtx.cht.crypto.channel.controller.CryptoController;
import com.vtx.cht.crypto.channel.model.CoinGeckoMarket;
import com.vtx.cht.crypto.channel.service.CoinGeckoService;

// http://localhost:8085/crypto/api/v1/coin/market
@RestController
@RequestMapping("/crypto/api/v1")
public class CryptoControllerImpl implements CryptoController {

  @Autowired
  CoinGeckoService coinGeckoService;

  @Override
  public CoinGeckoMarket[] getCoinMarket() {
    return coinGeckoService.getCoinMarket();
  }

}
