package RK.Jakarta.service;

import RK.Jakarta.model.TokenModel;

public interface TokenService {
    TokenModel getTokenByToken(String token);
    TokenModel addToken(TokenModel token);
}
