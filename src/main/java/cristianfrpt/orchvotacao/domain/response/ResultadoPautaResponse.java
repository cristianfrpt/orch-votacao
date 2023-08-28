package cristianfrpt.orchvotacao.domain.response;

import lombok.*;


@Data
@Builder
@ToString
public class ResultadoPautaResponse {
    Integer idSessao;
    String resultado;
}
