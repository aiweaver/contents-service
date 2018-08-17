package com.labsflix.api.contents.controller;

import java.util.List;

import com.labsflix.api.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.labsflix.api.contents.service.ContentsService;

@RestController
@RequestMapping("/v1")
public class ContentsRestController {

	private ContentsService contentsService;

	@Autowired
	public ContentsRestController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

	@GetMapping("/contents")
	public List<Content> getContents(@RequestParam(value = "category") String category) {
		return contentsService.getContents(category);
	}

	@PostMapping("/contents")
	public int addContents(@RequestBody Content content) {
		return contentsService.addContent(content);
	}

}
