package src.utilities;

import java.io.IOException;


public class DataProvider {
    public Object[][] getUserData() throws IOException {
        String excelPath = "./data/UserData.xlsx";  // Path to your Excel file
        ExcelUtils excel = new ExcelUtils(excelPath, "Sheet1");

        int rowCount = excel.getRowCount();
        int colCount = excel.getColumnCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {  // Skip header row
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }
        return data;
    }
}
