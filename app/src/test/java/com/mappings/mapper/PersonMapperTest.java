package com.mappings.mapper;

import com.mappings.dtos.PersonDTO;
import com.mappings.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonMapperTest {

    @Test
    void testMapping() {
        Person person = new Person("Robert", 31);

        PersonDTO dto = PersonMapper.INSTANCE.toDto(person);

        assertEquals("Robert", dto.getName());
        assertEquals(31, dto.getAge());
    }
}

