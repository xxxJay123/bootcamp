package com.vtx.cht.crypto.channel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vtx.cht.crypto.channel.model.CoinGeckoMarket;

@RequestMapping("/default")
public interface CryptoController {

    @GetMapping("/coin/market")
    CoinGeckoMarket[] getCoinMarket();

}