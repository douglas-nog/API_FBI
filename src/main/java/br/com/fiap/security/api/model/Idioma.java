package br.com.fiap.security.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "idioma")
@Table(name = "tb_idioma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Idioma {

    @Id
    @SequenceGenerator(name = "idioma", sequenceName = "SQ_IDIOMA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idioma")
    @Column(name = "id_idioma")
    private Long id;

    @NotBlank
    @Column(name = "ds_idioma")
    private String idioma;

    @ManyToMany
    @JoinTable(name = "procurado_idioma",
            joinColumns = @JoinColumn(name = "id_procurado"),
            inverseJoinColumns = @JoinColumn(name = "id_idioma"))
    private Set<Idioma> idiomas = new HashSet<>();

}
