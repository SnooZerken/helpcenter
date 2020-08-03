package be.procurement.helpcenter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
    
    List<Paragraph> findByBody(String body);
    List<Paragraph> findAll();

}