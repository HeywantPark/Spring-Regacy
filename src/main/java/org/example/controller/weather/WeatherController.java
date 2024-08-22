package org.example.controller.weather;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.forecast.ForecastDto;
import org.example.dto.weather.WeatherDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

@RestController
@Slf4j
@Transactional
@RequestMapping("/weather")
@PropertySource({"classpath:/application.properties"})
@CrossOrigin(origins = "*")
public class WeatherController {

    @Value("${weather.url}")
    private String URL;
    @Value("${forecast.url}")
    private String FORECAST_URL;
    @Value("${weather.api_key}")
    private String API_KEY;

    @GetMapping({"", "/{city}"})
    public ResponseEntity<WeatherDto> weather(@PathVariable(value="city", required = false) String city) {
        city = city == null ? "seoul" : city;

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("APPID", API_KEY)
                .queryParam("lang", "kr")
                .toUriString();
        WeatherDto weather = restTemplate.getForObject(url, WeatherDto.class);
        log.info("오늘의 날씨: " + weather);

        return ResponseEntity.ok(weather);
    }
    @GetMapping("/forecast/{city}")
    public ResponseEntity<ForecastDto> forest(@PathVariable("city") String city) {
        city = city == null ? "seoul" : city;

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(FORECAST_URL)
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("APPID", API_KEY)
                .queryParam("lang", "kr")
                .toUriString();

        ForecastDto forestDto = restTemplate.getForObject(url, ForecastDto.class);
        return ResponseEntity.ok(forestDto);
    }
}
