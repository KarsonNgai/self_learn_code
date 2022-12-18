package com.vtxlabpj.app.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlabpj.app.dto.CoinToListDto;
import com.vtxlabpj.app.dto.CoinToUsdDto;
import com.vtxlabpj.app.model.CoinMarketAPI;
import com.vtxlabpj.app.model.CryptoExchangeRate;
import com.vtxlabpj.app.model.SimplePriceAPI;

public interface AppOperation {

  /**
   * show the coin market, no coinId refering show all.
   * @param coinId no testing, one word is ok so far.
   * @param currency default and suppose is usd.
   * @return
   */
  @GetMapping("coin/market")
  ResponseEntity<List<CoinMarketAPI>> coinMarket(@RequestParam(defaultValue = "") String coinId, @RequestParam(defaultValue = "usd") String currency);

  /**
   * show the exchange rate between coin to currency, but the coin is quiet unclear and not complete.
   * @return
   */
  @GetMapping("exchange_rate")
  Map<String, CryptoExchangeRate> getExchangeRate();

  /**
   * show the data that one coin to currency, currency item can be multiple.
   * @param coinIds list of coin id.
   * @param currencies list of currency.
   * @return all data,model.
   */
  @GetMapping("simple_price")
  Map<String, SimplePriceAPI> getSimplePriceExchangeRate(
    @RequestParam(defaultValue = "bitcoin,ethereum,tether,dogecoin,ripple") String[] coinIds, 
    @RequestParam(defaultValue = "usd,hkd") String[] currencies);

  /**
  * show the data that one coin to currency, currency item can be multiple.
  * @param coinIds list of coin id.
  * @param currencies list of currency.
  * @return dto, name is key, dto is value contain name and usd. 
  */
  @GetMapping("simple_price/usd")
  Map<String, CoinToUsdDto> getSimplePriceExchangeRateInUsd(
    @RequestParam(defaultValue = "bitcoin,ethereum,tether,dogecoin,ripple") String[] coinIds, 
    @RequestParam(defaultValue = "usd,hkd") String[] currencies);

  /**
  * show the data that one coin to currency, currency item can be multiple. (contract:vincent)
  * @param coinIds list of coin id.
  * @param currencies list of currency.
  * @return list of dto, contain fromcurr, tocurr and rate.
  */
  @GetMapping("simple_price/list")
  CoinToListDto getSimplePriceExchangeRateToListInUsd(
    @RequestParam(defaultValue = "bitcoin,ethereum,tether,dogecoin,ripple") String[] coinIds, 
    @RequestParam(defaultValue = "usd,hkd") String[] currencies);
  
}
