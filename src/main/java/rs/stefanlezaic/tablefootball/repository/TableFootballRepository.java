package rs.stefanlezaic.tablefootball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import rs.plusplusnt.fullcircle.lib.exception.FullCircleEntityNotFoundException;
import rs.plusplusnt.fullcircle.lib.model.FullCircleEntity;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface TableFootballRepository<E extends FullCircleEntity<?>, ID> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

    Optional<E> findByUuid(String uuid);

    default E getByUuid(String uuid) {
        return findByUuid(uuid).orElseThrow(() -> getNotFoundException(uuid));
    }

    List<E> findByUuidIn(List<String> uuids);

    default FullCircleEntityNotFoundException getNotFoundException(String uuid) {
        return new FullCircleEntityNotFoundException();
    }
}
