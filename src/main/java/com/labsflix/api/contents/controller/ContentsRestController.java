package com.labsflix.api.contents.controller;

import java.util.List;

import com.labsflix.api.contents.vo.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.labsflix.api.contents.service.ContentsService;

@RestController
@RequestMapping("/v1")
public class ContentsRestController {

	private static Logger logger = LoggerFactory.getLogger(ContentsRestController.class);

	private ContentsService contentsService;

	@Autowired
	public ContentsRestController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

	@RequestMapping(path="/contents", method=RequestMethod.GET, name="getContents")
	public List<Content> getContents(@RequestParam(value = "category") String category) {
		logger.debug("getContents() called!!");
		return contentsService.getContents(category);
	}

	@RequestMapping(path="/contents", method=RequestMethod.POST, name="addContents")
	public int addContents(@RequestBody Content content) {
		return contentsService.addContent(content);
	}

}
