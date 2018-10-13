package pl.harpi.commons.demo.address.repository.repository;

import pl.harpi.commons.demo.address.repository.core.model.Address;
import pl.harpi.commons.demo.address.repository.core.model.AddressDto;
import pl.harpi.commons.demo.address.repository.core.model.AddressInstance;
import pl.harpi.commons.demo.address.repository.core.model.AddressVersion;
import pl.harpi.commons.jpa.model1d.ModelRepository1D;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class AddressRepository extends ModelRepository1D<AddressDto, Address, AddressVersion, AddressInstance> {
    public AddressRepository() {
        super(AddressDto.class, Address.class, AddressVersion.class, AddressInstance.class);
    }
}
