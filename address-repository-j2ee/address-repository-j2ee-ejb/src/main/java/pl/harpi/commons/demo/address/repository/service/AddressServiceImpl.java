package pl.harpi.commons.demo.address.repository.service;

import pl.harpi.commons.base.exceptions.ApplicationException;
import pl.harpi.commons.demo.address.repository.core.exceptions.AddressNotFoundException;
import pl.harpi.commons.demo.address.repository.core.model.AddressDto;
import pl.harpi.commons.demo.address.repository.repository.AddressRepository;
import pl.harpi.commons.jpa.model1d.OperationContext1D;
import pl.harpi.commons.jpa.model1d.VersionDefinition1D;
import pl.harpi.commons.jpa.types.Interval;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Stateless
public class AddressServiceImpl implements AddressServiceEJBLocal {
    @EJB
    private AddressRepository addressRepository;

    @Override
    public UUID insert(AddressDto addressDto, Date salesDate) throws ApplicationException {
        OperationContext1D operationContext = new OperationContext1D("CREATOR", new Interval(salesDate, null));

        return addressRepository.insert(addressDto, operationContext);
    }

    @Override
    public AddressDto findById(UUID id, VersionDefinition1D versionDefinition) throws ApplicationException {
        return addressRepository.find(id, versionDefinition).orElseThrow(AddressNotFoundException::new);
    }

    @Override
    public List<AddressDto> findAll(VersionDefinition1D versionDefinition) {
        return addressRepository.findAll(versionDefinition);
    }
}
