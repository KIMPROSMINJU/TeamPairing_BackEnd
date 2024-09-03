package kr.ac.kopo.minju_backend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Random;

public interface EmailService {

    String makeCode();

    String createCode();

    // 이메일 내용 초기화
    String setContext(String code);

    // 이메일 폼 생성
    MimeMessage createEmailForm(String authCode, String email) throws MessagingException;

    // 인증코드 이메일 발송
    void sendEmail(String toEmail) throws MessagingException;

    // 코드 검증
    Boolean verifyEmailCode(String email, String code);
}
