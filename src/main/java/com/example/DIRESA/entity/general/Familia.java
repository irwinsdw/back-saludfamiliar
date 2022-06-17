package com.example.DIRESA.entity.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.example.DIRESA.entity.empleado.Distrito;
import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.Establecimiento;

import java.time.LocalDate;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="familia")
@EqualsAndHashCode
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numero_historia", nullable = false, length = 100)
    private String numeroHistoria;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    @Column(name = "asentamiento_humano", nullable = false, length = 100)
    private String asentamientoHumano;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "lote", nullable = false, length = 100)
    private String lote;

    @Column(name = "manzana", nullable = false, length = 100)
    private String manzana;

    @Column(name = "referencia", nullable = false, length = 100)
    private String referencia;

    @Column(name = "sub_sector", nullable = false, length = 100)
    private String subSector;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_titular")
    private Empleado titular;
}