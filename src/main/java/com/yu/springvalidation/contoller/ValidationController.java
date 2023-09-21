package com.yu.springvalidation.contoller;

import com.yu.springvalidation.model.query.CalendarRecord;
import com.yu.springvalidation.model.query.DemoQuery;
import com.yu.springvalidation.model.query.NestedQuery;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 在controller类上使用validated，将开启所有的路径参数验证，对body无效
 */
@RestController
@Validated
public class ValidationController {

    /**
     * body验证Valid和Validated都可以，方法上无效,类上无效
     * @param query
     * @return
     */
    @PostMapping("/post")
    @Validated
    public String post(@RequestBody DemoQuery query) {
        System.out.println("name = " + query.getName());
        System.out.println("age = " + query.getAge());
        return "ok";
    }


    @PostMapping("/post2")
    public String post2(@RequestBody DemoQuery query, @NotNull String id) {
        System.out.println("name = " + query.getName());
        System.out.println("age = " + query.getAge());
        System.out.println("id = " + id);
        return "ok";
    }

    @GetMapping("/get")
    public String get( @NotNull @Length(max = 10, min = 2) String name, @NotNull @Min(10) @Max(100) String age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "ok";
    }

    /**
     * 形参上单独类型的验证，无效,必须是类上使用validated
     * @param name
     * @return
     */
    @GetMapping("/get2")
    @Validated
    @Valid
    public String get2(@Validated @Valid @NotNull @Length(max = 10, min = 2) String name) {
        System.out.println("name = " + name);
        return "ok";
    }


    /**
     * 验证validated类和参数上在get的形参上，无效
     * @param query
     * @return
     */
    @GetMapping("get3")
    public String get3(@Validated DemoQuery query) {
        System.out.println("name = " + query.getName());
        System.out.println("age = " + query.getAge());
        return "ok";
    }

    @PostMapping("/record")
    public String recordTest(@Valid @RequestBody CalendarRecord query) {
        System.out.println("name = " + query.startDate());
        System.out.println("age = " + query.endDate());
        return "ok";
    }

    @GetMapping("/nested")
    public String nested(@Validated NestedQuery query, BindingResult bindingResult) {
        Assert.isTrue(!bindingResult.hasErrors(),"参数错误");
        System.out.println("id = " + query.getId());
        System.out.println("query = " + query.getQuerys());
        System.out.println(bindingResult);
        return "ok";
    }


}
