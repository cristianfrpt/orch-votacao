package cristianfrpt.orchvotacao.repository;

import cristianfrpt.orchvotacao.domain.entity.DadosSessao;
import cristianfrpt.orchvotacao.domain.entity.Pauta;
import cristianfrpt.orchvotacao.domain.entity.Voto;
import cristianfrpt.orchvotacao.domain.response.AbrirVotacaoResponse;
import cristianfrpt.orchvotacao.domain.response.PautaResponse;
import cristianfrpt.orchvotacao.domain.response.CalculoPautaResponse;
import cristianfrpt.orchvotacao.domain.response.VotoResponse;
import org.springframework.stereotype.Repository;


@Repository
public interface PautaRepository {
    PautaResponse cadastrarPauta(Pauta pauta);
    AbrirVotacaoResponse abrirVotacao(DadosSessao dadosSessao);
    CalculoPautaResponse buscarResultadoPauta(Integer idPauta);
    VotoResponse cadastrarVoto(Voto voto);
}
