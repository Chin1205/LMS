package biz.global77.service;

import biz.global77.model.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> findAll();
    Certificate findById(int id);
    Certificate save(Certificate certificate);
    void delete(int id);
}
