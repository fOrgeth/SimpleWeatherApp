package th.forge.simpleweatherapp.data.repository.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    @Expose
    private Long temp;
    @SerializedName("pressure")
    @Expose
    private Long pressure;
    @SerializedName("humidity")
    @Expose
    private Long humidity;
    @SerializedName("temp_min")
    @Expose
    private Long tempMin;
    @SerializedName("temp_max")
    @Expose
    private Long tempMax;

    public Long getTemp() {
        return temp;
    }

    public void setTemp(Long temp) {
        this.temp = temp;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getTempMin() {
        return tempMin;
    }

    public void setTempMin(Long tempMin) {
        this.tempMin = tempMin;
    }

    public Long getTempMax() {
        return tempMax;
    }

    public void setTempMax(Long tempMax) {
        this.tempMax = tempMax;
    }
}
