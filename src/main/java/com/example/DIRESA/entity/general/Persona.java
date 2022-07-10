package com.example.DIRESA.entity.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



import com.example.DIRESA.entity.empleado.Clasificacionriesgo;
import com.example.DIRESA.entity.empleado.Empleado;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="persona")
@EqualsAndHashCode
public class Persona {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "id_familia")
	    private Familia familia;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "dni", nullable = false, length = 12)
    private String dni;

    @Column(name = "seguro", nullable = false, length = 100)
    private String seguro;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "parentesco", nullable = false, length = 100)
    private String parentesco;

    @Column(name = "genero", nullable = false, length = 100)
    private String genero;

    @Column(name = "estado_civil", nullable = false, length = 100)
    private String estadoCivil;

    @Column(name = "estudios", nullable = false, length = 100)
    private String estudios;

    @Column(name = "clasificacion_riesgo", nullable = false, length = 100)
    private String clasificacionRiesgo;

    @Column(name = "idioma", nullable = false, length = 100)
    private String idioma;

    @Column(name = "religion", nullable = false, length = 100)
    private String religion;

    @Column(name = "pertenencia_etnica", nullable = false, length = 100)
    private String pertenenciaEtnica;

    @Column(name = "ocupacion", nullable = false, length = 100)
    private String ocupacion;
    
    //@JoinTable(name = "persona_riesgos" es el nombre para darle a la tabla combinada que se creara 
    @ManyToMany
    @JoinTable(name = "persona_riesgos", joinColumns = @JoinColumn(name = "id_persona", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_clasificacionriesgo", referencedColumnName = "id"))
    private Set<Clasificacionriesgo> riesgospersonas = new HashSet<>();

}