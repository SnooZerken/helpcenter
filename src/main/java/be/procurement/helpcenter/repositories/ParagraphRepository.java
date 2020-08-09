package be.procurement.helpcenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.procurement.helpcenter.models.Paragraph;
import be.procurement.helpcenter.models.Section;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
    
    List<Paragraph> findByBody(String body);
    List<Paragraph> findAll();

    List<Paragraph> findBySection(Section section);

}