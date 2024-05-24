package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Employee;
import org.hibernate.jpa.spi.JpaCompliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
