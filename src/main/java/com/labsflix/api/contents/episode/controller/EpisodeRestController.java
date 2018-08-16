package com.labsflix.api.contents.episode.controller;

import com.labsflix.api.contents.vo.Content;
import com.labsflix.api.contents.episode.service.EpisodeService;
import com.labsflix.api.contents.episode.vo.Episode;
import com.labsflix.api.contents.episode.vo.Season;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EpisodeRestController {

    private static Logger logger = LoggerFactory.getLogger(EpisodeRestController.class);

    private EpisodeService episodeService;

    @Autowired
    public EpisodeRestController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/contents/search")
    public List<Content> searchContents(@RequestParam(value = "title") String title) {
        logger.debug("searchContents() called!!");
        return episodeService.searchContents(title);
    }

    @GetMapping("/contents/{id}")
    public Content getContentsDetail(@PathVariable(value = "id") String id) {
        logger.debug("getContentsDetail() called!!");
        return episodeService.getContentsDetail(id);
    }

    @GetMapping("/contents/{content}/episodes")
    public List<Season> getAllEpisodes(@PathVariable(value = "content") String content) {
        logger.debug("getContentsEpisodes() called!!");
        return episodeService.getAllEpisodes(content);
    }

    @GetMapping("/contents/{content}/{season}")
    public List<Episode> getSeason(@PathVariable(value = "content") String content, @PathVariable(value = "season") int season) {
        logger.debug("getSeason() called!!");
        return episodeService.getSeason(content, season);
    }

    @GetMapping("/contents/{content}/{season}/{episode}")
    public Episode getEpisodeDetail(@PathVariable(value = "content") String content, @PathVariable(value = "season") int season, @PathVariable(value = "episode") int episode) {
        logger.debug("getEpisodeDetail() called!!");
        return episodeService.getEpisodeDetail(content, season, episode);
    }

}