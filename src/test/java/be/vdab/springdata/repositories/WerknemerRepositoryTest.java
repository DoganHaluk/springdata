package be.vdab.springdata.repositories;

import be.vdab.springdata.domain.Filiaal;
import be.vdab.springdata.domain.Werknemer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Sql({"/insertFilialen.sql", "/insertWerknemers.sql"})
class WerknemerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String WERKNEMERS = "werknemers";
    private final WerknemerRepository repository;

    WerknemerRepositoryTest(WerknemerRepository repository) {
        this.repository = repository;
    }

    @Test
    void findByFiliaalGemeente() {
        var antwerpen = "Antwerpen";
        assertThat(repository.findByFiliaalGemeente(antwerpen))
                .hasSize(countRowsInTableWhere(WERKNEMERS, "filiaalId = (select id from filialen where gemeente = 'Antwerpen')"))
                .first()
                .extracting(Werknemer::getFiliaal)
                .extracting(Filiaal::getGemeente)
                .isEqualTo(antwerpen);
    }
}
