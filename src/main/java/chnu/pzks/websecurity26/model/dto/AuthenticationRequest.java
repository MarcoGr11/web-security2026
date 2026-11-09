/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 09.11.2026
 * Course: Spring Security
 * Task №8. JWT
 */

package chnu.pzks.websecurity26.model.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;
}
