import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;

public class ReportGenerator {
    public static void generateExcelReport(Map<String, Double> data) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Stock Prices");
        int rowNum = 0;

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entry.getKey());
            row.createCell(1).setCellValue(entry.getValue());
        }

        try (FileOutputStream fos = new FileOutputStream("C:/Users/chris/Documents/pineapple ana sa/Ranisa/Stock_Report.xlsx")) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
