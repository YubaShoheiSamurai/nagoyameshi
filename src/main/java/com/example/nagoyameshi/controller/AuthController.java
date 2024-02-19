package com.example.nagoyameshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.entity.VerificationToken;
import com.example.nagoyameshi.event.PasswordResetPublisher;
import com.example.nagoyameshi.event.SignupEventPublisher;
import com.example.nagoyameshi.form.NewPasswordInputForm;
import com.example.nagoyameshi.form.PasswordResetForm;
import com.example.nagoyameshi.form.SignupForm;
import com.example.nagoyameshi.service.UserService;
import com.example.nagoyameshi.service.VerificationTokenService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

	private final UserService userService;
	private final SignupEventPublisher signupEventPublisher;
	private final PasswordResetPublisher passwordResetEventPublisher;
	private final VerificationTokenService verificationTokenService;

	public AuthController(UserService userService, SignupEventPublisher signupEventPublisher, PasswordResetPublisher passwordResetEventPublisher, VerificationTokenService verificationTokenService) {
		this.userService = userService;
		this.signupEventPublisher = signupEventPublisher;
		this.passwordResetEventPublisher = passwordResetEventPublisher;
		this.verificationTokenService = verificationTokenService;
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "auth/signup";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute @Validated SignupForm signupForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		// メールアドレスが登録済みであれば、BindingResultオブジェクトにエラー内容を追加する
		if (userService.isEmailRegistered(signupForm.getEmail())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済みのメールアドレスです。");
			bindingResult.addError(fieldError);
		}

		// パスワードとパスワード（確認用）の入力値が一致しなければ、BindingResultオブジェクトにエラー内容を追加する
		if (!userService.isSamePassword(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "password", "パスワードが一致しません。");
			bindingResult.addError(fieldError);
		}

		if (bindingResult.hasErrors()) {
			return "auth/signup";
		}

		User createdUser = userService.create(signupForm);
        String requestUrl = new String(httpServletRequest.getRequestURL());
        signupEventPublisher.publishSignupEvent(createdUser, requestUrl);
        redirectAttributes.addFlashAttribute("successMessage", "ご入力いただいたメールアドレスに認証メールを送信しました。メールに記載されているリンクをクリックし、会員登録を完了してください。");        


		return "redirect:/";
	}
	
	@GetMapping("/signup/verify")
    public String verify(@RequestParam(name = "token") String token, Model model) {
        VerificationToken verificationToken = verificationTokenService.getVerificationToken(token);
        
        if (verificationToken != null) {
            User user = verificationToken.getUser();  
            userService.enableUser(user);
            String successMessage = "会員登録が完了しました。";
            model.addAttribute("successMessage", successMessage);            
        } else {
            String errorMessage = "トークンが無効です。";
            model.addAttribute("errorMessage", errorMessage);
        }
        
        return "auth/verify";         
    }
	
	@GetMapping("/password-reset")
	public String passwordReset(Model model) {
		model.addAttribute("passwordResetForm", new PasswordResetForm());
		return "auth/password_reset";
	}
	
	@PostMapping("/password-reset")
	public String passwordReset(@ModelAttribute @Validated PasswordResetForm passwordResetForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		// メールアドレスが登録されていなければ、BindingResultオブジェクトにエラー内容を追加する
		if (!userService.isEmailRegistered(passwordResetForm.getEmail())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "入力されたメールアドレスは登録されていません。");
			bindingResult.addError(fieldError);
		}

		if (bindingResult.hasErrors()) {
			return "auth/password-reset";
		}
		User user = userService.selectByEmail(passwordResetForm.getEmail());
        String requestUrl = new String(httpServletRequest.getRequestURL());
        passwordResetEventPublisher.publishSignupEvent(user, requestUrl);
        redirectAttributes.addFlashAttribute("successMessage", "ご入力いただいたメールアドレスにメールを送信しました。メールに記載されているリンクをクリックし、パスワードをリセットしてください。");        


		return "redirect:/";
	}
	
	@GetMapping("/password-reset/verify")
    public String passwordResetverify(@RequestParam(name = "token") String token, Model model) {
        VerificationToken verificationToken = verificationTokenService.getVerificationToken(token);
        
        if (verificationToken != null) {
            User user = verificationToken.getUser();
            NewPasswordInputForm newPasswordInputForm = new NewPasswordInputForm();
            newPasswordInputForm.setEmail(user.getEmail());
            model.addAttribute("newPasswordInputForm", newPasswordInputForm);         
        } else {
            String errorMessage = "トークンが無効です。";
            model.addAttribute("errorMessage", errorMessage);
        }
        
        return "auth/new_password_input";         
    }
	
	@PostMapping("/password-reset/new-password-input")
	public String newPasswordInput(@ModelAttribute @Validated NewPasswordInputForm newPasswordInputForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		// メールアドレスが登録済みであれば、BindingResultオブジェクトにエラー内容を追加する
		if (!userService.isEmailRegistered(newPasswordInputForm.getEmail())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "このメールアドレスは登録されていません。");
			bindingResult.addError(fieldError);
		}

		// パスワードとパスワード（確認用）の入力値が一致しなければ、BindingResultオブジェクトにエラー内容を追加する
		if (!userService.isSamePassword(newPasswordInputForm.getPassword(), newPasswordInputForm.getPasswordConfirmation())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "password", "パスワードが一致しません。");
			bindingResult.addError(fieldError);
		}

		if (bindingResult.hasErrors()) {
			return "auth/new_password_input";
		}

		userService.updatePassword(newPasswordInputForm);
        redirectAttributes.addFlashAttribute("successMessage", "パスワードがリセットされました。新しいパスワードでログインを実施してください。");        


		return "redirect:/";
	}
}
