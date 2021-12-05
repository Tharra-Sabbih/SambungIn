package RK.Jakarta.service;

import RK.Jakarta.repository.TokenDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import RK.Jakarta.model.TokenModel;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDB tokenDB;

    @Override
    public TokenModel getTokenByToken(String token) {
        Optional<TokenModel> tkn = tokenDB.findByToken(token);
        if (tkn.isPresent()) return tkn.get();
        return null;
    }

    @Override
    public TokenModel addToken(TokenModel token) {
        for (TokenModel tkn : tokenDB.findAll()) {
            if (tkn.getToken().equals(token.getToken())) return null;
        } return tokenDB.save(token);
    }
}
