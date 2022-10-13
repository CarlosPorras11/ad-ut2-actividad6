package org.iesfm.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.iesfm.dao.ExcelDAO;
import org.iesfm.dao.ExcelDAOImpl;
import org.iesfm.entity.Comic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {

    ExcelDAO excelDAO = new ExcelDAOImpl();
    public void createSuperheroesExcel(String filePath) {
        List<Comic> comicList = loadInfo();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet();
            createHeader(sheet, workbook.createCellStyle(), workbook.createFont());
            createRow(sheet, comicList);
            excelDAO.createExcelInDisk(workbook, filePath);
        } catch (IOException e) {
            System.err.println("Error creando workbook" + e.getCause());
        }

    }

    private void createRow(Sheet sheet, List<Comic> comicList) {
        for (int i = 0; i < comicList.size(); i++) {
            Comic comic = comicList.get(i);
            Row row = sheet.createRow(i+1);
            Cell cell = row.createCell(0);
            RichTextString text = new XSSFRichTextString(comic.getSuperHeroe());
            cell.setCellValue(text);

            cell = row.createCell(1);
            text = new XSSFRichTextString(comic.getCompany());
            cell.setCellValue(text);

            cell = row.createCell(2);
            text = new XSSFRichTextString(comic.getCreator());
            cell.setCellValue(text);

            cell = row.createCell(3);
            text = new XSSFRichTextString(comic.getFirstAppear());
            cell.setCellValue(text);

            cell = row.createCell(4);
            text = new XSSFRichTextString(comic.getDateAppear());
            cell.setCellValue(text);
        }
    }

    private void createHeader(Sheet sheet, CellStyle cellStyle, Font font) {
        cellStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBold(true);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        RichTextString text = new XSSFRichTextString("Super Heroe");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(1);
        text = new XSSFRichTextString("Compañía");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(2);
        text = new XSSFRichTextString("Creador");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        text = new XSSFRichTextString("Primera Aparición");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(4);
        text = new XSSFRichTextString("Fecha Aparición");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
    }

    private List<Comic> loadInfo() {
        List<Comic> comicList = new ArrayList<>();
        Comic comic1 = new Comic("SpiderMan", "Marvel", "Stan Lee y Steve Ditko",
                "Amazing Fantasy #15", "Agosto de 1962");
        comicList.add(comic1);
        Comic comic2 = new Comic("Superman,", "DC", "Jerry Siegel y Joe Shuster",
                "Action Comics #1", "Junio de 1938");
        comicList.add(comic2);
        Comic comic3 = new Comic("Batman", "DC", "Bob Kane y Bill Finger",
                "Detective Comics #27", "Marzo de 1939");
        comicList.add(comic3);
        Comic comic4 = new Comic("Iron Man", "Marvel",
                "Stan Lee, Larry Lieber, Don Heck y Jack Kirby",
                "Tales of Suspense #39", "Marzo de 1963");
        comicList.add(comic4);

        return comicList;
    }
}
