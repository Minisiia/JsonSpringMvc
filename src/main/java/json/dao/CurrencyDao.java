package json.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonObject;
import json.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

@Component
public class CurrencyDao {
    private final Gson gson;

    @Autowired
    public CurrencyDao(Gson gson) {
        this.gson = gson;
    }

    public Currency[] getAllCurrency() throws IOException {
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));
        Currency[] currencies = gson.fromJson(jsonReader, Currency[].class);
        return currencies;
    }

    public String getCurrentCurrency(String currency) throws IOException {
        Currency[] currencies = getAllCurrency();
        String resultCurrency = "no such currency";
        for (int i = 0; i < currencies.length; i++) {
            if (currencies[i].getCurrencyAbbr().equals(currency))
                resultCurrency = String.valueOf(currencies[i].getRate());
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("rate", resultCurrency);
        return gson.toJson(jsonObject);
    }

    public String getRandomCurrency() throws IOException {
        Currency[] currencies = getAllCurrency();
        Random random = new Random();
        int randomArrayElement = random.nextInt(currencies.length);
        System.out.println(currencies[randomArrayElement].getCurrencyAbbr()
                + " " + currencies[randomArrayElement].getRate());
        JsonObject jsonObject = new JsonObject();
        String resultCurrency = String.valueOf(currencies[randomArrayElement].getRate());
        String resultAbbr = String.valueOf(currencies[randomArrayElement].getCurrencyAbbr());
        jsonObject.addProperty("rate", resultCurrency);
        jsonObject.addProperty("cc", resultAbbr);
        return gson.toJson(jsonObject);
    }
}
