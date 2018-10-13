package pl.harpi.commons.demo.address.repository.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.harpi.commons.jpa.model.ObjectDto;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddressDto extends ObjectDto {
    private String city;
    private String country;
    private String street;

    public AddressDto() {
    }

    private AddressDto(UUID id, String city, String country, String street) {
        super(id);

        this.city = city;
        this.country = country;
        this.street = street;
    }

    public static AddressDtoBuilder builder() {
        return new AddressDtoBuilder();
    }

    public static class AddressDtoBuilder {
        private UUID id;
        private String businessId;
        private String city;
        private String country;
        private String street;

        AddressDtoBuilder() {
        }

        public AddressDtoBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public AddressDtoBuilder businessId(String businessId) {
            this.businessId = businessId;
            return this;
        }

        public AddressDtoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressDtoBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AddressDtoBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressDto build() {
            return new AddressDto(id, city, country, street);
        }

        public String toString() {
            return "AddressDto.AddressDtoBuilder(id=" + this.id +
                    ", city=" + this.city + ", country=" + this.country + ", street=" + this.street + ")";
        }
    }
}
