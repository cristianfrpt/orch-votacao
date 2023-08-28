package cristianfrpt.orchvotacao.domain.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CalculoPautaResponse {
    Integer idSessao;
    Integer resultado;
}
