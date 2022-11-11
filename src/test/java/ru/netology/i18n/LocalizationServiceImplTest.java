package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);

    @Test
    void checkLocale() {
        Country input = Country.USA;

        String result = localizationService.locale(input);

        assertNotNull(result);
        assertEquals("Welcome", result);
    }

}