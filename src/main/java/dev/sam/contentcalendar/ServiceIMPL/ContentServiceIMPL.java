package dev.sam.contentcalendar.ServiceIMPL;

import dev.sam.contentcalendar.DTOs.ContentDTO;
import dev.sam.contentcalendar.Model.Content;
import dev.sam.contentcalendar.Repository.ContentRepository;
import dev.sam.contentcalendar.Service.ContentService;
import dev.sam.contentcalendar.Utilities.Slugger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceIMPL implements ContentService {


    private final ContentRepository contentRepository;
    private final Slugger slugger;

    public ContentServiceIMPL(ContentRepository contentRepository, Slugger slugger) {
        this.contentRepository = contentRepository;
        this.slugger = slugger;
    }

    @Override
    public String updateContent(ContentDTO content, int Id) {
        if(contentRepository.existsById(Id)){
            Content c = contentRepository.findById(Id).get();
            c.setTitle(content.getTitle());
            c.setDesc(content.getDesc());
            c.setStatus(content.getStatus());
            c.setDateCreated(c.getDateCreated());
            c.setDateUpdated(LocalDateTime.now());
            c.setUrl(slugger.urlSlugify(content.getTitle()));
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
        if(contentRepository.existsById(Id)){
            return "Content deleted successfully";
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
        }
    }

    @Override
    public String deleteAllContents() {
        contentRepository.deleteAll();
        return "All contents deleted successfully";
    }


}
