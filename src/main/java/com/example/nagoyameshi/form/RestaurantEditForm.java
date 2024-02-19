package com.example.nagoyameshi.form;

import java.time.LocalTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantEditForm {
	
	@NotNull
    private Integer id;
	
	@NotBlank(message = "店舗名を入力してください。")
    private String name;
        
    private MultipartFile imageFile;
    
    @NotBlank(message = "説明を入力してください。")
    private String description;
    
    @NotNull(message = "最低価格を入力してください。")
    @Min(value = 1, message = "最低価格は1円以上に設定してください。")
    private Integer lowPrice;
    
    @NotNull(message = "最高価格を入力してください。")
    @Min(value = 1, message = "最高価格は1円以上に設定してください。")
    private Integer highPrice;
    
    @NotBlank(message = "郵便番号を入力してください。")
    @Pattern(regexp = "[0-9]{3}-?[0-9]{4}", message = "郵便番号の形式で入力してください。")
    private String postalCode;
    
    @NotBlank(message = "住所を入力してください。")
    private String address;
    
    @NotNull(message = "開店時間を入力してください。")
    private LocalTime openingTime;
    
    @NotNull(message = "閉店時間を入力してください。")
    private LocalTime closedTime;
    
    private Integer[] regulars;
    
    @NotNull(message = "座席数を入力してください。")
    @Min(value = 1, message = "座席数は1人以上に設定してください。")
    private Integer seatingCapacity; 
    
    private Integer[] categories;
    
    @AssertTrue(message = "最低価格は最高価格より低い金額を入力してください")
    public boolean isComparePrice(){
        if (lowPrice != null && highPrice != null && lowPrice > highPrice) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message = "開店時間は閉店時間より早い時間を入力してください")
    public boolean isCompareTime(){
        if (openingTime != null && closedTime != null &&  openingTime.isAfter(closedTime)) {
            return false;
        }
        return true;
    }

}
