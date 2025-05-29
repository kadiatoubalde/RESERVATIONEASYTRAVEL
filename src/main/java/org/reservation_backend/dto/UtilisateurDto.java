package org.reservation_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.reservation_backend.Enum.EnumRoleUtilisateur;

@Data
@Getter
@Setter
public class UtilisateurDto {
    private String uuid;
    @NotBlank(message = "Le prénom est obligatoire")
    private String firstname;
    @NotBlank(message = "Le nom est obligatoire")
    private String lastname;
    @NotBlank(message = "L'email est obligatoire")
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;
    @NotBlank(message = " Le numero de telephone est obligatoire")
    private String telephone;
    private String role;

    private String token;
}
