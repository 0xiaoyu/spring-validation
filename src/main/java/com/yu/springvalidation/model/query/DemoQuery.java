package com.yu.springvalidation.model.query;

import com.yu.springvalidation.common.groups.Demo1;
import com.yu.springvalidation.common.groups.Demo2;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Data
//@Valid
//@Validated
public class DemoQuery {
//    @Length(max = 10, min = 2,groups = {Demo1.class, Demo2.class},message = "name长度不符合要求")
    @NotNull
    private String name;
    @Min(value = 10,groups = {Demo1.class}) @Max(100)
    @NotNull
    private Integer age;
}
