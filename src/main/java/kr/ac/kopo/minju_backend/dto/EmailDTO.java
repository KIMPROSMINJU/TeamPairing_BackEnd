package kr.ac.kopo.minju_backend.dto;

import lombok.Data;

@Data
public class EmailDTO {
    private String mail;
    private String verifyCode;

    public String getMail() {
        return mail;
    }
}
