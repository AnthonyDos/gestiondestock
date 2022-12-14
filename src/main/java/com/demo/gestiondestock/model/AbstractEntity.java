package com.demo.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // va automatique écouter les champs date et les mettre à jour en bdd
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "creationDate", nullable = false)
    @JsonIgnore
    private Instant createDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    @JsonIgnore
    private Instant lastModifiedDate;
}
