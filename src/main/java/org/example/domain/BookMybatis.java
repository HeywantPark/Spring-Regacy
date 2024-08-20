package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@Builder
public class BookMybatis {
    private Long id;
    private String title;
    private String author;

    public BookMybatis(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
