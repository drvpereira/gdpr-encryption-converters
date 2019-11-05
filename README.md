# gdpr-encryption-converters

## Usage

Use the converters as JPA converters in the attributes that will be encrypted when stored in the database.
Use the `KeyEncryptor` in the attribute that will be used to fetch a record in the database (social security number, in the example below).   


```java
public class PersonalInformation {
    @Convert(converter = StringEncryptor.class)
    private String firstName;

    @Convert(converter = StringEncryptor.class)
    private String lastName;

    @Convert(converter = KeyEncryptor.class)
    private String ssn;
}
```

## Configuration

Add the following properties to your application.properties.

```properties
gdpr.database.encryption.password=<encryption key>
gdpr.database.encryption.salt=<salt>
gdpr.database.encryption.iv=<iv>
```