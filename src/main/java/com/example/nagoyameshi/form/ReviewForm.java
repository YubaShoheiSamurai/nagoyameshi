package com.example.nagoyameshi.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewForm {

    private Integer id;
	
	@NotBlank(message = "感想を入力してください。")
    private String comment;

    @NotNull(message = "評価を選択してください。")
    private Integer review;
}
