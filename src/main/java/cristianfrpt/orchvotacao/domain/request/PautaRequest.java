package cristianfrpt.orchvotacao.domain.request;

import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
@Validated
public class PautaRequest {
    @NotNull
    @NotEmpty
    String nome;
}
