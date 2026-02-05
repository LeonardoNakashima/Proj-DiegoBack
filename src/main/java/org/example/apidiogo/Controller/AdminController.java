package org.example.apidiogo.Controller;

import jakarta.validation.Valid;
import org.example.apidiogo.Dto.AdminRequestDto;
import org.example.apidiogo.Dto.AdminResponseDto;
import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Openapi.AdminOpenApi;
import org.example.apidiogo.Service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController implements AdminOpenApi {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AdminResponseDto>> listAdmins() {
        List<AdminResponseDto> admins = service.listAll();
        return ResponseEntity.ok(admins);
    }


    @GetMapping("/findAdmin/{id}")
    public ResponseEntity<List<AdminResponseDto>> findAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(service.listById(id));
    }




    @PostMapping("/create")
    public ResponseEntity<AdminResponseDto> createAdmin(@RequestBody @Valid AdminRequestDto dto) {
        AdminResponseDto response = service.createAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id) {
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

}
