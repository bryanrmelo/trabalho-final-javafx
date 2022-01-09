package br.edu.ifrs.trabalho.controller;
import br.edu.ifrs.trabalho.app.App;
import br.edu.ifrs.trabalho.model.Jogo;
import br.edu.ifrs.trabalho.repository.JogoRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class ExportController extends Controller implements Initializable {
    @FXML
    RadioButton radio_pdf, radio_complete, radio_table;

    @FXML
    Button back_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        radio_pdf.setToggleGroup(group);
        radio_complete.setSelected(true);
        radio_complete.setToggleGroup(group);
        radio_table.setToggleGroup(group);
    }

    public void export()throws IOException {
        if(radio_pdf.isSelected()){
            gera_pdf();
            System.out.println("\"Jogos.pdf\" exportado com sucesso");
        }
        else if (radio_table.isSelected()){
            gera_tabela();
            System.out.println("\"Jogos.xlsx\" exportado com sucesso");
        }else if(radio_complete.isSelected()){
            gera_pdf();
            gera_tabela();
            System.out.println("\"Jogos.xlsx\" & \"Jogos.pdf\" exportados com sucesso");
        }
        App.fecharStage(back_btn);
        App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
    }

    public void voltar() {
        App.fecharStage(back_btn);
        App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
    }

    public static void gera_pdf()throws IOException { }


    public static void gera_tabela()throws IOException {
        List<Jogo> jogos = JogoRepository.buscarTodos();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Todos os Jogos");
        Map<String, Object[]> data = new HashMap();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Nome");
        cell = row.createCell(1);
        cell.setCellValue("Desenvoledora");
        cell = row.createCell(2);
        cell.setCellValue("Categoria");
        cell = row.createCell(3);
        cell.setCellValue("Ano");

        for (Jogo j : jogos) {
            data.put(j.getNome(), new Object[]{j.getDesenvolvedor(), j.getCategoria(), j.getAno()});
        }
        Set<String> keyset = data.keySet();
        int rownum = 1;

        for (String key : keyset) {
            row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            cell = row.createCell(0);
            cell.setCellValue(key);
            int cellnum = 1;
            for (Object obj : objArr) {
                cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("Jogos.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
