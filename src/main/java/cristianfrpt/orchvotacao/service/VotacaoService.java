package cristianfrpt.orchvotacao.service;


import cristianfrpt.orchvotacao.domain.entity.DadosSessao;
import cristianfrpt.orchvotacao.domain.entity.Pauta;
import cristianfrpt.orchvotacao.domain.entity.Voto;
import cristianfrpt.orchvotacao.domain.response.AbrirVotacaoResponse;
import cristianfrpt.orchvotacao.domain.response.CalculoPautaResponse;
import cristianfrpt.orchvotacao.domain.response.VotoResponse;
import cristianfrpt.orchvotacao.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import cristianfrpt.orchvotacao.domain.response.PautaResponse;
import cristianfrpt.orchvotacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VotacaoService {
    @Autowired
    PautaRepository pautaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public PautaResponse cadastrarPauta(Pauta pauta) {
        return pautaRepository.cadastrarPauta(pauta);
    }


    public AbrirVotacaoResponse abrirVotacao(DadosSessao dadosSessao) {
        return pautaRepository.abrirVotacao(dadosSessao);
    }


    public VotoResponse cadastrarVoto(Voto voto) {
        usuarioRepository.validaSituacaoCPF(voto.getCpfAssociado());

        return pautaRepository.cadastrarVoto(voto);
    }

    public CalculoPautaResponse buscarResultadoPauta(Integer idSessao) {
        return pautaRepository.buscarResultadoPauta(idSessao);
    }

}
