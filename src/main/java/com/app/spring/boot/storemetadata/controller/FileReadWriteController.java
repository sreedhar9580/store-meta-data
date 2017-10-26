package com.app.spring.boot.storemetadata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileReadWriteController {

	@GetMapping("/")
	public String readFileinput() {
		return "hello";
	}
	
	@PostMapping("/meta-data")
	public String uploadmetadata(@RequestParam("input") MultipartFile file, RedirectAttributes redirectAttributes) {
		
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("ErrorText", "Please select the file");
		}
		
		return "null";
	}
}
