import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class media_mapper_credentialsTest {
    media_mapper_credentials test = new media_mapper_credentials();
    @Test
    void createUser() {
        assertAll(() ->
        assertEquals(0, test.CreateUser("river", "river")),
                () -> assertEquals(1, test.CreateUser("river", "river")));
    }

}