/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import com.java.entity.FileEntity;
import com.java.entity.FileReportEntity;
import com.java.entity.ScheduleReportEntity;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Madushan Lahiru
 */
public class DBExcelExport {
    
    private CommonLogger logger;

    public DBExcelExport() {
        logger = new CommonLogger(DBExcelExport.class.getName());
    }

    public void export(List<FileEntity> dataSet) {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Sheet1");
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 6000);
        sheet.setColumnWidth(7, 6000);

        // header row
        Row header = sheet.createRow(0);

        // header style
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);

        XSSFFont headerFont = ((XSSFWorkbook) workbook).createFont();
        headerFont.setFontName("Calibri");
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        String[] headers = {"No", "ReceivedDate", "FacilityNo", "VehicleNo", "FileType", "Comment", 
            "ChequeCompletedDate", "EnteredUser"};

        // Initialize header row cells
        for (int i = 0; i < headers.length; i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(headers[i]);
            headerCell.setCellStyle(headerStyle);
        }

        // Data cell style
        CreationHelper createHelper = workbook.getCreationHelper();

        CellStyle style = workbook.createCellStyle();
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);

        // Date format cell style
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);
        dateCellStyle.setBorderTop(BorderStyle.THIN);
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy hh.mm aa"));

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        dateCellStyle.setFont(font);

        // Data rows
        List<FileEntity> data = dataSet; // Data
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i + 1);

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(i + 1);
            cell0.setCellStyle(style);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(data.get(i).getDateTime());
            cell1.setCellStyle(dateCellStyle);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(data.get(i).getFacilityNo());
            cell2.setCellStyle(style);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(data.get(i).getVehicleNo());
            cell3.setCellStyle(style);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(CommonUtils.selectFileType(data.get(i).getFileType()));
            cell4.setCellStyle(style);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(CommonUtils.selectComment(data.get(i).getComment()));
            cell5.setCellStyle(style);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(data.get(i).getCompletedDataTime());
            cell6.setCellStyle(dateCellStyle);
            
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(data.get(i).getEnteredUser());
            cell7.setCellStyle(dateCellStyle);

        }

        // Writting excel file
        try {
            // String user = System.getProperty("user.name");
            // String currPath = "C:\\Users\\" + user + "\\Downloads";
            String currPath = System.getProperty("user.home") + "\\Downloads";
            File currDir = new File(currPath);
            String path = currDir.getAbsolutePath();
            String fileLocation = path + "\\File_Received_Report_" + LocalDate.now() + ".xlsx";

            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            
            outputStream.close();
            workbook.close();

            // Open the excel file in MS Excel
            Desktop.getDesktop().open(new File(fileLocation));

        } catch (FileNotFoundException ex) {
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void exportWithHistory(List<FileReportEntity> dataSet) {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Sheet1");
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 6000);
        sheet.setColumnWidth(7, 6000);
        sheet.setColumnWidth(8, 6000);
        sheet.setColumnWidth(9, 6000);
        sheet.setColumnWidth(10, 6000);
        sheet.setColumnWidth(11, 4000);
        sheet.setColumnWidth(12, 6000);
        sheet.setColumnWidth(13, 6000);

        // header row
        Row header = sheet.createRow(0);

        // header style
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);

        XSSFFont headerFont = ((XSSFWorkbook) workbook).createFont();
        headerFont.setFontName("Calibri");
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        String[] headers = {"No", "ReceivedDate", "FacilityNo", "VehicleNo", "FileType", "Comment", 
            "ChequeCompletedDate", "EnteredUser", "Process", "UpdatedComment", "ReturnedDate", "ReturnedUser"
            , "ReceivedDate", "ReceivedUser"};

        // Initialize header row cells
        for (int i = 0; i < headers.length; i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(headers[i]);
            headerCell.setCellStyle(headerStyle);
        }

        // Data cell style
        CreationHelper createHelper = workbook.getCreationHelper();

        CellStyle style = workbook.createCellStyle();
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);

        // Date format cell style
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);
        dateCellStyle.setBorderTop(BorderStyle.THIN);
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        dateCellStyle.setFont(font);
        
        // Data rows
        List<FileReportEntity> data = dataSet; // Data
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i + 1);

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(i + 1);
            cell0.setCellStyle(style);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(data.get(i).getDateTime());
            cell1.setCellStyle(dateCellStyle);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(data.get(i).getFacilityNo());
            cell2.setCellStyle(style);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(data.get(i).getVehicleNo());
            cell3.setCellStyle(style);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(CommonUtils.selectFileType(data.get(i).getFileType()));
            cell4.setCellStyle(style);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(CommonUtils.selectComment(data.get(i).getComment()));
            cell5.setCellStyle(style);

            Cell cell6 = row.createCell(6);
            if (data.get(i).getCompletedDateTime() != null) {
                cell6.setCellValue(data.get(i).getCompletedDateTime());
            }
            cell6.setCellStyle(dateCellStyle);
            
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(data.get(i).getEnteredUser());
            cell7.setCellStyle(style);
            
            Cell cell8 = row.createCell(8);
            if (data.get(i).getProcess() != 0) {
                cell8.setCellValue(CommonUtils.selectProcess(data.get(i).getProcess()));
            }
            cell8.setCellStyle(style);
            
            Cell cell9 = row.createCell(9);
            cell9.setCellValue(data.get(i).getUpdatedComment());
            cell9.setCellStyle(style);
            
            Cell cell10 = row.createCell(10);
            if (data.get(i).getReturnedDateTime() != null) {
                cell10.setCellValue(data.get(i).getReturnedDateTime());
            }
            cell10.setCellStyle(dateCellStyle);
            
            Cell cell11 = row.createCell(11);
            cell11.setCellValue(data.get(i).getReturnedUser());
            cell11.setCellStyle(style);
            
            Cell cell12 = row.createCell(12);
            if (data.get(i).getReceivedDateTime() != null) {
                cell12.setCellValue(data.get(i).getReceivedDateTime());
            }
            cell12.setCellStyle(dateCellStyle);
            
            Cell cell13 = row.createCell(13);
            cell13.setCellValue(data.get(i).getReceivedUser());
            cell13.setCellStyle(style);

        }

        // Writting excel file
        // String user = System.getProperty("user.name");
        // String currPath = "C:\\Users\\" + user + "\\Downloads";
        String currPath = System.getProperty("user.home") + "\\Downloads";
        File currDir = new File(currPath);
        String path = currDir.getAbsolutePath();
        String fileLocation = path + "\\File_History_Report_" + LocalDate.now() + ".xlsx";

        try {
            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            
            outputStream.close();
            workbook.close();

            // Open the excel file in MS Excel
            Desktop.getDesktop().open(new File(fileLocation));

        } catch (FileNotFoundException ex) {
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public void exportScheduleDetails(List<ScheduleReportEntity> dataSet) {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Sheet1");
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 6000);
        sheet.setColumnWidth(7, 6000);
        sheet.setColumnWidth(8, 6000);
        sheet.setColumnWidth(9, 6000);
        sheet.setColumnWidth(10, 6000);
        sheet.setColumnWidth(11, 4000);
        sheet.setColumnWidth(12, 6000);
        sheet.setColumnWidth(13, 6000);

        // header row
        Row header = sheet.createRow(0);

        // header style
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);

        XSSFFont headerFont = ((XSSFWorkbook) workbook).createFont();
        headerFont.setFontName("Calibri");
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        String[] headers = {"No", "FacilityNo", "Courier Branch", "Courier Type", "Cheque Type", 
            "Cheque No", "Cheque Amount", "Remarks", "Added User", "Added Date", "Is Printed", 
            "Schedule No", "Printed User", "Printed Date"};

        // Initialize header row cells
        for (int i = 0; i < headers.length; i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(headers[i]);
            headerCell.setCellStyle(headerStyle);
        }

        // Data cell style
        CreationHelper createHelper = workbook.getCreationHelper();

        CellStyle style = workbook.createCellStyle();
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);

        // Date format cell style
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);
        dateCellStyle.setBorderTop(BorderStyle.THIN);
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy hh.mm aa"));

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        dateCellStyle.setFont(font);

        // Data rows
        List<ScheduleReportEntity> data = dataSet; // Data
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i + 1);

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(i + 1);
            cell0.setCellStyle(style);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(data.get(i).getFacilityNo());
            cell1.setCellStyle(style);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(data.get(i).getCourierBranch());
            cell2.setCellStyle(style);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(data.get(i).getCourierType());
            cell3.setCellStyle(style);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(data.get(i).getChequeType());
            cell4.setCellStyle(style);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(data.get(i).getChequeNo());
            cell5.setCellStyle(style);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(data.get(i).getChequeAmount());
            cell6.setCellStyle(style);
            
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(data.get(i).getRemarks());
            cell7.setCellStyle(style);
            
            Cell cell8 = row.createCell(8);
            cell8.setCellValue(data.get(i).getAddedUser());
            cell8.setCellStyle(style);
            
            Cell cell9 = row.createCell(9);
            cell9.setCellValue(data.get(i).getAddedDateTime());
            cell9.setCellStyle(dateCellStyle);
            
            Cell cell10 = row.createCell(10);
            cell10.setCellValue(data.get(i).isIsPrinted());
            cell10.setCellStyle(style);
            
            Cell cell11 = row.createCell(11);
            cell11.setCellValue(data.get(i).getSceduleId());
            cell11.setCellStyle(style);
            
            Cell cell12 = row.createCell(12);
            cell12.setCellValue(data.get(i).getPrintedUser());
            cell12.setCellStyle(style);
            
            Cell cell13 = row.createCell(13);
            cell13.setCellValue(data.get(i).getPrintedDateTime());
            cell13.setCellStyle(dateCellStyle);

        }

        // Writting excel file
        try {
            // String user = System.getProperty("user.name");
            // String currPath = "C:\\Users\\" + user + "\\Downloads";
            String currPath = System.getProperty("user.home") + "\\Downloads";
            File currDir = new File(currPath);
            String path = currDir.getAbsolutePath();
            String fileLocation = path + "\\Courier_Details_Report_" + LocalDate.now() + ".xlsx";

            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            
            outputStream.close();
            workbook.close();

            // Open the excel file in MS Excel
            Desktop.getDesktop().open(new File(fileLocation));

        } catch (FileNotFoundException ex) {
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
