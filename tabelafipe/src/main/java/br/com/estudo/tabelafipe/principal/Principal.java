package br.com.estudo.tabelafipe.principal;

import br.com.estudo.tabelafipe.modelo.DadosVeiculos;
import br.com.estudo.tabelafipe.modelo.ModelosVeiculos;
import br.com.estudo.tabelafipe.modelo.TipoVeiculos;
import br.com.estudo.tabelafipe.service.ConsumoApi;
import br.com.estudo.tabelafipe.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private ConsumoApi consumo = new ConsumoApi();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1";

    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        System.out.println("""
                Moto
                Carro
                Caminhão
            
                Digite a opção desejada:    
                """);

        var tipoDoVeiculo = leitura.nextLine();
        String endereco;

        if (tipoDoVeiculo.toLowerCase().contains("carro")) {
            endereco = URL_BASE + "/carros/marcas";
        } else if (tipoDoVeiculo.toLowerCase().contains("moto")) {
            endereco = URL_BASE + "/motos/marcas";
        } else {
            endereco = URL_BASE + "/caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        var dadosVeiculo = conversor.obterLista(json, DadosVeiculos.class);
        dadosVeiculo.stream()
                .sorted(Comparator.comparing(DadosVeiculos::codigo))
                .forEach(System.out::println);

        System.out.println("\nAgora digite o código da marca desejada");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, ModelosVeiculos.class);

        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(DadosVeiculos::codigo))
                .forEach(System.out::println);

        System.out.println("\nAgora digite o nome do veiculo desejado");
        var nomeDoVeiculo = leitura.nextLine();

        List<DadosVeiculos> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeDoVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos Filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite por favor o código do modelo para buscar os valores de avaliação");
        var nomeDoModeloDoVeiculo = leitura.nextLine();

        endereco = endereco + "/" + nomeDoModeloDoVeiculo + "/anos";
        json = consumo.obterDados(endereco);

        List<DadosVeiculos> anosVeiculos = conversor.obterLista(json, DadosVeiculos.class);
        List<TipoVeiculos> veiculosList = new ArrayList<>();

        for (int i = 0; i < anosVeiculos.size(); i++) {
            var enderecoAnos = endereco + "/" + anosVeiculos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            TipoVeiculos tipoVeiculos = conversor.obterDados(json, TipoVeiculos.class);
            veiculosList.add(tipoVeiculos);
        }

        System.out.println("Todos Veiculos");
        veiculosList.forEach(System.out::println);
    }
}
