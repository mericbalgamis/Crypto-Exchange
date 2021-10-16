/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Meric
 *
 * Blockchain 
 * header - X-API-Token
 * API - de231f63-d0dd-407b-80f9-762fc49d06ec
 * 
 * https://api.blockchain.com/v3/exchange/l2/BTC-USD
 * https://api.blockchain.com/v3/exchange/l2/ETH-USD 
 * 
 * Binance
 * header - X-MBX-APIKEY
 * API - 8nqB1c0j97jKXtnLkYxasndhG8E9dHoUW5ZRkuWFZomDSggc3QuXdlW0FGCV7N4K
 * 
 * https://api.binance.com/api/v3/ticker/bookTicker?symbol=BTCUSDT
 * https://api.binance.com/api/v3/ticker/bookTicker?symbol=ETHUSDT
 *
 */
@RestController
public class FetchCryptoExchangeData {

    String binanceHeaderName = "X-MBX-APIKEY";
    String binanceAPIkey = "8nqB1c0j97jKXtnLkYxasndhG8E9dHoUW5ZRkuWFZomDSggc3QuXdlW0FGCV7N4K";
    String blockchainHeaderName = "X-API-Token";
    String blockchainAPIkey = "de231f63-d0dd-407b-80f9-762fc49d06ec";

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/currencyBlockchainBTC")
    public String getCurrencyBlockchainBTC() {

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();

        try {
            URL url = new URL("https://api.blockchain.com/v3/exchange/l2/BTC-USD");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty(blockchainHeaderName, blockchainAPIkey);

            int responseCode = con.getResponseCode();
            //System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                json = (JSONObject) parser.parse(response.toString());
                //System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json.toString();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/currencyBlockchainETH")
    public String getCurrencyBlockchainETH() {

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();

        try {
            URL url = new URL("https://api.blockchain.com/v3/exchange/l2/ETH-USD");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty(blockchainHeaderName, blockchainAPIkey);

            int responseCode = con.getResponseCode();
            //System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                json = (JSONObject) parser.parse(response.toString());
                //System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json.toString();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/currencyBinanceBTC")
    public String getCurrencyBinanceBTC() {

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();

        try {
            URL url = new URL("https://api.binance.com/api/v3/ticker/bookTicker?symbol=BTCUSDT");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty(binanceHeaderName, binanceAPIkey);

            int responseCode = con.getResponseCode();
            //System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                json = (JSONObject) parser.parse(response.toString());
                //System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json.toString();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/currencyBinanceETH")
    public String getCurrencyBinanceETH() {

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();

        try {
            URL url = new URL("https://api.binance.com/api/v3/ticker/bookTicker?symbol=ETHUSDT");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty(binanceHeaderName, binanceAPIkey);

            int responseCode = con.getResponseCode();
            //System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                json = (JSONObject) parser.parse(response.toString());
                //System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FetchCryptoExchangeData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json.toString();
    }
}
