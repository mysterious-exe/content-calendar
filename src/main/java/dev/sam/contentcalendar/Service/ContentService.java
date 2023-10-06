package dev.sam.contentcalendar.Service;

import dev.sam.contentcalendar.Model.Content;
import dev.sam.contentcalendar.Model.Status;

import java.util.List;
import java.util.Optional;

public interface ContentService {

    String updateContent(Content content, int Id);
    void saveContent(Content content);
    Optional<Content> getContentById(int Id);
    List<Content> getContents();
    String deleteContentById(int Id);

    String deleteAllContents();


}
