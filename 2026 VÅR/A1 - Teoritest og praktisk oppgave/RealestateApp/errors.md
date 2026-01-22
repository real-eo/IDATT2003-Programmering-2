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