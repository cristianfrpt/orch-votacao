package cristianfrpt.orchvotacao.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Builder
@Data
@ToString
public class DadosSessao {
    private Integer idPauta;
    private Timestamp dtHrEncerramento;
}
