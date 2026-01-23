# Errors

#### 1) Value 'this.municipalityName' is always 'null'
'municipalityName' never gets assigned in the ctor.
```java
public Property(int municipalityNumber, String municipalityName,
                int lotNumber, int sectionNumber,
                String name, double area) {
    this.municipalityNumber = municipalityNumber;
                                                                                        // <-- Missing assignment
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.name = name;
    this.area = area;
    this.nameOfOwner = null;
}
```


#### 2) Cannot assign a value to final variable 'municipalityName'
'municipalityName' is declared final with an initializer value, so it cannot be reassigned.
```java
private final String municipalityName = null;
```


#### 3) Rename "name" which hides the field declared at line 17
Local variable name overshadows name member due to reinitialization.
```java
public String getName() {
    String name = "Test";                                                               // ! BUG
    return name;
}
```


#### 4) Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown
Missing guard condition for 'null'. Property ctor does not throw expected IllegalArgumentException when municipalirty name is passed as 'null'.
```java
public Property(int municipalityNumber, String municipalityName,
                int lotNumber, int sectionNumber,
                String name, double area) {
    /*  ! ERROR
            missing guard condition
    */

    this.municipalityNumber = municipalityNumber;
    this.municipalityName = municipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.name = name;
    this.area = area;
    this.nameOfOwner = null;
}
```


#### 5) Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown
Missing guard condition for blank strings. Property ctor does not throw expected IllegalArgumentException when municipalirty name is passed as " ".
```java
public Property(int municipalityNumber, String municipalityName,
                int lotNumber, int sectionNumber,
                String name, double area) {
    /*  ! ERROR
            missing guard condition
    */

    this.municipalityNumber = municipalityNumber;
    this.municipalityName = municipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.name = name;
    this.area = area;
    this.nameOfOwner = null;
}
```



#### 6) Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown 
Missing guard condition for empty strings. Property ctor does not throw expected IllegalArgumentException when municipalirty name is passed as "".
```java
public Property(int municipalityNumber, String municipalityName,
                int lotNumber, int sectionNumber,
                String name, double area) {
    /*  ! ERROR
            missing guard condition
    */

    this.municipalityNumber = municipalityNumber;
    this.municipalityName = municipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.name = name;
    this.area = area;
    this.nameOfOwner = null;
}
```

#### 7) Missing not operator on comparison for duplicate property entries with the current logic flow
'addProperty(Property property)' checks if the new property's ID already exists in properties. Not if the new property's ID doesn't exist, which is what we want to prevent duplicate entries with the current logic flow.
```java
public boolean addProperty(Property property) {
    if (property == null) {
        throw new IllegalArgumentException("property cannot be null");
    }

    boolean success = false;
    if (this.properties.containsKey(property.getPropertyIDAsString())) {                // ! BUG
        this.properties.put(property.getPropertyIDAsString(), property);
        success = false;
    }
    return success;
}
```

#### 8) Wrong boolean reassignment value to local success variable 
'success' gets reassigned to the wrong value during upon successful property addition
```java
public boolean addProperty(Property property) {
    if (property == null) {
        throw new IllegalArgumentException("property cannot be null");
    }

    boolean success = false;
    if (!this.properties.containsKey(property.getPropertyIDAsString())) {
        this.properties.put(property.getPropertyIDAsString(), property);
        success = false;                                                                // ! BUG
    }
    return success;
}
```


#### 9) Incorrect comparison operator
'findAllPropertiesWithLotNumber(int lotNumber)' uses the 'ne' operator instead of the 'eq' operator
```java
public Iterator<Property> findAllPropertiesWithLotNumber(int lotNumber) {
    // Create a temperarely collection to store the found properties in
    HashSet<Property> foundProperties = new HashSet<>();
    for (Property property : this.properties.values()) {
        if (property.getLotNumber() != lotNumber) {                                     // ! BUG
            foundProperties.add(property);
        }
    }
    return foundProperties.iterator();
}
```

#### 10) Reassignment to an inremental counter instead of adding
'getSumOfAreas()' reassigns 'sumOfAreas' each iteration instead of adding to the sum 
```java
private double getSumOfAreas() {
    double sumOfAreas = 0;
    for (Property property : this.properties.values()) {
        sumOfAreas = property.getArea();                                                // ! BUG
    }
    return sumOfAreas;
}
```

#### 11) Missing division after summing area 
'getAverageAreaOfProperties()' doesn't calculate the mean after summing 
```java
public double getAverageAreaOfProperties() {
    double averageArea = 0;
    if (this.properties.size() > 0) {
        averageArea = getSumOfAreas() /* ! BUG */ ;                                                   
    }
    return averageArea;
}
```


#### 12) String values are compared using '==', not 'equals()' 
Strings and Boxed types should be compared using "equals()", not 'eq' operator.
```java
public Iterator<Property> findAllPropertiesByOwner(String nameOfOwner) {
    // Guard conditions
    if (nameOfOwner == null) {
        throw new IllegalArgumentException("nameOfOwner cannot be null");
    }
    if (nameOfOwner.isBlank() ) {
        throw new IllegalArgumentException("nameOfOwner cannot be blank or empty");
    }

    HashSet<Property> foundProperties = new HashSet<>();
    for (Property property : this.properties.values()) {
        if (property.getNameOfOwner() == nameOfOwner) {
            foundProperties.add(property);
        }
    }
    return foundProperties.iterator();
}
```