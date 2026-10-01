package br.gov.sp.etc.estacionamento.service;

import br.gov.sp.etc.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etc.estacionamento.model.Veiculo;
import br.gov.sp.etc.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoServiceimpl implements VeiculoService {


    @Autowired
    VeiculoRepository repository;


    @Override
    public void cadastrarVeiculo(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = toEntity(veiculo);
        repository.save(veiculoEntity);
    }

    @Override
    public List<VeiculoEntity> listaVeiculo() {
        List<VeiculoEntity> veiculos = repository.findAll();
        return veiculos;
    }

    @Override
    public Boolean deletarVeiculo(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public VeiculoEntity atualizarVeiculo(VeiculoEntity v) {
        return repository.save(v);
    }

    @Override
    public VeiculoEntity registrarSaida(Long id) {
        VeiculoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        entity.setHorarioSaida(LocalDateTime.now());
        entity.setStatus(false);
        return repository.save(entity);
    }

    private VeiculoEntity toEntity(Veiculo veiculo) {
        VeiculoEntity entity = new VeiculoEntity();

        entity.setHoraEntrada(LocalDateTime.now());
        entity.setPlaca(veiculo.getPlaca());
        entity.setCor(veiculo.getCor());
        entity.setModelo(veiculo.getModelo());
        entity.setObservacoes(veiculo.getObservacoes());
        entity.setStatus(true);

        return entity;
    }

    private List<Veiculo> toListVeiculo(List<VeiculoEntity> entities){
        List<Veiculo> veiculos = new ArrayList<>();
        for (VeiculoEntity v : entities){
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(v.getPlaca());
            veiculo.setCor(v.getCor());
            veiculo.setModelo(v.getModelo());
            veiculo.setObservacoes(v.getObservacoes());
            veiculos.add(veiculo);
        }
        return veiculos;
    }

}