package com.example.DIRESA.entity.empleado;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="distrito")
@EqualsAndHashCode
public class Distrito implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    @JsonIgnoreProperties({"distritos","hibernateLazyInitializer", "handler"})
    private Provincia provincia;

}