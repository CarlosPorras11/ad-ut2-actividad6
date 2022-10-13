package org.iesfm.app;

import org.iesfm.service.ExcelService;

public class Actividad6 {

    private static final String FILE_PATH= "/home/Carlos/Documentos/Actividad6/superHeroe.xlsx";

    public static void main(String[] args) {
        ExcelService excelService = new ExcelService();
        excelService.createSuperheroesExcel(FILE_PATH);
    }
}
