package be.vdab.springdata.repositories;

import be.vdab.springdata.domain.Filiaal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FiliaalRepository extends JpaRepository<Filiaal, Long> {
    long count();

    Optional<Filiaal> findById(long id);

    List<Filiaal> findAll();

    void deleteById(long id);

    List<Filiaal> findByGemeente(String gemeente);
}
