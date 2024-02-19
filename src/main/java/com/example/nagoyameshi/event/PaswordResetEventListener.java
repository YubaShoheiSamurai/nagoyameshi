package com.example.nagoyameshi.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.service.VerificationTokenService;

@Component
public class PaswordResetEventListener {
	private final VerificationTokenService verificationTokenService;
	private final JavaMailSender javaMailSender;

	public PaswordResetEventListener(VerificationTokenService verificationTokenService, JavaMailSender mailSender) {
		this.verificationTokenService = verificationTokenService;
		this.javaMailSender = mailSender;
	}

	@EventListener
	private void onPasswordResetEvent(PasswordResetEvent passwordResetEvent) {
		User user = passwordResetEvent.getUser();
		String token = UUID.randomUUID().toString();
		verificationTokenService.update(user, token);

		String recipientAddress = user.getEmail();
		String subject = "パスワードリセット｜NAGOYAMESHI";
		String confirmationUrl = passwordResetEvent.getRequestUrl() + "/verify?token=" + token;
		String message = "NAGOYAMESHIをご利用いただき、ありがとうございます\n\n以下のリンクをクリックしてパスワードリセットを完了してください。";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(recipientAddress);
		mailMessage.setSubject(subject);
		mailMessage.setText(message + "\n" + confirmationUrl);
		javaMailSender.send(mailMessage);
	}
}
