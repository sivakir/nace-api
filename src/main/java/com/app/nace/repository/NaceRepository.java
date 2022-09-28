package com.app.nace.repository;

import com.app.nace.domain.Nace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends JpaRepository<Nace, Long> {
}
