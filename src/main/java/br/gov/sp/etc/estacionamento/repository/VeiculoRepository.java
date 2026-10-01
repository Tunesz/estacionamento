package br.gov.sp.etc.estacionamento.repository;

import br.gov.sp.etc.estacionamento.entity.UsuarioEntity;
import br.gov.sp.etc.estacionamento.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
}
