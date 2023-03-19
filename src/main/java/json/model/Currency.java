package json.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Currency {
    @JsonIgnore
    @JsonProperty("r030")
    private String r030;

    @SerializedName("txt")
    @JsonProperty("txt")
    private String currencyName;

    @SerializedName("rate")
    @JsonProperty("rate")
    private BigDecimal rate;

    @SerializedName("cc")
    @JsonProperty("cc")
    private String currencyAbbr;

    @SerializedName("exchangedate")
    @JsonProperty("exchangedate")
    private String exchangeDate;

    public Currency() {
    }

    public String getR030() {
        return r030;
    }

    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCurrencyAbbr() {
        return currencyAbbr;
    }

    public void setCurrencyAbbr(String currencyAbbr) {
        this.currencyAbbr = currencyAbbr;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyName='" + currencyName + '\'' +
                ", rate=" + rate +
                ", currencyAbbr='" + currencyAbbr + '\'' +
                ", exchangeDate='" + exchangeDate + '\'' +
                '}';
    }
}
