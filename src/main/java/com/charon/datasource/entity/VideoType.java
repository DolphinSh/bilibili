package com.charon.datasource.entity;

import lombok.*;

@Data //Getter and Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoType {
    private Integer id;
    private String classify;
    private String description;

    public VideoType(Integer id) {
        this.id = id;
    }
}
