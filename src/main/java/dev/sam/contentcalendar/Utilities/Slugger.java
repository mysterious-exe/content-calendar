package dev.sam.contentcalendar.Utilities;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Slugger {
    public String urlSlugify(String title){
        return title.toLowerCase().replaceAll("\\s+","-");
    }
}
