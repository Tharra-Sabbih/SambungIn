package RK.Jakarta.repository;

import RK.Jakarta.model.TokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenDB extends JpaRepository<TokenModel, Long> {
    Optional<TokenModel> findByToken(String token);
}