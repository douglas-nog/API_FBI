package br.com.fiap.security.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "crime")
@Table(name = "tb_crime")
@Getter
@Setter
public class Crime {

    @Id
    @SequenceGenerator(name = "crime", sequenceName = "CRIME", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crime")
    @Column(name = "id_crime")
    private Long id;

    private String descricaoDoCrime;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate dataDoCrime;

    @ManyToOne
    @JoinColumn(name = "id_procurado", nullable = false)
    private Procurado procurado;

}

