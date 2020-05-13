package com.houarizegai.exceldemo.dao;

import com.houarizegai.exceldemo.model.Employee;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EmployeeDao {
    private static final String EXCEL_FILE_PATH = "E:\\users.xlsx";

    public List<Employee> findAll() {
        List<Employee> employees = new LinkedList<>();
        try (
                FileInputStream excelFileInputStream = new FileInputStream(new File(EmployeeDao.EXCEL_FILE_PATH));
                Workbook workbook = new XSSFWorkbook(excelFileInputStream)) {

            Sheet page = workbook.getSheetAt(0);
            for (int i = 1; i <= page.getLastRowNum(); i++) {
                Row row = page.getRow(i);
                Employee employee = new Employee(
                        row.getCell(0).getStringCellValue(),
                        row.getCell(1).getBooleanCellValue(),
                        (int) row.getCell(2).getNumericCellValue(),
                        row.getCell(3).getNumericCellValue());

                employees.add(employee);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return employees;
    }

    public boolean save(List<Employee> employees) {
        File mFile = new File(EmployeeDao.EXCEL_FILE_PATH);

        try (
                FileInputStream inputStream = new FileInputStream(mFile);
                Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet page = workbook.createSheet(); // Create new page

            AtomicInteger index = new AtomicInteger();
            Row row = page.createRow(index.getAndIncrement());
            row.createCell(0).setCellValue("Name");
            row.createCell(1).setCellValue("Gender");
            row.createCell(2).setCellValue("Age");
            row.createCell(3).setCellValue("Salary");

            for (Employee employee : employees) {
                System.out.println(employee);
                row = page.createRow(index.getAndIncrement());
                row.createCell(0).setCellValue(employee.getName());
                row.createCell(1).setCellValue(employee.isGender());
                row.createCell(2).setCellValue(employee.getAge());
                row.createCell(3).setCellValue(employee.getSalary());
            }

            try(FileOutputStream outputStream = new FileOutputStream(mFile)){
                workbook.write(outputStream);
            }

            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
