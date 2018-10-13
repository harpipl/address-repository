package pl.harpi.commons.demo.address.repository.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.harpi.commons.demo.address.repository.core.model.Address;
import pl.harpi.commons.demo.address.repository.core.model.AddressDto;
import pl.harpi.commons.demo.address.repository.core.model.AddressInstance;
import pl.harpi.commons.demo.address.repository.core.model.AddressVersion;
import pl.harpi.commons.spring.jpa.model1d.ModelRepository1DSpring;

@Repository
@Transactional
public class AddressRepository extends ModelRepository1DSpring<AddressDto, Address, AddressVersion, AddressInstance> {
    public AddressRepository() {
        super(AddressDto.class, Address.class, AddressVersion.class, AddressInstance.class);
    }
}
