package pl.harpi.commons.demo.address.repository.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.harpi.commons.base.exceptions.ApplicationException;
import pl.harpi.commons.jpa.model.ObjectInstance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "AR_ADDRESS_I")
public class AddressInstance extends ObjectInstance {
    @Column(name = "CITY", nullable = false, length = 200)
    private String city;

    @Column(name = "COUNTRY", nullable = false, length = 200)
    private String country;

    @Column(name = "STREET", nullable = false, length = 200)
    private String street;

    public AddressInstance(AddressDto addressDto) throws ApplicationException {
        this.city = addressDto.getCity();
        this.country = addressDto.getCountry();
        this.street = addressDto.getStreet();
    }
}
