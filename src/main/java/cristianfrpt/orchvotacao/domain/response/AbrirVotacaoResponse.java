package cristianfrpt.orchvotacao.domain.response;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class AbrirVotacaoResponse {
    Integer idSessao;
    Integer idPauta;
    String dtHrEncerramento;
}
