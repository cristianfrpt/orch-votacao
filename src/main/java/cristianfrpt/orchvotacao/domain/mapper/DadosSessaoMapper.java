package cristianfrpt.orchvotacao.domain.mapper;

import cristianfrpt.orchvotacao.domain.entity.DadosSessao;
import cristianfrpt.orchvotacao.domain.request.AbrirVotacaoRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DadosSessaoMapper {
    public static DadosSessao toEntity(AbrirVotacaoRequest request){
        return DadosSessao.builder()
                .idPauta(request.getIdPauta())
                .dtHrEncerramento(configuraTimeout(request.getTimeoutPauta()))
                .build();
    }

    private static Timestamp configuraTimeout(Integer timeoutParam) {
        int realTimeout = timeoutParam == null ? 60 : timeoutParam;

        Timestamp dtHrEncerramento = Timestamp.valueOf(LocalDateTime.now().plus(realTimeout, ChronoUnit.SECONDS));;

        return dtHrEncerramento;
    }

}
