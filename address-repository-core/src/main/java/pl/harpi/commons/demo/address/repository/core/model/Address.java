package pl.harpi.commons.demo.address.repository.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.harpi.commons.jpa.model1d.ObjectIdentity1D;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "AR_ADDRESS")
public class Address extends ObjectIdentity1D<AddressDto, Address, AddressVersion, AddressInstance> {
    public Address() {
        super(Address.class, AddressVersion.class, AddressInstance.class);
    }

    public Address(AddressDto addressDto) {
        super(Address.class, AddressVersion.class, AddressInstance.class);
    }

    @Override
    public AddressDto createDTO() {
        return AddressDto.builder()
                .id(getUuid())
                .city(getVersions().get(0).getObjectInstance().getCity())
                .country(getVersions().get(0).getObjectInstance().getCountry())
                .street(getVersions().get(0).getObjectInstance().getStreet())
                .build();
    }
}