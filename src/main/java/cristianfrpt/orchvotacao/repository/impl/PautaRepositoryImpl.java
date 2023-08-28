package cristianfrpt.orchvotacao.repository.impl;

import cristianfrpt.orchvotacao.domain.entity.DadosSessao;
import cristianfrpt.orchvotacao.domain.entity.Pauta;
import cristianfrpt.orchvotacao.domain.entity.Voto;
import cristianfrpt.orchvotacao.domain.response.AbrirVotacaoResponse;
import cristianfrpt.orchvotacao.domain.response.PautaResponse;
import cristianfrpt.orchvotacao.domain.response.CalculoPautaResponse;
import cristianfrpt.orchvotacao.domain.response.VotoResponse;
import cristianfrpt.orchvotacao.repository.PautaRepository;
import cristianfrpt.orchvotacao.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class PautaRepositoryImpl implements PautaRepository {
    private final String atomPautaUrl;
    private final RestTemplate restTemplate;


    public PautaRepositoryImpl(@Value("${url.atom.pauta}") String atomPautaUrl,
                                 RestTemplate restTemplate) {
        this.atomPautaUrl = atomPautaUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public PautaResponse cadastrarPauta(Pauta pauta){
        String URI = atomPautaUrl + "v1/cadastrarPauta";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(List.of(StandardCharsets.UTF_8));

        ResponseEntity<PautaResponse> response = restTemplate.postForEntity(URI,new HttpEntity<>(Util.toJson(pauta),headers), PautaResponse.class);
        log.info("cadastrarPauta statusCode: {}", response.getStatusCode());

        return response.getBody();
    }

    @Override
    public AbrirVotacaoResponse abrirVotacao(DadosSessao dadosSessao) {
        String URI = atomPautaUrl + "v1/abrirVotacao";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(List.of(StandardCharsets.UTF_8));

        ResponseEntity<AbrirVotacaoResponse> response = restTemplate.postForEntity(URI,new HttpEntity<>(Util.toJson(dadosSessao),headers), AbrirVotacaoResponse.class);
        log.info("abrirVotacao statusCode");
        log.info("abrirVotacao response {}", response);

        return response.getBody();
    }
    @Override
    public VotoResponse cadastrarVoto(Voto voto){
        String URI = atomPautaUrl + "v1/cadastrarVoto";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(List.of(StandardCharsets.UTF_8));

        ResponseEntity<VotoResponse> response = restTemplate.postForEntity(URI,new HttpEntity<>(Util.toJson(voto),headers), VotoResponse.class);
        log.info("cadastrarVoto statusCode: {}", response.getStatusCode());

        return response.getBody();
    }

    @Override
    public CalculoPautaResponse buscarResultadoPauta(Integer idSessao) {
        String URI = atomPautaUrl + "v1/resultadoSessao/" +idSessao;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setAcceptCharset(List.of(StandardCharsets.UTF_8));

        ResponseEntity<CalculoPautaResponse> response = restTemplate.getForEntity(URI, CalculoPautaResponse.class);
        log.info("buscarResultadoPauta statusCode: {}", response.getStatusCode());

        return response.getBody();
    }
}