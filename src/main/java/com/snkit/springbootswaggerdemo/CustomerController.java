package com.snkit.springbootswaggerdemo;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.snkit.springbootswaggerdemo.api.CustomerApi;
import com.snkit.springbootswaggerdemo.models.Employe;
import com.snkit.springbootswaggerdemo.models.EmployeResponse;

@RestController
public class CustomerController implements CustomerApi {

	private Map<String, Employe> empMap = new HashMap<>();

	CustomerController() {
		Employe emp = new Employe();
		emp.setId("1");
		emp.setName("ABC");
		emp.setType("Permanent");

		empMap.put(emp.getId(), emp);

		Employe emp2 = new Employe();
		emp2.setId("2");
		emp2.setName("XYZ");
		emp2.setType("Contract");
		empMap.put(emp2.getId(), emp2);
	}

	@Override
	public ResponseEntity<Employe> findCustById(String custId, String token) {
		Employe emp = empMap.get(custId);
		emp.setType(token);
		return new ResponseEntity(emp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employe> findCustByType(@NotNull @Valid String custType ) {

		Employe emp = new Employe();
		emp.setId("1");
		emp.setName("ABC");
		emp.setType(custType);

		return new ResponseEntity(emp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeResponse> getCust() {
		EmployeResponse resp = new EmployeResponse();
		empMap.values().forEach(cust -> {
			resp.addEmployeListItem(cust);
		});
		return new ResponseEntity(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeResponse> saveCustomer(@Valid Employe employe) {
		empMap.put(employe.getId(), employe);
		EmployeResponse resp = new EmployeResponse();
		empMap.values().forEach(cust -> {
			resp.addEmployeListItem(cust);
		});
		return new ResponseEntity(resp, HttpStatus.OK);
	}
}
