package com.jpacourse.persistance.dao;

import com.jpacourse.WsbJpaApplication;
import com.jpacourse.persistance.entity.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    @Test
    public void testShouldFindAddressById() {
        // given: tworzymy nowy rekord adresu
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("60-400");

        // zapisujemy adres
        AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();

        // when: pobieramy adres po zapisanym ID
        AddressEntity found = addressDao.findOne(saved.getId());

        // then: weryfikujemy, że rekord został znaleziony i ma poprawne dane
        assertThat(found).isNotNull();
        assertThat(found.getPostalCode()).isEqualTo("60-400");
    }

    @Transactional
    @Test
    public void testShouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");
        long entitiesNumBefore = addressDao.count();

        // when
        final AddressEntity saved = addressDao.save(addressEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore + 1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");

        // when
        final AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();
        final AddressEntity newSaved = addressDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        addressDao.delete(saved.getId());

        // then
        final AddressEntity removed = addressDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }
}
