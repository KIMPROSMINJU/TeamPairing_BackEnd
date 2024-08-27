package kr.ac.kopo.minju_backend.repository;

import kr.ac.kopo.minju_backend.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
