package pl.harpi.commons.demo.address.repository.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.harpi.commons.jpa.model1d.ObjectVersion1D;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "AR_ADDRESS_V")
public class AddressVersion extends ObjectVersion1D<AddressDto, Address, AddressVersion, AddressInstance> {
    public AddressVersion() {
        super(Address.class, AddressVersion.class, AddressInstance.class);
    }
}
