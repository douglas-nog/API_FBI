package br.com.fiap.security.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "procurado")
@Table(name = "tb_procurado")
@Getter
@Setter
public class Procurado {

    @Id
    @SequenceGenerator(name = "procurado", sequenceName = "SQ_PROCURADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "procurado")
    @Column(name = "id_procurado")
    private Long id;

    @NotBlank
    @Column(name = "nm_procurado")
    private String nome;

    @NotBlank
    @Column(name = "ds_genero")
    private String genero;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "ds_orgao_seguranca")
    private OrgaoSeguraca orgaoSeguranca;

    @Column(name = "ds_nacionalidade")
    private String nacionalidade;

    @Column(name = "ds_cidade")
    private String cidade;

    @Column(name = "nr_peso")
    private Double peso;

    @Column(name = "ds_olhos")
    private String corOlhos;

    @Column(name = "ds_cabelo")
    private String corCabelo;

    @Column(name = "ds_raca")
    private String raca;

    @Column(name = "nr_altura")
    private String altura;

    @Column(name = "ds_cicatrizes")

    private String cicatrizes;

    @Column(name = "ds_profissao")
    private String profissao;

    @Column(name = "vl_recompensa")
    private Double recompensa;

    @OneToMany
    private List<Crime> crimes;

    @OneToMany
    private List<ApelidoProcurado> apelidoProcurados;

    @OneToMany
    private List<DocumentoProcurado> documentoProcurados;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "id_procurado"),
            inverseJoinColumns = @JoinColumn(name = "id_idioma"))
    private Set<Idioma> idiomas = new HashSet<>();

}
