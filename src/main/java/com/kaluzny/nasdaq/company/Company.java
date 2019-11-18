package com.kaluzny.nasdaq.company;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Company {

    private String exchange;
    private String sectorCompany;
    private String symbolCompany;
    private String exchangePrice;
    private String marketTime;
}
