package pl.qubiak.simplefactorauthorization.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.qubiak.simplefactorauthorization.Model.AppUser;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findByUsername(String username);
}
