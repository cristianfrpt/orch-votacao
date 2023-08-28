package cristianfrpt.orchvotacao.domain.request;

import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@ToString
@Validated
public class AbrirVotacaoRequest {
    @NotNull
    @Min(value = 1)
    Integer idPauta;
    @Positive
    Integer timeoutPauta;
}
