package br.com.fiap.security.api.controller;

import br.com.fiap.security.api.model.Crime;
import br.com.fiap.security.api.model.Procurado;
import br.com.fiap.security.api.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("procurado")
public class ProcuradoController {

    @Autowired
    private ProcuradoRepository procuradoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Procurado> getProcurado(@PathVariable Long id) {
        var resultSearchOne = procuradoRepository.findById(id).orElse(null);
        if (resultSearchOne != null) {
            return ResponseEntity.ok(resultSearchOne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Procurado> buscarPorNome(@RequestParam("nome") String nome) {
        Optional<Procurado> procurado = Optional.ofNullable(procuradoRepository.findByNomeContaining(nome));
        if (procurado.isPresent()) {
            return ResponseEntity.ok(procurado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
