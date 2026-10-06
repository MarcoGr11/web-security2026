/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 07.10.2026
 * Course: Spring Security
 * Task №4. CSRF & Audit
 */

package chnu.pzks.websecurity26.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin");
    }
}
