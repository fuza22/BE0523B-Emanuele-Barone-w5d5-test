package it.epicode.w5d5.repository;

import it.epicode.w5d5.bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
