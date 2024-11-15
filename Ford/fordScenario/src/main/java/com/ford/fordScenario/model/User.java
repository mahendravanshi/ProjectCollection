package com.ford.fordScenario.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@Table(name="user_table")
public class User {

    @Id
    private UUID id;

    private String fullName;

    @CreationTimestamp
    private LocalDate registeredDate;

    private Integer totalRides;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(fullName, user.fullName) && Objects.equals(registeredDate, user.registeredDate) && Objects.equals(totalRides, user.totalRides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, registeredDate, totalRides);
    }
}
