package be.procurement.helpcenter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paragraph {
    
    private long id;  
    private String body;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "body", nullable = false, length=4048)
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Paragraph(String body) {
        this.body = body;
    }

    public Paragraph(){
        this.body = "no value";
    }

    @Override
    public String toString() {
        return "Paragraph [body=" + body + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paragraph other = (Paragraph) obj;
        if (body == null) {
            if (other.body != null)
                return false;
        } else if (!body.equals(other.body))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

}