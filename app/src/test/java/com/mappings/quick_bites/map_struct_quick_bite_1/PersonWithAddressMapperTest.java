package com.mappings.quick_bites.map_struct_quick_bite_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonWithAddressMapperTest {

    @Test
    public void testPersonWithNestedAddressMapping() {
        // Given: Create an Address object
        Address address = new Address("123 Main St", "San Francisco", "94105");
        
        // Given: Create a Person with nested Address
        PersonWithAddress person = new PersonWithAddress("John Doe", 30, address);
        
        // When: Map Person to PersonDTO
        PersonWithAddressDTO dto = PersonWithAddressMapper.INSTANCE.toDto(person);
        
        // Then: Verify main fields are mapped
        assertNotNull(dto);
        assertEquals("John Doe", dto.getName());
        assertEquals(30, dto.getAge());
        
        // Then: Verify nested Address was mapped to AddressssDTO (with 4 s's!)
        assertNotNull(dto.getAddress(), "Address should be mapped!");
        assertEquals("123 Main St", dto.getAddress().getStreet());
        assertEquals("San Francisco", dto.getAddress().getCity());
        assertEquals("94105", dto.getAddress().getZipCode());
        
        // Prove it's the correct type (AddressssDTO with 4 s's)
        assertTrue(dto.getAddress() instanceof AddressssDTO, 
                   "Address should be mapped to AddressssDTO type!");
    }

    @Test
    public void testPersonWithNullAddress() {
        // Given: Person with null address
        PersonWithAddress person = new PersonWithAddress("Jane Doe", 25, null);
        
        // When: Map to DTO
        PersonWithAddressDTO dto = PersonWithAddressMapper.INSTANCE.toDto(person);
        
        // Then: DTO should handle null gracefully
        assertNotNull(dto);
        assertEquals("Jane Doe", dto.getName());
        assertEquals(25, dto.getAge());
        assertNull(dto.getAddress(), "Null address should remain null in DTO");
    }

    @Test
    public void testNullPersonReturnsNull() {
        // When: Map null person
        PersonWithAddressDTO dto = PersonWithAddressMapper.INSTANCE.toDto(null);
        
        // Then: Should return null
        assertNull(dto, "Mapping null person should return null DTO");
    }
}

