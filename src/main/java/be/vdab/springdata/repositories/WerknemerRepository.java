package be.vdab.springdata.repositories;

import be.vdab.springdata.domain.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    List<Werknemer> findByFiliaalGemeente(String gemeente);
}
