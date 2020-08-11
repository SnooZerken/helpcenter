package be.procurement.helpcenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.procurement.helpcenter.models.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    
    List<Section> findByTitleContainingIgnoreCase(String title);    
    List<Section> findAll();

}