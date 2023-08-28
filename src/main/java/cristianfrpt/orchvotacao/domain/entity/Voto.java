package cristianfrpt.orchvotacao.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Voto {
    private Integer idSessao;
    private String cpfAssociado;
    private Integer voto;
}
