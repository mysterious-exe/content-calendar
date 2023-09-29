package dev.sam.contentcalendar.ServiceIMPL;

import dev.sam.contentcalendar.Model.Content;
import dev.sam.contentcalendar.Repository.ContentRepository;
import dev.sam.contentcalendar.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceIMPL implements ContentService {


    private final ContentRepository contentRepository;

    public ContentServiceIMPL(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public String updateContent(Content content, int Id) {
        if(contentRepository.existsById(Id)){
            Content c = contentRepository.findById(Id).get();
            c.setTitle(content.getTitle());
            c.setDesc(content.getDesc());
            c.setStatus(content.getStatus());
            c.setDateCreated(c.getDateCreated());
            c.setDateUpdated(LocalDateTime.now());
            c.setUrl(content.getUrl());
            contentRepository.save(c);
            return "Content updated successfully";
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
        }
    }

    @Override
    public void saveContent(Content content) {
        contentRepository.save(content);
    }

    @Override
    public Optional<Content> getContentById(int Id) {
        Optional<Content> content = contentRepository.findById(Id);
        return content;
    }

    @Override
    public List<Content> getContents() {
        List<Content> contents = contentRepository.findAll();
        return contents;
    }

    @Override
    public String deleteContentById(int Id) {
        contentRepository.deleteById(Id);
        return "The content was deleted successfully";
    }

    @Override
    public String deleteAllContents() {
        contentRepository.deleteAll();
        return "All contents deleted successfully";
    }
}
