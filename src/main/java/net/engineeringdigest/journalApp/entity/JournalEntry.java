package net.engineeringdigest.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
public class JournalEntry {

    @Id
    String id;
    @NonNull
    public String title;
    public String content;
    public LocalDateTime date;

    
}
