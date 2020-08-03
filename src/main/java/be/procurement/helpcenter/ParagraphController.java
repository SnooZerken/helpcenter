package be.procurement.helpcenter;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paragraphs")
class ParagraphController {

    @Autowired
    private ParagraphRepository repository;

    @GetMapping
    public List<Paragraph> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Paragraph> findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paragraph create(@RequestBody Paragraph resource) {
        Preconditions.checkNotNull(resource);
        return repository.save(resource);
    }
 
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Paragraph update(@PathVariable( "id" ) Long id, @RequestBody Paragraph resource) {
        Preconditions.checkNotNull(resource);       
        Paragraph p = (repository.findById(id)).get();
        
        p.setBody(resource.getBody());

        return repository.save(p); 
    }
 
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
 
}