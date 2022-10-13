package org.iesfm.dao;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ExcelDAO{

    void createExcelInDisk(Workbook workbook, String path) throws IOException;
}

