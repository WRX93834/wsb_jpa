package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.persistance.entity.AddressEntity;

public final class AddressMapper {

    // Prywatny konstruktor, aby zapobiec instancjonowaniu klasy mappera
    private AddressMapper() {}

    // Mapowanie z AddressEntity do AddressTO
    public static AddressTO mapToTO(final AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        AddressTO addressTO = new AddressTO();
        addressTO.setId(entity.getId());
        addressTO.setAddressLine1(entity.getAddressLine1());
        addressTO.setAddressLine2(entity.getAddressLine2());
        addressTO.setCity(entity.getCity());
        addressTO.setPostalCode(entity.getPostalCode());
        return addressTO;
    }

    // Mapowanie z AddressTO do AddressEntity
    public static AddressEntity mapToEntity(final AddressTO addressTO) {
        if (addressTO == null) {
            return null;
        }
        AddressEntity entity = new AddressEntity();
        entity.setId(addressTO.getId());
        entity.setAddressLine1(addressTO.getAddressLine1());
        entity.setAddressLine2(addressTO.getAddressLine2());
        entity.setCity(addressTO.getCity());
        entity.setPostalCode(addressTO.getPostalCode());
        return entity;
    }
}
