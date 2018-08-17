package com.labsflix.api.contents.service;

import java.util.List;

import com.labsflix.api.domain.Content;
import com.labsflix.api.contents.mapper.ContentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contentsService")
public class ContentsService {

	private ContentsMapper contentsMapper;

	@Autowired
	public ContentsService(ContentsMapper contentsMapper) {
		this.contentsMapper = contentsMapper;
	}

	public List<Content> getContents(String category) {
		return contentsMapper.findByCategory(category);
	}

	public int addContent(Content content) {
		return contentsMapper.insertContent(content);
	}

}
