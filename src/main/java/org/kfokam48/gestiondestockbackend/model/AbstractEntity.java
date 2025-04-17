package org.kfokam48.gestiondestockbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


@Data
@Builder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @JsonIgnore
    private Instant createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Instant lastModifiedDate;
}
