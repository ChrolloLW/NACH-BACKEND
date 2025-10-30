package pe.nach.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import pe.nach.infrastructure.security.JwtAuthenticationFilter;

// Legacy security config kept for reference — not registered as a Spring bean.
public class LegacySecurityConfig {

    // Intentionally left inert. The canonical SecurityConfig is in package pe.nach.infrastructure.config

}