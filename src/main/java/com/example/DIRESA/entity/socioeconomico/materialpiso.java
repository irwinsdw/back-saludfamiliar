package com.example.DIRESA.entity.socioeconomico;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.DIRESA.entity.empleado.Microred;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="materialpiso")
@EqualsAndHashCode
public class materialpiso implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    

    @Column(name = "materialpiso", nullable = false, length = 100)
    private String materialpiso;
 
    @ManyToMany
    @JoinTable(name = "socieconomico_familiar", joinColumns = @JoinColumn(name = "id_familia", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_", referencedColumnName = "id"))

    private Set<materialparedes> socioeconomicosfamiliares = new HashSet<>();

}
