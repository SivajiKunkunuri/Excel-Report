package in.laptop.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.laptop.entity.EmployeeExcel;
import in.laptop.repo.EmployeeRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	public void generateExcel(HttpServletResponse resp) throws Exception {
		List<EmployeeExcel> list = repo.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("employee");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("EmpId");
		row.createCell(1).setCellValue("EmpName");
		row.createCell(2).setCellValue("EmpGender");
		row.createCell(3).setCellValue("EmpDesg");
		row.createCell(4).setCellValue("EmpSalary");

		int dataRowIndex = 1;

		for (EmployeeExcel emp : list) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(emp.getEmpId());
			dataRow.createCell(1).setCellValue(emp.getEmpName());
			dataRow.createCell(2).setCellValue(emp.getEmpGender());
			dataRow.createCell(3).setCellValue(emp.getEmpDesg());
			dataRow.createCell(4).setCellValue(emp.getEmpSalary());
			dataRowIndex++;
		}

		ServletOutputStream stream = resp.getOutputStream();
		workbook.write(stream);
		workbook.close();
		stream.close();
	}
}
