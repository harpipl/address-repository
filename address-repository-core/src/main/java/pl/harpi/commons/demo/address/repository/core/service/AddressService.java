package pl.harpi.commons.demo.address.repository.core.service;

import pl.harpi.commons.base.exceptions.ApplicationException;
import pl.harpi.commons.demo.address.repository.core.model.AddressDto;
import pl.harpi.commons.jpa.model1d.VersionDefinition1D;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AddressService {
    UUID insert(AddressDto addressDto, Date salesDate) throws ApplicationException;

    AddressDto findById(UUID id, VersionDefinition1D versionDefinition) throws ApplicationException;

    List<AddressDto> findAll(VersionDefinition1D versionDefinition);

}
