package com.hkjava.demo.demoshopping.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
  private long id;
  private long customerId;
  private List<Item> items;
}
