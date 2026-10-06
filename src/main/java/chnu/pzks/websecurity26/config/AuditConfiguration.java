/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 07.10.2026
 * Course: Spring Security
 * Task №4. CSRF & Audit
 */

package chnu.pzks.websecurity26.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
