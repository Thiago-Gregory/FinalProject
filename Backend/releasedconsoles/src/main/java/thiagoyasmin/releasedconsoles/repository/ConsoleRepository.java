package thiagoyasmin.releasedconsoles.repository;

import org.springframework.data.repository.CrudRepository;
import thiagoyasmin.releasedconsoles.model.ConsoleEntity;

/**
 * @author Thiago Araújo
 * @author Yasmin Luzia
 * @since 01/05/2020
 * @version 1.0
 */

public interface ConsoleRepository extends CrudRepository<ConsoleEntity, Long> {

}
