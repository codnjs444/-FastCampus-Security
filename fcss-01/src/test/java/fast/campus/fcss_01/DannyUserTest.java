package fast.campus.fcss_01;

import fast.campus.fcss_01.user.DannyUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Optional;

class DannyUserTest {

    @Test
    void dannyUserTest() {
        DannyUser danny = new DannyUser();

        Assertions.assertThat(danny.getUsername()).isEqualTo("danny.kim");
        Assertions.assertThat(danny.getPassword()).isEqualTo("12345");
        Assertions.assertThat(danny.getAuthorities().size()).isEqualTo(1);

        Optional<? extends GrantedAuthority> read = danny.getAuthorities()
                .stream()
                .filter(authority -> authority.getAuthority().equals("READ"))
                .findFirst();
        read.ifPresent(each -> Assertions.assertThat(each.getAuthority()).isEqualTo("READ"));
    }
}