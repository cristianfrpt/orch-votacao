package cristianfrpt.orchvotacao.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SimNaoEnum {
    SIM(1,"SIM"),
    NAO(2,"NAO"),
    EMPATE(3,"EMPATE");

    private final Integer code;
    private final String name;

    public static SimNaoEnum fromCode(Integer code) {
        for (SimNaoEnum value : SimNaoEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public static SimNaoEnum fromName(String text) {
        for (SimNaoEnum value : SimNaoEnum.values()) {
            if (String.valueOf(value.name).equals(text)) {
                return value;
            }
        }
        return null;
    }

}
