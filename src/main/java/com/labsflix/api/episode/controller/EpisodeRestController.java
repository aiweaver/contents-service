package com.labsflix.api.episode.controller;

import com.labsflix.api.domain.Content;
import com.labsflix.api.episode.service.EpisodeService;
import com.labsflix.api.domain.Episode;
import com.labsflix.api.domain.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EpisodeRestController {

    private EpisodeService episodeService;

    @Autowired
    public EpisodeRestController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/contents/search")
    public List<Content> searchContents(@RequestParam(value = "title") String title) {
        return episodeService.searchContents(title);
    }

    @GetMapping("/contents/{id}")
    public Content getContentsDetail(@PathVariable(value = "id") String id) {
        return episodeService.getContentsDetail(id);
    }

    @GetMapping("/contents/{content}/episodes")
    public List<Season> getAllEpisodes(@PathVariable(value = "content") String content) {
        return episodeService.getAllEpisodes(content);
    }

    @GetMapping("/contents/{content}/{season}")
    public List<Episode> getSeason(@PathVariable(value = "content") String content, @PathVariable(value = "season") int season) {
        return episodeService.getSeason(content, season);
    }

    @GetMapping("/contents/{content}/{season}/{episode}")
    public Episode getEpisodeDetail(@PathVariable(value = "content") String content, @PathVariable(value = "season") int season, @PathVariable(value = "episode") int episode) {
        return episodeService.getEpisodeDetail(content, season, episode);
    }

}