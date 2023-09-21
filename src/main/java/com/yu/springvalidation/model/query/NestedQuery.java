package com.yu.springvalidation.model.query;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class NestedQuery {

    @NotNull
    private String id;

    @Valid
    @NotNull
    private DemoQuery querys;
}
