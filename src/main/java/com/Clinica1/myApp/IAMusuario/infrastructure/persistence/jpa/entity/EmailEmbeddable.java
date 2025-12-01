package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailEmbeddable {
    @Column(nullable = false)
    private String email_valor;

    //equals y hashcode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmailEmbeddable that = (EmailEmbeddable) o;
        return Objects.equals(getEmail_valor(), that.getEmail_valor());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEmail_valor());
    }

    @Override
    public String toString() {
        return email_valor;
    }
}
