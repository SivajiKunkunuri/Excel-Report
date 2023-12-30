package in.laptop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.laptop.entity.EmployeeExcel;

public interface EmployeeRepo extends JpaRepository<EmployeeExcel, Integer> {

}
