package searchengine.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchengine.dto.statistics.SearchResponse;
import searchengine.model.Lemma;
import searchengine.services.IndexService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IndexController {
    private final IndexService service;


    @GetMapping("/startIndexing")
    public void getIndex(){
        service.startIndexing();
    }

    @PostMapping("/indexPage")
    public Boolean indexPage(@RequestParam String url) throws IOException {
        return service.indexPage(url);
    }

    @GetMapping("/search")
    public SearchResponse search(@RequestParam("text") String query) throws IOException {
        return service.search(query);
    }
}
