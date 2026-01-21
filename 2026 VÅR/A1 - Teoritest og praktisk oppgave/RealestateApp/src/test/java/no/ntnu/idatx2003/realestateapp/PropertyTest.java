package no.ntnu.idatx2003.realestateapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PropertyTest {

  @Test
  @DisplayName("Create property instance with valid parameters")
  public void testCreationOfInstance() {
    Property p = new Property(1400, "Skodje", 54, 123, "Solvik", 980.2);
    // Now verify that all the parameters were set
    assertEquals(1400, p.getMunicipalityNumber());
    assertEquals("Skodje", p.getMunicipalityName());
    assertEquals(54, p.getLotNumber());
    assertEquals(123, p.getSectionNumber());
    assertEquals("Solvik", p.getName());
    assertEquals(980.2, p.getArea());
  }

  @Test
  @DisplayName("Create property instance with municipalityName set to null")
  public void testCreationOfInstanceNullMunicipalityName() {
     assertThrows(IllegalArgumentException.class, () -> {
           Property p = new Property(1400, null, 54, 123, "Solvik", 980.2);
         }
     );
  }

  @Test
  @DisplayName("Create property instance with municipalityName set to blank")
  public void testCreationOfInstanceBlankMunicipalityName() {
    assertThrows(IllegalArgumentException.class, () -> {
          Property p = new Property(1400, "    ", 54, 123, "Solvik", 980.2);
        }
    );
  }

  @Test
  @DisplayName("Create property instance with municipalityName set to empty")
  public void testCreationOfInstanceEmptyMunicipalityName() {
    assertThrows(IllegalArgumentException.class, () -> {
          Property p = new Property(1400, "", 54, 123, "Solvik", 980.2);
        }
    );
  }
}