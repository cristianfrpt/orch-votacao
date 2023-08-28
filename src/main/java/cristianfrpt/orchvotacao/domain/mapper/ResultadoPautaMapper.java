package cristianfrpt.orchvotacao.domain.mapper;

import cristianfrpt.orchvotacao.domain.enums.SimNaoEnum;
import cristianfrpt.orchvotacao.domain.response.CalculoPautaResponse;
import cristianfrpt.orchvotacao.domain.response.ResultadoPautaResponse;

public class ResultadoPautaMapper {

    public static ResultadoPautaResponse toResponse(CalculoPautaResponse response){
        return ResultadoPautaResponse.builder()
                .idSessao(response.getIdSessao())
                .resultado(SimNaoEnum.fromCode(response.getResultado()).getName())
                .build();
    }
}
