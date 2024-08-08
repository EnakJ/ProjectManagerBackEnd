package sn.enak.projectmanager.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class AppUser {

    @Id
    private String id;
    @Column(unique = true, nullable = false, length = 100)
    private String username;
    private String password;
    @Column(unique = true, nullable = false, length = 150)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles;
}
