package cristianfrpt.orchvotacao.controller;

import cristianfrpt.orchvotacao.domain.mapper.DadosSessaoMapper;
import cristianfrpt.orchvotacao.domain.mapper.ResultadoPautaMapper;
import cristianfrpt.orchvotacao.domain.request.AbrirVotacaoRequest;
import cristianfrpt.orchvotacao.domain.request.VotoRequest;
import cristianfrpt.orchvotacao.domain.mapper.PautaMapper;
import cristianfrpt.orchvotacao.domain.mapper.VotoMapper;
import lombok.extern.slf4j.Slf4j;
import cristianfrpt.orchvotacao.domain.request.PautaRequest;
import cristianfrpt.orchvotacao.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Slf4j
@RestController
@Validated
public class VotacaoController {

    @Autowired
    VotacaoService service;

    @PostMapping(value = "/v1/cadastrarPauta")
    @ResponseBody
    public ResponseEntity<?> cadastrarPauta(@Valid @RequestBody @NotNull PautaRequest pautaRequest) {
        log.info("Iniciando cadastro da pauta: {}", pautaRequest);

        try {
            return ResponseEntity.ok(service.cadastrarPauta(PautaMapper.toEntity(pautaRequest)));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/v1/abrirVotacao")
    @ResponseBody
    public ResponseEntity<?> abrirVotacao(@Valid @RequestBody @NotNull AbrirVotacaoRequest dadosAbertura) {
        log.info("Iniciando abertura da pauta: {}", dadosAbertura);

        try {
            return ResponseEntity.ok(service.abrirVotacao(DadosSessaoMapper.toEntity(dadosAbertura)));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/v1/cadastrarVoto")
    @ResponseBody
    public ResponseEntity<?> cadastrarVoto(@Valid @RequestBody @NotNull VotoRequest voto) {
        log.info("Iniciando cadastro de voto: {}",voto);

        try {
            return ResponseEntity.ok(service.cadastrarVoto(VotoMapper.toEntity(voto)));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/v1/resultadoPauta/{idSessao}")
    @ResponseBody
    public ResponseEntity<?> buscarResultado(@Valid @PathVariable @Positive Integer idSessao) {
        log.info("Buscando resultado da pauta de id: {}", idSessao);

        try {
            return ResponseEntity.ok(ResultadoPautaMapper.toResponse(service.buscarResultadoPauta(idSessao)));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
