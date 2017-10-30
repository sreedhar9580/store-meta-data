package com.app.spring.boot.storemetadata.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.spring.boot.storemetadata.dao.EmployeeRepository;
import com.app.spring.boot.storemetadata.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class FileReadWriteController {

	private  final Logger logger = LoggerFactory.getLogger(FileReadWriteController.class); 
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String readFileinput() {
		return "index";
	}

	@PostMapping("/meta-data")
	public String uploadmetadata(@RequestParam("input") MultipartFile file, RedirectAttributes redirectAttributes) {

		
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("ErrorText", "Please select the file");
		}
		
		logger.info("Filename :"+ file.getOriginalFilename());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			byte[] bytes = file.getBytes();
			Employee emp = mapper.readValue(bytes,Employee.class);
			employeeRepository.save(emp);
		} catch (IOException e){
			logger.info("IOException: ", e);
		}
		
		redirectAttributes.addFlashAttribute("ErrorText",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");
		return "redirect:/output";
	}
	
	@GetMapping("/output")
	public String outputStatus() {
		List<Employee> employee = (List<Employee>) employeeRepository.findAll();
		
		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream objOutStr = new ObjectOutputStream(f);

			// Write objects to file
			objOutStr.writeObject(employee.toString());
			objOutStr.close();
			StringBuilder str = new StringBuilder();
			employee.forEach((emp) ->
			str.append(emp.toString()));
			logger.info("Result: "+ str);
		}catch (FileNotFoundException e) {
			logger.info("FileNotFoundException: "+ e);
		}catch (IOException e) {
			logger.info("IOException: "+ e);
		}
		
		return "output";
    }
	
}
