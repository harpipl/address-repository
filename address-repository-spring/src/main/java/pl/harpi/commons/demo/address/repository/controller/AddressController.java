package pl.harpi.commons.demo.address.repository.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.harpi.commons.base.exceptions.ApplicationException;
import pl.harpi.commons.base.utils.DateHelper;
import pl.harpi.commons.demo.address.repository.core.model.AddressDto;
import pl.harpi.commons.demo.address.repository.core.exceptions.AddressNotFoundException;
import pl.harpi.commons.demo.address.repository.service.AddressServiceImpl;
import pl.harpi.commons.jpa.model1d.VersionDefinition1D;
import pl.harpi.commons.spring.base.types.ExceptionMapper;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("address-repository/addresses")
public class AddressController {
    private ExceptionMapper exceptionMapper;
    private AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService, ExceptionMapper exceptionMapper) {
        this.exceptionMapper = exceptionMapper;
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAddresses(
            @RequestParam(value = "sd") String salesDate
    ) throws ApplicationException {
        List<AddressDto> adresses = addressService.findAll(new VersionDefinition1D(DateHelper.toDate(salesDate)));
        return ResponseEntity.ok(adresses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> getAddressById(
            @PathVariable String id,
            @RequestParam(value = "sd") String salesDate
    ) throws ApplicationException {
        AddressDto addressDto = addressService.findById(UUID.fromString(id),
                new VersionDefinition1D(DateHelper.toDate(salesDate)));
        return ResponseEntity.ok(addressDto);
    }

    @PostMapping
    public ResponseEntity<URI> addAddress(@RequestBody AddressDto addressDto, @RequestParam(value = "sd") String salesDate)
            throws ApplicationException {
        UUID id = addressService.insert(addressDto, DateHelper.toDate(salesDate));

        if (id != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}").buildAndExpand(id.toString()).toUri();
            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity onAddressNotFound(ApplicationException ex, Locale locale) {
        return new ResponseEntity<>(exceptionMapper.map(ex, locale), HttpStatus.BAD_REQUEST);
    }
}
