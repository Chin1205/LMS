package biz.global77.controller;

import biz.global77.model.Certificate;
import biz.global77.repository.CertificateRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CertificateReportController {

    @Autowired
    private CertificateRepository certificateRepository;

    @GetMapping ("/pdf")
    public ResponseEntity<byte[]> generatedPdf() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(getData());
        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/listOfCertificate.jrxml"));

        HashMap<String, Object> map=new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);

        byte[] data = JasperExportManager.exportReportToPdf(report);

        HttpHeaders headers=new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=List_of_Certificate.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }



    @RequestMapping(value="/generateReport", method= RequestMethod.GET)
    public void generateReport(HttpServletResponse response) throws Exception {
        // Load the report template
        InputStream reportTemplate = this.getClass().getResourceAsStream("src/main/resources/listOfCertificate.jrxml");

        // Set up the data source
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(getData());

        // Create the JasperPrint object
        JasperPrint print = JasperFillManager.fillReport(reportTemplate, new HashMap<>(), dataSource);

        // Export the report to the desired format
        byte[] reportData = JasperExportManager.exportReportToPdf(print);

        // Set the response headers
        response.setContentType("application/pdf");
        response.setContentLength(reportData.length);
        response.setHeader("Content-disposition", "inline; filename=report.pdf");

        // Write the report data to the response output stream
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(reportData);
        outputStream.flush();
        outputStream.close();
    }

    private List<Certificate> getData() {
        // Retrieve the data for the report from a database or other source
        return certificateRepository.findAll();
    }

}

