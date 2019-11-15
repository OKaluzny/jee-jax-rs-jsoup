package com.kaluzny.nasdaq.company;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Company {

    private String exchange;
    private String sectorCompany;
    private String symbolCompany;
    private String exchangePrice;
    private String marketTime;
}
