# MapStruct Quick Bites: Implicit Mapping

## Key Learning: Always Use `@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)`

### What is Implicit Mapping?
MapStruct automatically copies properties when **property names match exactly**, no `@Mapping` needed.

### How MapStruct Works
1. **Type detection**: Uses field types to determine conversions (`Address → AddressssDTO`)
2. **Property matching**: Maps properties by name (`street → street`, `city → city`)
3. **Class names don't matter**: `AddressssDTO` (4 s's) works fine—only property names matter!

### The Danger: Silent Partial Mappings
If only 1 of 10 properties match, MapStruct still creates the mapping—leaving 9 fields NULL. **Your code compiles but has bugs!**

### The Solution
```java
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)  // Forces explicit mappings
public interface PersonMapper {
    PersonDTO toDto(Person person);
}
```

Now compilation **fails** if any field is unmapped, forcing you to be explicit:
```java
@Mapping(target = "unusedField", ignore = true)  // Clear intent!
```

### Experiment
1. Change `zipCode` to `zipCodee` in `AddressssDTO.java`
2. Run test: `./gradlew test --tests PersonWithAddressMapperTest`
3. Observe: Test fails—`zipCodee` is NULL because name doesn't match!

### Takeaway
**Implicit mapping is convenient but dangerous.** Use `ERROR` policy to catch bugs at compile time, not runtime.

