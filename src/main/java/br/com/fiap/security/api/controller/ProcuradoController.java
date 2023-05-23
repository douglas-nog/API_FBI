package br.com.fiap.security.api.controller;

import br.com.fiap.security.api.model.Procurado;
import br.com.fiap.security.api.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("procurado")
public class ProcuradoController {

    @Autowired
    private ProcuradoRepository procuradoRepository;

//    @GetMapping("/{nome}")
//    public Procurado getProcurado(@PathVariable("nome") String nome) {
//        return procuradoRepository.findByNome(nome);
//    }

//    @GetMapping("/{nome}")
//    public ResponseEntity buscar(@PathVariable String nome) {
//        var resultSearchOne = procuradoRepository.findByNome(nome);
//        return ResponseEntity.ok(resultSearchOne);
//    }


    @GetMapping("/{id}")
    public ResponseEntity getProcurado(@PathVariable Long id) {
        var resultSearchOne = procuradoRepository.findById(id).get();
        return ResponseEntity.ok(resultSearchOne);
    }
}
