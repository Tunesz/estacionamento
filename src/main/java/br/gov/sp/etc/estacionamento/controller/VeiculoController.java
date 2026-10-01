package br.gov.sp.etc.estacionamento.controller;


import br.gov.sp.etc.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etc.estacionamento.model.Veiculo;
import br.gov.sp.etc.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService service;

    @PostMapping("cadastrar")
    public String cadastrar(Veiculo x) {
        service.cadastrarVeiculo(x);
        return "redirect:/veiculo/listar";
    }

    @GetMapping("/registrar-entrada")
    public String registrarEntrada() {
        return "registrar-entrada";

    }

    @PostMapping("/retirar/{id}")
    public String retirar(@PathVariable Long id) {
        service.registrarSaida(id);
        return "redirect:/veiculo/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<VeiculoEntity> veiculos = service.listaVeiculo();
        model.addAttribute("veiculos", veiculos);
        return "listarVeiculos";
    }

}