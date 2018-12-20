package com.srinivas.document.api.controller;

import com.srinivas.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

}
