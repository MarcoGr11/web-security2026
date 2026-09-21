/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 21.09.2026
 * Course: Spring Security
 * Task №1. Simple web-application
 */

package chnu.pzks.websecurity26.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private String id;
    private String name;
    private String description;
    private String author;
    private int year;
}
