package cristianfrpt.orchvotacao.repository;

import cristianfrpt.orchvotacao.domain.exception.UsuarioException;

public interface UsuarioRepository {
    public void validaSituacaoCPF(String cpf) throws UsuarioException;
}
