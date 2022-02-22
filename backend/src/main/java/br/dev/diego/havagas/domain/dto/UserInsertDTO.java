package br.dev.diego.havagas.domain.dto;

import br.dev.diego.havagas.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO {

    private String password;

    public UserInsertDTO(){
    }

    public UserInsertDTO(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
