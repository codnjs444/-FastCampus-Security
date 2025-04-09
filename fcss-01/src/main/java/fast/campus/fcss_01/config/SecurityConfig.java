package fast.campus.fcss_01.config;

import fast.campus.fcss_01.service.InMemoryUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    /* InMemory 방법 활용 */
    /*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails danny = User.withUsername("danny.kim")
                .password("12345")
                .build();
        UserDetails steve = User.withUsername("steve.kim")
                .password("12345")
                .build();
        UserDetails harris = User.withUsername("harris.kim")
                .password("12345")
                .build();
        List<UserDetails> users = List.of(danny, steve, harris);
        return new InMemoryUserDetailService(users);
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
