package cristianfrpt.orchvotacao.domain.mapper;

import cristianfrpt.orchvotacao.domain.entity.Voto;
import cristianfrpt.orchvotacao.domain.enums.SimNaoEnum;
import cristianfrpt.orchvotacao.domain.request.VotoRequest;
import cristianfrpt.orchvotacao.util.Util;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VotoMapper {
    public static Voto toEntity(VotoRequest request){
        return Voto.builder()
                .idSessao(request.getIdSessao())
                .cpfAssociado(request.getCpfAssociado())
                .voto(SimNaoEnum.fromName(validaVoto(request.getVoto())).getCode())
                .build();
    }

    private static String validaVoto(String voto){
        String votoMaiusculo = Util.removerCaracteresEspeciais(voto).toUpperCase();
        if(!votoMaiusculo.equals("SIM") && !votoMaiusculo.equals("NAO"))
            throw new RuntimeException();

        return votoMaiusculo;
    }
}