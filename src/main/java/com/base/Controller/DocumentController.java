package com.base.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.base.Model.Document;
import com.base.Repository.DocumentRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/doc")
public class DocumentController {
	
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@GetMapping(value="/documents")
	public ResponseEntity<List<Document>> getDocuments()
	{
		System.out.println("Get all Documents...");

	  List<Document> document = new ArrayList<>();
		documentRepository.findAll().forEach(document::add);
		return new ResponseEntity<List<Document>>(document, HttpStatus.OK);
 
		
	}
	/*@GetMapping(value="/documents/{id}")
	public ResponseEntity<Document> getDocument(@PathVariable("id") Long id)
	{
		try {
			System.out.println("Get one Document...");
			 
			Document document = documentRepository.findOne(id);
			return new ResponseEntity<Document>(document, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	 
 
	} */
	@PostMapping(value="/customers/create")
	public  ResponseEntity<String> save(@RequestParam("file") MultipartFile file ,@RequestParam("document") String document) throws JsonParseException , JsonMappingException, IOException
	{
		System.out.println("save one Documents...");

	
		Document documentSave = new ObjectMapper().readValue(document, Document.class);
		documentSave.setLogo(file.getBytes());
		documentSave.setNamefile(file.getOriginalFilename());
		
		
	     Document doc= documentRepository.save(documentSave);
	     if(doc !=null)
	     {
	 		return new ResponseEntity<>("document est sauvegardé!", HttpStatus.OK);

	     }else
	     {
	 		return new ResponseEntity<>("document n 'est pas sauvegarder n!", HttpStatus.BAD_REQUEST);

	     }
	     
	}
	
	


    
	
}
