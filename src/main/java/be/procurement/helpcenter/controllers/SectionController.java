package be.procurement.helpcenter.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.procurement.helpcenter.models.Paragraph;
import be.procurement.helpcenter.models.Section;
import be.procurement.helpcenter.repositories.SectionRepository;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionRepository repository;   
     

    @GetMapping
    public ResponseEntity<List<Section>> findAll(@RequestParam(required = false) String title) {

        List<Section> sections = new ArrayList<Section>();

        if (title == null)
            repository.findAll().forEach(sections::add);
        else
            repository.findByTitleContainingIgnoreCase(title).forEach(sections::add);

        if (sections.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Section>>(sections, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Optional<Section> findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
 
    @CrossOrigin(origins = "*") 
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Section create(@RequestBody Section resource) {
        Preconditions.checkNotNull(resource);
        return repository.save(resource);
    }
 
    @CrossOrigin(origins = "*") 
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Section update(@PathVariable( "id" ) Long id, @RequestBody Section resource) {
        Preconditions.checkNotNull(resource);       
        Section p = (repository.findById(id)).get();
        
        p.setTitle(resource.getTitle());

        return repository.save(p); 
    }
 
    @CrossOrigin(origins = "*") 
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
    
    @GetMapping(value = "/{id}/paragraphs")
    public List<Paragraph> findParagraphs(@PathVariable("id") Long id){
        Section section = repository.findById(id).get();
        return section.getParagraphs();

    }
    
    
}