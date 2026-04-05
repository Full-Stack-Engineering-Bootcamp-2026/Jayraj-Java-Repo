package com.app.service;

import java.util.List;
import com.app.dto.*;

public interface EmployeeService {

    EmployeeResponseDTO save(EmployeeRequestDTO dto);

    List<EmployeeResponseDTO> getAll();

    EmployeeResponseDTO getById(Integer id);

    EmployeeResponseDTO update(Integer id, EmployeeRequestDTO dto);

    void delete(Integer id);

    EmployeeResponseDTO assignProject(Integer empId, Integer projectId);
}