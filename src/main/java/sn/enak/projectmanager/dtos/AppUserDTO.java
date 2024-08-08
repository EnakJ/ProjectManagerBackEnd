package sn.enak.projectmanager.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AppUserDTO {
    private String id;
    private String username;
    private String email;
    private List<AppRoleDTO> roles;
}
