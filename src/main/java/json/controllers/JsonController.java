package json.controllers;

import json.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.UUID;

@Controller
public class JsonController {
    private CurrencyDao currencyDao;

    @Autowired
    public JsonController(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @GetMapping("/uuid")
    @ResponseBody
    public String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/exchange/{currency}")
    @ResponseBody
    public String getCurrentCurrency(@PathVariable("currency") String currency) throws IOException {
        return currencyDao.getCurrentCurrency(currency);
    }

    @GetMapping("/exchange")
    @ResponseBody
    public String getRandomCurrency() throws IOException {
        return currencyDao.getRandomCurrency();
    }
}
