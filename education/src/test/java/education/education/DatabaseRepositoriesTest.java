package education.education;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DatabaseRepositoriesTest {

}
