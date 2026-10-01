package br.gov.sp.etc.estacionamento.service;
import br.gov.sp.etc.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etc.estacionamento.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    public void cadastrarVeiculo(Veiculo veiculo);
    public List<VeiculoEntity> listaVeiculo();
    public Boolean deletarVeiculo(Long id);
    public VeiculoEntity atualizarVeiculo(VeiculoEntity v);
    public VeiculoEntity registrarSaida(Long id);
}