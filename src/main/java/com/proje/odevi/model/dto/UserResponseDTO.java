package com.proje.odevi.model.dto;
import com.proje.odevi.model.entity.Role;
import lombok.Data;
import java.util.List;

@Data
public class UserResponseDTO {

    private Integer id;
    private String username;
    private String email;
    private List<Role> roles;

}