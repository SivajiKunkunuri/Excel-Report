package in.laptop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.laptop.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportExcelController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/excel")
	public void generateExcelSheet(HttpServletResponse resp) throws Exception {
		resp.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; fileName = EmpExcel.xls";

		resp.setHeader(headerKey, headerValue);

		service.generateExcel(resp);

	}

}
