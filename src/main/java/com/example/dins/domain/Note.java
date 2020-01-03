package com.example.dins.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Note extends AbstractEntity {
    private String number;

    public Note(String name, String number) {
        super(name);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return getNumber().equals(note.getNumber()) &&
                getName().equalsIgnoreCase(note.getName()) &&
                getId() == note.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
