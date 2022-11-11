package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);

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

}