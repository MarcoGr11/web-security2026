/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 07.10.2026
 * Course: Spring Security
 * Task №4. CSRF & Audit
 */

package chnu.pzks.websecurity26.repository;

import chnu.pzks.websecurity26.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
