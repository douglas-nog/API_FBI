package br.com.fiap.security.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name = "apelidoProcurado")
@Table(name = "tb_apelido_procurado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApelidoProcurado {

    @Id
    @SequenceGenerator(name = "apelido", sequenceName = "SQ_APELIDO_PROCURADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apelido")
    @Column(name = "id_apelido")
    private Long id;

    @NotBlank
    @Column(name = "ds_apelido")
    private String apelido;

    @ManyToOne
    @JoinColumn(name = "id_procurado", referencedColumnName = "id_procurado", nullable = false)
    @JsonIgnore
    private Procurado procurado;

}
