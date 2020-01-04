package com.example.dins.domain;

import lombok.AllArgsConstructor;
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
    public User(String name, String email){
        super(name);
        this.email = email;
    }

    public User(Integer id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) &&
                getName().equalsIgnoreCase(user.getName()) &&
                getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
