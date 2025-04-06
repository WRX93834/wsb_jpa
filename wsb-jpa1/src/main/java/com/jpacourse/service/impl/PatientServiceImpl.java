package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO createPatient(PatientTO patientTO) {
        PatientEntity entity = PatientMapper.mapToEntity(patientTO);
        entity = patientDao.save(entity);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public PatientTO getPatientById(Long id) {
        PatientEntity entity = patientDao.findOne(id);
        if (entity == null) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public void deletePatient(Long id) {
        PatientEntity entity = patientDao.findOne(id);
        if (entity == null) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientDao.delete(entity);
    }
}
