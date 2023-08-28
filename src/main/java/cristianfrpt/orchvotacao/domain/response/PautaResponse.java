package cristianfrpt.orchvotacao.domain.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class PautaResponse {
    Integer idPauta;
    String nome;
}
