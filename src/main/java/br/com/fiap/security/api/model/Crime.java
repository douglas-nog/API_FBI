package br.com.fiap.security.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "crime")
@Table(name = "tb_crime")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private Procurado procurado;

}

