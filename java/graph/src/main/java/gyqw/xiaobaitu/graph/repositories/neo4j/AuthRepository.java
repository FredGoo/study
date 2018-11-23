package gyqw.xiaobaitu.graph.repositories.neo4j;

import gyqw.xiaobaitu.graph.domain.neo4j.Auth;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author fred
 * 2018-11-23 10:40 AM
 */
@RepositoryRestResource(collectionResourceRel = "auths", path = "auths")
public interface AuthRepository extends Neo4jRepository<Auth, Long> {
}
