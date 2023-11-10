package com.hkjava.demo.democalculator.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.democalculator.controller.CalculatorOperation;
import com.hkjava.demo.democalculator.service.CalculatorService;

// @Controller
// @ResponseBody
@RestController // @Controller + @ResponseBody
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  CalculatorService calculatorService;

  @Override
  public List<String> getStrings() {
    return calculatorService.getStrings();
  }

  @Override
  public Integer add(int salary, int bonus, String divided, int k) {
    int d = 0;
    try {
      d = Integer.valueOf(divided); //
    } catch (NumberFormatException e) {
      d = 0;
    }
    return calculatorService.add(salary + bonus, d + k);
  }

  @Override
  public Integer substract(int salary, int y, String z) {
    return calculatorService.substract(salary - y, 0);
  }

}
