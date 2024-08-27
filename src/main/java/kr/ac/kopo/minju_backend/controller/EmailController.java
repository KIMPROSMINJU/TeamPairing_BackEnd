package kr.ac.kopo.minju_backend.controller;

import jakarta.mail.MessagingException;
import kr.ac.kopo.minju_backend.dto.EmailDTO;
import kr.ac.kopo.minju_backend.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    // 인증코드 메일 발송
    @PostMapping("/send")
    public ResponseEntity<String> mailSend(@RequestBody EmailDTO emailDto) {
        log.info("EmailController.mailSend()");
        try {
            emailService.sendEmail(emailDto.getMail());
            return ResponseEntity.ok("인증코드가 발송되었습니다.");
        } catch (MessagingException e) {
            log.error("Failed to send email", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("이메일 전송에 실패했습니다.");
        }
    }

    // 인증코드 인증
    @PostMapping("/verify")
    public ResponseEntity<String> verify(@RequestBody EmailDTO emailDto) {
        log.info("EmailController.verify()");
        boolean isVerify = emailService.verifyEmailCode(emailDto.getMail(), emailDto.getVerifyCode());
        return isVerify
                ? ResponseEntity.ok("인증이 완료되었습니다.")
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증 실패하셨습니다.");
    }

    // 예외 처리
    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<String> handleMessagingException(MessagingException e) {
        log.error("MessagingException occurred", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("이메일 처리 중 오류가 발생했습니다.");
    }
}
