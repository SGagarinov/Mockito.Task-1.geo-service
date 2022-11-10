import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {


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

    @Test
    void checkByIp() {
        String ip = "172.0.32.11";
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Location result = geoService.byIp(ip);

        assertNotNull(result);
        assertEquals(location.getCountry(), result.getCountry());
        assertEquals(location.getCity(), result.getCity());
        assertEquals(location.getStreet(), result.getStreet());
        assertEquals(location.getBuiling(), result.getBuiling());
    }

    @Test
    void checkLocale() {
        Country input = Country.USA;


        String result = localizationService.locale(input);

        assertNotNull(result);
        assertEquals("Welcome", result);
    }
}
