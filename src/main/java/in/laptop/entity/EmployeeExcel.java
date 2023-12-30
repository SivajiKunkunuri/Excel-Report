package in.laptop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeExcel {

	@Id
	private Integer empId;
	private String empName;
	private String empGender;
	private String empDesg;
	private Double empSalary;

	


}
