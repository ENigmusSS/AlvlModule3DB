package ua.golovchenko.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tariffs")
public class Tariff {
    @Id
    @Column(name = "tariff_name")
    private String tariffName;
    @Column(name = "tariff_price")
    private double price;
    @Column(name = "internet_traffic")
    private int internetTraffic;
    @Column(name = "calls_limit")
    private long callsLimit;
    @Column(name = "sms_limit")
    private int smsLimit;
    @OneToMany(mappedBy = "tariff", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Abonent> abonentList;
}
