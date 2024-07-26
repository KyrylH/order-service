package com.kyrylh.orderservice.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class OrderRequest {
    @NotNull
    @Length(min = 3, max = 40)
    String surname;
    @NotNull
    @Length(min = 3, max = 60)
    String productName;
    @NotNull
    @Min(1)
    Integer productCount;
}
