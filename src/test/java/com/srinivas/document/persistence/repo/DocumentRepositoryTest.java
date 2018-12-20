package com.srinivas.document.persistence.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srinivas.document.enums.DocumentType;
import com.srinivas.document.model.bankstatement.BankStatement;
import com.srinivas.document.model.common.Document;
import com.srinivas.document.model.payroll.Payroll;
import com.srinivas.document.persistence.entity.DocumentEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import javax.print.Doc;
import java.io.File;
import java.time.Duration;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentRepositoryTest {

    private ObjectMapper mapper = new ObjectMapper();

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:10.4")
            .withDatabaseName("document")
            .withUsername("sa")
            .withPassword("sa")
            .withStartupTimeout(Duration.ofSeconds(600));

    @Autowired
    private DocumentRepository documentRepository;

    @Before
    public void setUp() {
        this.documentRepository.deleteAll();
    }

    @Test
    public void testDocumentEntity1() throws Exception {
        File file = ResourceUtils.getFile("classpath:data_1.json");
        String fileToString = FileUtils.readFileToString(file);

        BankStatement document = this.mapper.readValue(fileToString, BankStatement.class);
        document.setEndDate(new Date());

        /**
         * Here data can be any implementation of Document class. Hence it supports polymorphic json data with PostgresSQL JSONB data type.
         */

        DocumentEntity documentEntity = DocumentEntity.builder()
                .type(DocumentType.BANK_STATEMENT)
                .name("test")
                .pageCount(3)
                .data(document)
                .build();

        DocumentEntity res = this.documentRepository.save(documentEntity);
        Assert.assertTrue(res.getId() != null);
    }


    @Test
    public void testDocumentEntity2() throws Exception {
        File file = ResourceUtils.getFile("classpath:data_2.json");
        String fileToString = FileUtils.readFileToString(file);

        Document document = this.mapper.readValue(fileToString, Payroll.class);
        /**
         * Here data can be any implementation of Document class. Hence it supports polymorphic json data with PostgresSQL JSONB data type.
         */

        DocumentEntity documentEntity = DocumentEntity.builder()
                .type(DocumentType.PAYROLL)
                .name("test")
                .pageCount(3)
                .data(document)
                .build();

        DocumentEntity res = this.documentRepository.save(documentEntity);
        Assert.assertTrue(res.getId() != null);
    }

}
