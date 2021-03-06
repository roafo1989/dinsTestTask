package com.example.dins.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {
    private Integer id;
    private String name;
    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }
    public AbstractEntity(String name) {
        this.name = name;
    }
}
