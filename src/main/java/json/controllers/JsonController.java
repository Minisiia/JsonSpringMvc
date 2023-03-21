package json.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import json.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@Controller
public class JsonController {
    private CurrencyDao currencyDao;
    private final Gson gson;

    @Autowired
    public JsonController(CurrencyDao currencyDao, Gson gson) {
        this.currencyDao = currencyDao;
        this.gson = gson;
    }

    @GetMapping(value = "/uuid", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Id", uuid.toString());
        return gson.toJson(jsonObject);
    }

    @GetMapping(value = "/exchange/{currency}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getCurrentCurrency(@PathVariable("currency") String currency) throws IOException {
        return currencyDao.getCurrentCurrency(currency);

    }

    @GetMapping(value = "/exchange", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getRandomCurrency() throws IOException {
        return currencyDao.getRandomCurrency();
    }
}
