package com.cd.zjyf.component;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * Created by chen.shuodong on 2018/6/28.
 */
@Component
public class StringOfYearQuery implements TemporalQuery<String>{
@Override
public String queryFrom(TemporalAccessor temporal) {
        LocalDate now = LocalDate.from(temporal);

        if (now.isBefore(now.with(Month.APRIL).withDayOfMonth(1))) {
        return "1";
        } else if (now.isBefore(now.with(Month.JULY).withDayOfMonth(1))) {
        return "2";
        } else if (now.isBefore(now.with(Month.NOVEMBER).withDayOfMonth(1))) {
        return "3";
        } else {
        return "4";
        }
        }





}
