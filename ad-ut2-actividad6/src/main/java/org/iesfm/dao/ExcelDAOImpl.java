package org.iesfm.dao;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDAOImpl implements ExcelDAO{
    @Override
    public void createExcelInDisk(Workbook workbook, String path) throws IOException {
        try(FileOutputStream excel = new FileOutputStream(path)){
        workbook.write(excel);
            System.out.println("Fichero creado en:" + path);
        }
    }
}
