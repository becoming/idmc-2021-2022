package fr.unilorraine.idmc.gamescatalog.config;

import fr.unilorraine.idmc.gamescatalog.core.MD5Checker;
import fr.unilorraine.idmc.gamescatalog.core.SHA256Checker;
import fr.unilorraine.idmc.gamescatalog.core.UserDetailsServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static fr.unilorraine.idmc.gamescatalog.config.UsersStorage.DB;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityProperties properties;
    private final UserDetailsServiceFactory detailsFactory;

    @Override
    //noformat
    protected void configure(HttpSecurity http) throws Exception {
        // https://stackoverflow.com/a/14020466/1107450
        // jetbrains://idea/settings?name=Editor--Code+Style
        // Enable format markers
        //@formatter:off
        http
                .csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/actuator/info").permitAll()
                .antMatchers("/actuator/health").permitAll()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/v1.yml").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/games").authenticated()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic();
        // https://dzone.com/articles/spring-security-authentication
        if (properties.getStorage() == DB) {
            //final var authProvider = new DBAuthProvider(detailsFactory.inDb(), new MD5Checker());
            final var authProvider = new DBAuthProvider(detailsFactory.inDb(), new SHA256Checker());
            http.authenticationProvider(authProvider);
        } else {
            http.userDetailsService(detailsFactory.inMemory());
        }

        http.httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(OPTIONS, "/**")
                .antMatchers(GET, "/favicon.ico");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Bean
    @Override
    // https://docs.spring.io/spring-security/site/docs/4.2.15.RELEASE/apidocs/org/springframework/security/core/userdetails/User.html#withDefaultPasswordEncoder--
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}