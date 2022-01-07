package br.edu.ifrs.trabalho.controller;
import br.edu.ifrs.trabalho.app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ExportController extends Controller implements Initializable {
    @FXML
    RadioButton radio_complete, radio_graph, radio_table;

    @FXML
    Button back_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        radio_complete.setToggleGroup(group);
        radio_complete.setSelected(true);
        radio_graph.setToggleGroup(group);
        radio_table.setToggleGroup(group);
    }

    public void export()throws IOException {
        System.out.println(radio_complete.isSelected());
        if(radio_complete.isSelected()){
            gera_tabela();
            gera_grafico();
        }
        else if (radio_table.isSelected()){
            gera_tabela();
        }else if(radio_graph.isSelected()){
            gera_grafico();
        }
    }

    public void voltar() {
        App.fecharStage(back_btn);
        App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
    }

    public static void gera_grafico()throws IOException { }
    public static void gera_tabela()throws IOException {
//    PUXAR TODOS OS  JOGOS PARA UM ARRAYLIST
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        for(Jogo j : jogos) {
//            XSSFSheet sheet = workbook.createSheet(t.getCurso() + " - " + t.getNome());
//            Map<String, Object[]> data = new HashMap();
//            Row row = sheet.createRow(0);
//            Cell cell = row.createCell(0);
//            cell.setCellValue("Nome");
//            cell = row.createCell(1);
//            cell.setCellValue("Nota 1");
//            cell = row.createCell(2);
//            cell.setCellValue("Nota 2");
//            cell = row.createCell(3);
//            cell.setCellValue("Nota 3");
//            cell = row.createCell(4);
//            cell.setCellValue("Nota Final");
//
//            for (Aluno a : t.getAlunos()) {
//                data.put(a.getNome(), new Object[]{a.getNota1(), a.getNota2(), a.getNota3(), a.getNotaFinal()});
//            }
//            Set<String> keyset = data.keySet();
//            int rownum = 1;
//
//            for (String key : keyset) {
//                row = sheet.createRow(rownum++);
//                Object[] objArr = data.get(key);
//                cell = row.createCell(0);
//
//                cell.setCellValue(key);
//                int cellnum = 1;
//                for (Object obj : objArr) {
//                    cell = row.createCell(cellnum++);
//                    if (obj instanceof String)
//                        cell.setCellValue((String) obj);
//                    else if (obj instanceof Double)
//                        cell.setCellValue((Double) obj);
//                }
//            }
//        }
//        try {
//            FileOutputStream out = new FileOutputStream(new File("arq.xlsx"));
//            workbook.write(out);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
