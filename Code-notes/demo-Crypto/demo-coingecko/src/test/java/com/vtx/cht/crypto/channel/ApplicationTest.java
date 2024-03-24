package com.vtx.cht.crypto.channel;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtx.cht.crypto.channel.model.CoinGeckoMarket;

@SpringBootTest
class ApplicationTest {

	@Test
	void contextLoads() {}

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

	@Test
	// objectMapper.readValue should throw JsonProcessingException & JsonMappingException
	void test_coingecko_deserialization() throws JsonProcessingException, JsonMappingException {
		String coinMarkertArray =
				"[{ \"id\" : \"bitcoin\" , \"symbol\" : \"btc\" , \"name\" : \"Bitcoin\" , \"image\" : \"https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579\" , \"current_price\" : 21260 , \"market_cap\" : 406078603590 , \"market_cap_rank\" : 1 , \"fully_diluted_valuation\" : 445848129342 , \"total_volume\" : 29913762704 , \"high_24h\" : 21581 , \"low_24h\" : 20849 , \"price_change_24h\" : -264.3326153321068 , \"price_change_percentage_24h\" : -1.22806 , \"market_cap_change_24h\" : -4870511830.287781 , \"market_cap_change_percentage_24h\" : -1.18519 , \"circulating_supply\" : 19126806 , \"total_supply\" : 21000000 , \"max_supply\" : 21000000 , \"ath\" : 69045 , \"ath_change_percentage\" : -69.19681 , \"ath_date\" : \"2021-11-10T14:24:11.849Z\" , \"atl\" : 67.81 , \"atl_change_percentage\" : 31264.5607 , \"atl_date\" : \"2013-07-06T00:00:00.000Z\" , \"roi\" : {\"times\": 0.42047779841032895, \"currency\": \"eth\", \"percentage\": 42.0477798410329 } , \"last_updated\" : \"2022-08-20T11:34:20.012Z\"	}]";

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		CoinGeckoMarket[] coinGeckoMarkets = objectMapper.readValue(coinMarkertArray, CoinGeckoMarket[].class);

		assertEquals("bitcoin", coinGeckoMarkets[0].getId());
		assertEquals("btc", coinGeckoMarkets[0].getSymbol());
		assertEquals(new BigDecimal("69045"), coinGeckoMarkets[0].getAth());
		assertEquals("2022-08-20T11:34:20.012Z", coinGeckoMarkets[0].getLastUpdated());
		assertEquals(new BigDecimal("-4870511830.287781"), coinGeckoMarkets[0].getMarketCapChange24h());
		assertEquals(new BigDecimal("0.42047779841032895"), coinGeckoMarkets[0].getRoi().getTimes());
		assertEquals(new BigDecimal("445848129342"), coinGeckoMarkets[0].getFullyDilutedValuation());
	}

	@Test
	// objectMapper.readValue should throw JsonProcessingException & JsonMappingException
	void test_coingecko_serialization() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		CoinGeckoMarket coinGeckoMarket = new CoinGeckoMarket();
		coinGeckoMarket.setId("bitcoin");
		coinGeckoMarket.setSymbol("btc");
		coinGeckoMarket.setCurrentPrice(new BigDecimal("21260"));

		// objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		String coinGeckoMarketJSON = objectMapper.writeValueAsString(coinGeckoMarket);

		assertTrue(StringUtils.contains(coinGeckoMarketJSON, "\"id\":\"bitcoin\""));
		assertTrue(StringUtils.contains(coinGeckoMarketJSON, "\"symbol\":\"btc\""));
		assertTrue(StringUtils.contains(coinGeckoMarketJSON, "\"current_price\":21260"));
	}

	@Test
	public void constructUriWithQueryParameter() {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(baseUrl) //
				.pathSegment(versionUrl).path(coinsMarketsEndpointUrl) //
				.queryParam("vs_currency", vsCurrency) //
				.queryParamIfPresent("ids", Optional.ofNullable(null)) //
				.queryParamIfPresent("order", Optional.ofNullable(order))
				.queryParamIfPresent("per_page", Optional.ofNullable(perPage))
				.queryParamIfPresent("page", Optional.ofNullable(page))
				.queryParamIfPresent("sparkline", Optional.ofNullable(sparkline))
				.queryParamIfPresent("price_change_percentage", Optional.ofNullable(priceChangePercentage)) //
				.build();

		assertEquals("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&price_change_percentage=1h", uriComponents.toUriString());
	}

	/**
	 * 
	 * "id": "bitcoin", "symbol": "btc", "name": "Bitcoin", "image":
	 * "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579", "current_price":
	 * 21260, "market_cap": 406078603590, "market_cap_rank": 1, "fully_diluted_valuation": 445848129342,
	 * "total_volume": 29913762704, "high_24h": 21581, "low_24h": 20849, "price_change_24h":
	 * 
	 * -264.3326153321068, "price_change_percentage_24h": -1.22806, "market_cap_change_24h":
	 * -4870511830.287781, "market_cap_change_percentage_24h": -1.18519, "circulating_supply": 19126806,
	 * "total_supply": 21000000, "max_supply": 21000000, "ath": 69045, "ath_change_percentage":
	 * -69.19681, "ath_date": "2021-11-10T14:24:11.849Z", "atl": 67.81, "atl_change_percentage":
	 * 
	 * 31264.5607, "atl_date": "2013-07-06T00:00:00.000Z", "roi": { "times": 0.42047779841032895,
	 * "currency": "eth", "percentage": 42.0477798410329 }, "last_updated": "2022-08-20T11:34:20.012Z"
	 */

}
