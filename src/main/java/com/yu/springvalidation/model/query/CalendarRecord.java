package com.yu.springvalidation.model.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ScriptAssert;

import java.util.Date;

/**
 * 对record支持
 * ScriptAssert的实例
 * @param startDate
 * @param endDate
 */
@ScriptAssert(lang = "javascript", script = "_this.startDate.before(_this.endDate)")
public record CalendarRecord
        (@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
         @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date endDate)
{
}