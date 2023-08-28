package cristianfrpt.orchvotacao.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.util.StringUtils;

public class Util {

    public static String removerCaracteresEspeciais(String input) {
        if (input == null) {
            return null;
        } else if (StringUtils.trimAllWhitespace(input).isEmpty()) {
            return null;
        }
        return input
                .replaceAll("[ÀÁÂÃÄÅ]", "A")
                .replaceAll("[àáâãäå]", "a")
                .replaceAll("[ÈÉÊË]", "E")
                .replaceAll("[èéêë&]", "e")
                .replaceAll("[ÌÍÎÏ]", "I")
                .replaceAll("[ìíîï]", "i")
                .replaceAll("[ÒÓÔÕÖ]", "O")
                .replaceAll("[òóôõö]", "o")
                .replaceAll("[ÙÚÛÜ]", "U")
                .replaceAll("[ùúûü]", "u")
                .replaceAll("[Ç]", "C")
                .replaceAll("[ç]", "c")
                .replaceAll("[Ñ]", "N")
                .replaceAll("[ñ]", "n")
                .replaceAll("[ÝŸ]", "Y")
                .replaceAll("[ýÿ]", "y")
                .replaceAll("[^a-zA-Z0-9 ]", "");
    }

    public static String toJson(Object object) {
        ObjectWriter ow = new ObjectMapper().writer();
        String mensagem = null;
        try {
            mensagem = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mensagem;
    }
}
