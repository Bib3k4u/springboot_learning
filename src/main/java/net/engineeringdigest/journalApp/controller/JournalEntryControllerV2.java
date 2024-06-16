package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/journal")
class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllEntry();
    }


    @PostMapping
    public JournalEntry addEntry(@RequestBody JournalEntry newEntry){
        newEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(newEntry);
        return newEntry;
    }

    @GetMapping("id/{jid}")
    public JournalEntry getJournalById(@PathVariable ObjectId jid){
        return journalEntryService.findById(jid).orElse(null);
    }

    @DeleteMapping("id/{jid}")
    public boolean DeleteJournalById(@PathVariable ObjectId jid){
         journalEntryService.deleteById(jid);
         return true;
    }

    @PutMapping("id/{jid}")
    public JournalEntry updateJournalById(@PathVariable ObjectId jid, @RequestBody JournalEntry newEntry ){
        JournalEntry old = journalEntryService.findById(jid).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }


}
