package biz.global77.controller;

import biz.global77.model.Certificate;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CertificateReportController {
//    @GetMapping ("/pdf")
//    public ResponseEntity<byte[]> generatedPdf@PathVariable String certificates) throws JRException, FileNotFoundException {
//
//        List<Certificate> certificateList = new ArrayList<Certificate>();
//        cer
//
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(certificates);
//        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/listOfCertificate.jrxml"));
//
//        HashMap<String, Object> map=new HashMap<>();
//        JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
//
//        byte[] data = JasperExportManager.exportReportToPdf(report);
//
//        HttpHeaders headers=new HttpHeaders();
//        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=List_of_Certificate.pdf");
//
//        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
//    }

}

