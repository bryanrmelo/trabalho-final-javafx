package br.edu.ifrs.trabalho.controller;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import br.edu.ifrs.trabalho.app.App;
import br.edu.ifrs.trabalho.model.Jogo;
import br.edu.ifrs.trabalho.repository.JogoRepository;
import br.edu.ifrs.trabalho.utils.AlertUtils;
import br.edu.ifrs.trabalho.utils.FileUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ExportController extends Controller implements Initializable {
	@FXML
	RadioButton radio_pdf, radio_complete, radio_table;

	@FXML
	Button back_btn;

	// Mateus Zucco
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup group = new ToggleGroup();
		radio_pdf.setToggleGroup(group);
		radio_complete.setSelected(true);
		radio_complete.setToggleGroup(group);
		radio_table.setToggleGroup(group);
	}

	// Mateus Zucco
	public void export() throws IOException {
		if (radio_pdf.isSelected()) {
			gera_pdf();
			System.out.println("\"Jogos.pdf\" exportado com sucesso");
		} else
			if (radio_table.isSelected()) {
				gera_tabela();
				System.out.println("\"Jogos.xlsx\" exportado com sucesso");
			} else
				if (radio_complete.isSelected()) {
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

	// Rafael Graunke
	public static void gera_pdf() throws IOException {
		List<Jogo> jogos = JogoRepository.buscarTodos();
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(FileUtils.chooseSaveFile(FileUtils.PDF)));
			doc.open();

			Font font = new Font(Font.FontFamily.HELVETICA, 45);
			Paragraph title = new Paragraph("Games DB", font);
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(20f);

			PdfPTable table = new PdfPTable(4);
			table.addCell("Nome");
			table.addCell("Desenvolvedor");
			table.addCell("Categoria");
			table.addCell("Ano");
			for (Jogo j : jogos) {
				table.addCell(j.getNome());
				table.addCell(j.getDesenvolvedor());
				table.addCell(j.getCategoria());
				table.addCell(String.valueOf(j.getAno()));
			}

			doc.add(title);
			doc.add(table);
			doc.close();
		} catch (DocumentException e) {
			AlertUtils.mostrarAlert("Não foi possível salvar o arquivo no caminho especificado.", Alert.AlertType.ERROR);
		}
	}

	// Mateus Zucco
	public static void gera_tabela() throws IOException {
		List<Jogo> jogos = JogoRepository.buscarTodos();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Todos os Jogos");
		Map<String, Object[]> data = new HashMap<>();
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
			data.put(j.getNome(), new Object[] { j.getDesenvolvedor(), j.getCategoria(), j.getAno() });
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
				else
					if (obj instanceof String)
						cell.setCellValue((String) obj);
					else
						if (obj instanceof Integer)
							cell.setCellValue((Integer) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(FileUtils.chooseSaveFile(FileUtils.EXCEL)); // Rafael Graunke
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
