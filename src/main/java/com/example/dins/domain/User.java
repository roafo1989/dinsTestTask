package com.example.dins.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractEntity {
    private String email;
    private List<Note> notes;

    public User(String name, String email){
        super(name);
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) &&
                getNotes().equals(user.getNotes()) &&
                getName().equalsIgnoreCase(user.getName()) &&
                getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getNotes());
    }
}
