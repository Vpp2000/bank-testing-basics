package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@Builder
public class Account {
    private String person;
    private BigDecimal balance;
}
