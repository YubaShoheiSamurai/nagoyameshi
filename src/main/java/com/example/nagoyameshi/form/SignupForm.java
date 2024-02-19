package com.example.nagoyameshi.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(message = "氏名を入力してください。")
    private String name;
    
    @NotBlank(message = "フリガナを入力してください。")
    private String furigana;
    
    @NotNull(message = "性別を選択してください。")
    private Integer sex;
    
    private Integer birthdayYear;
    
    private Integer birthdayMonth;
    
    private Integer birthdayDay;
    
    @Pattern(regexp = "[0-9]{3}-?[0-9]{4}", message = "郵便番号の形式で入力してください。")
    private String postalCode;
    
    private String address;
    
    @NotBlank(message = "電話番号を入力してください。")
    private String phoneNumber;
    
    @NotBlank(message = "メールアドレスを入力してください。")
    @Email(message = "メールアドレスは正しい形式で入力してください。")
    private String email;
    
    @NotBlank(message = "パスワードを入力してください。")
    @Length(min = 8, message = "パスワードは8文字以上で入力してください。")
    private String password;    
    
    @NotBlank(message = "パスワード（確認用）を入力してください。")
    private String passwordConfirmation; 
    
    @AssertTrue(message = "生年月日入力してください")
    public boolean isNotBlankBirthday(){
        if (birthdayYear == null || birthdayMonth == null || birthdayDay == null) {
            return false;
        }
        return true;
    }
}
