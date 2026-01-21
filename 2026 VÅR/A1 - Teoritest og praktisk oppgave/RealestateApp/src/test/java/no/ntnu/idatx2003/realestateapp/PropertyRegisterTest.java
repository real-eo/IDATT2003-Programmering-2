/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package no.ntnu.idatx2003.realestateapp;

import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author arne
 */
public class PropertyRegisterTest {

  /**
   * Test of addProperty method, of class PropertyRegister.
   */
  @Test
  @DisplayName("Add valid property")
  public void testAddValidProperty() {
    Property property = new Property(1400, "Skodje", 54, 123, "Solvik", 980.2);
    PropertyRegister propertyRegister = new PropertyRegister();
    boolean expResult = true;
    boolean result = propertyRegister.addProperty(property);
    assertEquals(expResult, result);
    assertEquals(1, propertyRegister.getNumberOfProperties());
  }

  /**
   * Test findProperty searching for an existing property
   */
  @Test
  @DisplayName("Find an existing property")
  public void testFindProperty() {
    int municipalityNumber = 1400;
    int lotNumber = 54;
    int sectionNumber = 123;
    Property property = new Property(municipalityNumber
        , "Skodje", lotNumber, sectionNumber
        , "Solvik", 980.2);

    PropertyRegister propertyRegister = new PropertyRegister();
    propertyRegister.addProperty(property);
    Property expResult = property;
    Property result = propertyRegister.findProperty(municipalityNumber, lotNumber, sectionNumber);
    assertEquals(expResult, result);
  }

  /**
   * Test of findAllPropertiesWithLotNumber method, of class PropertyRegister.
   */
  @Test
  @DisplayName("Find all properties with a given lot number if lot number exists")
  public void testFindAllPropertiesWithLotNumber() {
    int lotNumber = 54;
    Property property1 = new Property(1400
        , "Skodje", lotNumber, 123
        , "Solvik", 980.2);

    Property property2 = new Property(1400
        , "Skodje", lotNumber, 134
        , "Neset", 870.0);

    Property property3 = new Property(1400
        , "Skodje", 34, 140
        , "Vika", 1023.5);

    PropertyRegister propertyRegister = new PropertyRegister();
    propertyRegister.addProperty(property1);
    propertyRegister.addProperty(property2);
    propertyRegister.addProperty(property3);

    Iterator<Property> resultIt = propertyRegister
        .findAllPropertiesWithLotNumber(lotNumber);
    assertEquals(true, resultIt.hasNext());
    int count = 0;
    while (resultIt.hasNext()) {
      Property prop = resultIt.next();
      if (lotNumber == prop.getLotNumber()) {
        count++;
      }
    }

    assertEquals(2, count);
  }

  /**
   * Test of findAllPropertiesByOwner method, of class PropertyRegister.
   */
  @Test
  @DisplayName("Find all properties by owner if owner exists")
  public void testFindAllPropertiesByOwner() {
    Property property1 = new Property(1400
        , "Skodje", 54, 123
        , "Solvik", 980.2, "Jens Andersen");

    Property property2 = new Property(1400
        , "Skodje", 54, 134
        , "Neset", 870.0, "Per Iversen");

    Property property3 = new Property(1400
        , "Skodje", 34, 140
        , "Vika", 1023.5, "Jens Andersen");

    PropertyRegister propertyRegister = new PropertyRegister();
    propertyRegister.addProperty(property1);
    propertyRegister.addProperty(property2);
    propertyRegister.addProperty(property3);

    String nameOfOwner = new String("Jens Andersen");

    Iterator<Property> resultIt = propertyRegister
        .findAllPropertiesByOwner(nameOfOwner);
    assertTrue(resultIt.hasNext());
    int count = 0;
    while (resultIt.hasNext()) {
      Property prop = resultIt.next();
      if (nameOfOwner.equals(prop.getNameOfOwner())) {
        count++;
      }
    }

    assertEquals(2, count);
  }


  /**
   * Test of getAverageAreaOfProperties method, of class PropertyRegister.
   */
  @Test
  @DisplayName("Calculate average area of all properties")
  public void testGetAverageAreaOfProperties() {
    Property property1 = new Property(1400
        , "Skodje", 54, 123
        , "Solvik", 980.2);

    Property property2 = new Property(1400
        , "Skodje", 54, 134
        , "Neset", 870.0);

    Property property3 = new Property(1400
        , "Skodje", 34, 140
        , "Vika", 1023.5);

    PropertyRegister propertyRegister = new PropertyRegister();
    propertyRegister.addProperty(property1);
    propertyRegister.addProperty(property2);
    propertyRegister.addProperty(property3);

    double expResult = 957.9;
    double result = propertyRegister.getAverageAreaOfProperties();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getNumberOfProperties method, of class PropertyRegister.
   */
  @Test
  @DisplayName("Method getNumberOfProperties()")
  public void testGetNumberOfProperties() {
    Property property1 = new Property(1400
        , "Skodje", 54, 123
        , "Solvik", 980.2);

    Property property2 = new Property(1400
        , "Skodje", 54, 134
        , "Neset", 870.0);

    Property property3 = new Property(1400
        , "Skodje", 34, 140
        , "Vika", 1023.5);

    PropertyRegister propertyRegister = new PropertyRegister();
    propertyRegister.addProperty(property1);
    propertyRegister.addProperty(property2);
    propertyRegister.addProperty(property3);

    int expResult = 3;
    int result = propertyRegister.getNumberOfProperties();
    assertEquals(expResult, result);
  }

}
