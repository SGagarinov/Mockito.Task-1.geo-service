package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
    LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);

    @Test
    void getRusText() {
        Map<String, String> headers = new HashMap<String, String>();
        String ip = "172.123.12.19";
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        MessageSenderImpl weatherService = new MessageSenderImpl(geoService, localizationService);
        String result = weatherService.send(headers);

        assertNotNull(result);
        assertEquals("Добро пожаловать", result);
    }

    @Test
    void getEngText() {
        Map<String, String> headers = new HashMap<String, String>();
        String ip = "96.123.12.19";
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        MessageSenderImpl weatherService = new MessageSenderImpl(geoService, localizationService);
        String result = weatherService.send(headers);

        assertNotNull(result);
        assertEquals("Welcome", result);
    }
}