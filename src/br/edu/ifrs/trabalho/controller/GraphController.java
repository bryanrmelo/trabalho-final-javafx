package br.edu.ifrs.trabalho.controller;

import br.edu.ifrs.trabalho.model.Jogo;
import br.edu.ifrs.trabalho.repository.JogoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class GraphController extends Controller implements Initializable {

    private JogoRepository jogoRepo = new JogoRepository();

    @FXML
    PieChart pieChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Jogo> jogos = jogoRepo.buscarTodos();
        HashMap<String, Integer> categorias = new HashMap<>();
        int total = 0;
        for (Jogo jogo : jogos) {
            if (!categorias.containsKey(jogo.getCategoria())) {
                categorias.put(jogo.getCategoria(), 1);
            } else {
                categorias.put(jogo.getCategoria(), categorias.get(jogo.getCategoria()) + 1);
            }
            total ++;
        }
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : categorias.entrySet()) {
            pieData.add(new PieChart.Data(entry.getKey(), (Float.valueOf(entry.getValue()) * 100) / total));
        }
        pieChart.setData(pieData);
    }
}
