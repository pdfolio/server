package com.playdata.pdfolio.domain.dto.gather;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SearchDto {
    private String title;
    private String content;
    private Boolean isDone;
    private Integer likeGoe;
    private Integer likeLoe;
}
