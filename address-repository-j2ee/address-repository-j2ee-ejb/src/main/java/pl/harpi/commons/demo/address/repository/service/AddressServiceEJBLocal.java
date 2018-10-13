package pl.harpi.commons.demo.address.repository.service;

import pl.harpi.commons.base.exceptions.ApplicationException;
import pl.harpi.commons.demo.address.repository.core.model.AddressDto;
import pl.harpi.commons.demo.address.repository.core.service.AddressService;
import pl.harpi.commons.jpa.model1d.VersionDefinition1D;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Local
public interface AddressServiceEJBLocal extends AddressService {
    @Override
    public UUID insert(AddressDto addressDto, Date salesDate) throws ApplicationException;

    @Override
    public AddressDto findById(UUID id, VersionDefinition1D versionDefinition) throws ApplicationException;

    @Override
    public List<AddressDto> findAll(VersionDefinition1D versionDefinition);
}
