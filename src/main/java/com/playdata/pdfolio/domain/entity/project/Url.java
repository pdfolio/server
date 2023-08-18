package com.playdata.pdfolio.domain.entity.project;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Url {

    @Column
    private String url;

    private Url(String url) {
        this.url = url;
    }

    public static Url from(final String url) {
        return new Url(url);
    }
}
