package be.procurement.helpcenter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Paragraph {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private long id;  

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "body", nullable = false, length=4048)
    private String body;
    
    @Column(name = "weight")
    private int weight;
    
    @JsonBackReference
    @ManyToOne(optional = false)
    private Section section;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }    

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }    

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

}