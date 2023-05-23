package br.com.fiap.security.api.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "documentoProcurado")
@Table(name = "tb_documento_procurado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoProcurado {

    @Id
    @SequenceGenerator(name = "documento", sequenceName = "SQ_DOCUMENTO_PROCURADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento")
    @Column(name = "id_documento_procurado")
    private Long id;

    private String paisEmissor;

    private String tipoDeDocumento;

    private String numeroDocumento;


    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_procurado", referencedColumnName = "id_procurado", nullable = false)
    @JsonIgnore
    private Procurado procurado;


}
