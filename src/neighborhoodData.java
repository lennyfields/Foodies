import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class neighborhoodData {
	//Set file path to Excel Workbook of interest. 
    public static final String XLSX_FILE_PATH = "DataDownload.xls";
    
    //METHOD: Read the excel file as a workbook object. 
    public Workbook readWorkbook() throws EncryptedDocumentException, IOException {
        Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
    	return workbook;
    }
    
    // METHOD: Print each cell in an sheet from a workbook object.  
    public void printSheet(Sheet sheet){
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
       
        //Print out rows and columns using forEach.
        sheet.forEach(row -> {
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            });
            System.out.println();
        });
    }

    //METHOD: Print out sheet names of workbook.
    public void printSheetNames(Workbook workbook){
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });
    }
}

