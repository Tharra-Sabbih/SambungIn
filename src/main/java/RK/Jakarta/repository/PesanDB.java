package RK.Jakarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import RK.Jakarta.model.PesanModel;

import java.util.Optional;

@Repository
public interface PesanDB extends JpaRepository<PesanModel, Long> {
    Optional<PesanModel> findById(Long id);
}