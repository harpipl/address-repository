package pl.harpi.commons.demo.address.repository.rest;

import pl.harpi.commons.base.exceptions.ApplicationException;
import pl.harpi.commons.base.utils.DateHelper;
import pl.harpi.commons.demo.address.repository.core.model.AddressDto;
import pl.harpi.commons.demo.address.repository.service.AddressServiceEJBLocal;
import pl.harpi.commons.jpa.model1d.VersionDefinition1D;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/addresses")
public class AddressResource {
    @Context
    UriInfo uriInfo;

    @EJB
    private AddressServiceEJBLocal addressService;

    @GET
    public Response getAddresses(
            @QueryParam(value = "sd") String salesDate
    ) throws ApplicationException {
        List<AddressDto> adresses = addressService.findAll(new VersionDefinition1D(DateHelper.toDate(salesDate)));
        return Response.ok(adresses).build();
    }

    @POST
    public Response addAddress(AddressDto addressDto, @QueryParam(value = "sd") String salesDate)
            throws ApplicationException {

        UUID id = addressService.insert(addressDto, DateHelper.toDate(salesDate));

        if (id != null) {
            Link lnk = Link.fromUri(uriInfo.getPath() + "/" + id).rel("self").build();
            return Response.created(lnk.getUri()).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}

