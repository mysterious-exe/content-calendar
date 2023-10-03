package dev.sam.contentcalendar.Controller;

import dev.sam.contentcalendar.Model.Content;
import dev.sam.contentcalendar.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {


    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public String createContent(@RequestBody Content content){
        contentService.saveContent(content);
        return "Content created successfully";
    }

    @GetMapping("/{id}")
    public Content getContentById(@PathVariable int id) {
        return contentService.getContentById(id). orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("")
    public List<Content> getContents() {
        return contentService.getContents();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public String deleteContentById(@PathVariable int id) {
        return contentService.deleteContentById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete")
    public String deleteAllContents(){
        return contentService.deleteAllContents();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("update/{id}")
    public String updateContentById(@RequestBody Content content, @PathVariable int id){
        return contentService.updateContent(content,id);
    }
}
