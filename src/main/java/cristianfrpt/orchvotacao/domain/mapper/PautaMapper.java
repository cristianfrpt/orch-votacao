package cristianfrpt.orchvotacao.domain.mapper;

import cristianfrpt.orchvotacao.domain.entity.Pauta;
import cristianfrpt.orchvotacao.domain.request.PautaRequest;
import cristianfrpt.orchvotacao.util.Util;

public class PautaMapper {
    public static Pauta toEntity(PautaRequest request){
        return Pauta.builder()
                .nome(Util.removerCaracteresEspeciais(request.getNome()))
                .build();
    }

}