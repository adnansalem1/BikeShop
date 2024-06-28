package BikeShop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnzeigeController.class)
public class AnzeigeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnzeigeService anzeigeService;

    @Test
    @DisplayName("Test zum Erstellen einer neuen Anzeige")
    void testCreateAnzeige() throws Exception {
        Anzeige newAnzeige = new Anzeige("Test", "Test description", 2.0, null);
        Anzeige savedAnzeige = new Anzeige("Test", "Test description", 2.0, 1L);

        when(anzeigeService.save(any(Anzeige.class))).thenReturn(savedAnzeige);

        mockMvc.perform(post("/anzeigen")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test\", \"beschreibung\": \"Test description\", \"preis\": 2.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test"))
                .andExpect(jsonPath("$.beschreibung").value("Test description"))
                .andExpect(jsonPath("$.preis").value(2.0));
    }

    @Test
    @DisplayName("Test zum Abrufen einer Anzeige")
    void testGetAnzeige() throws Exception {
        Anzeige anzeige = new Anzeige("Test", "Test description", 2.0, 1L);

        when(anzeigeService.get(1L)).thenReturn(anzeige);

        mockMvc.perform(get("/anzeigen/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test"))
                .andExpect(jsonPath("$.beschreibung").value("Test description"))
                .andExpect(jsonPath("$.preis").value(2.0));
    }

    @Test
    @DisplayName("Test zum Aktualisieren einer Anzeige")
    void testUpdateAnzeige() throws Exception {
        Anzeige existingAnzeige = new Anzeige("Test", "Test description", 2.0, 1L);
        Anzeige updatedAnzeige = new Anzeige("Updated Test", "Updated description", 3.0, 1L);

        when(anzeigeService.get(1L)).thenReturn(existingAnzeige);
        when(anzeigeService.update(Mockito.anyLong(), Mockito.any(Anzeige.class))).thenReturn(updatedAnzeige);

        mockMvc.perform(put("/anzeigen/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Updated Test\", \"beschreibung\": \"Updated description\", \"preis\": 3.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Updated Test"))
                .andExpect(jsonPath("$.beschreibung").value("Updated description"))
                .andExpect(jsonPath("$.preis").value(3.0));
    }

    @Test
    @DisplayName("Test zum Löschen einer Anzeige")
    void testDeleteAnzeige() throws Exception {
        mockMvc.perform(delete("/anzeigen/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test zum Abrufen aller Anzeigen")
    void testFindAllAnzeigen() throws Exception {
        Anzeige anzeige1 = new Anzeige("Test1", "Test description 1", 2.0, 1L);
        Anzeige anzeige2 = new Anzeige("Test2", "Test description 2", 3.0, 2L);

        when(anzeigeService.findAll()).thenReturn(Arrays.asList(anzeige1, anzeige2));

        mockMvc.perform(get("/anzeigen"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Test1"))
                .andExpect(jsonPath("$[0].beschreibung").value("Test description 1"))
                .andExpect(jsonPath("$[0].preis").value(2.0))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Test2"))
                .andExpect(jsonPath("$[1].beschreibung").value("Test description 2"))
                .andExpect(jsonPath("$[1].preis").value(3.0));
    }
}