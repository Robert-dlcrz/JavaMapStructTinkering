package com.mappings.quick_bites.map_struct_quick_bite_1;

public class PersonWithAddressDTO {
    private String name;
    private int age;
    private AddressssDTO address;  // Different type: AddressssDTO (with 4 s's!)

    public PersonWithAddressDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public AddressssDTO getAddress() { return address; }
    public void setAddress(AddressssDTO address) { this.address = address; }
}

