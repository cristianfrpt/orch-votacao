package cristianfrpt.orchvotacao.repository.impl;

import cristianfrpt.orchvotacao.domain.exception.UsuarioException;
import cristianfrpt.orchvotacao.domain.response.ValidaCpfResponse;
import cristianfrpt.orchvotacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
    private final String atomUsuarioUrl;
    private final RestTemplate restTemplate;


    public UsuarioRepositoryImpl(@Value("${url.atom.usuario}") String atomUsuarioUrl,
                                         RestTemplate restTemplate) {
        this.atomUsuarioUrl = atomUsuarioUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public void validaSituacaoCPF(String cpf) throws UsuarioException {
        log.info("Inicio da chamada ao serviço validaCPF para o cpf: {}", cpf);

        String URI = atomUsuarioUrl + cpf;
        ValidaCpfResponse response = restTemplate.getForObject(URI, ValidaCpfResponse.class);

        if(response != null)
            if(response.getStatus().equalsIgnoreCase("UNABLE_TO_VOTE"))
                throw new UsuarioException("O CPF informado não está apto a votar");
    }
}
