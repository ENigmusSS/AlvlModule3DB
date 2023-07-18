package ua.golovchenko.phoneoperator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Tariffs")
public class Tariff {
    @Override
    public String toString() {
        return "Tariff{" +
                "tariffName='" + tariffName + '\'' +
                ", price=" + price +
                ", internetTraffic=" + internetTraffic +
                ", callsLimit=" + callsLimit +
                ", smsLimit=" + smsLimit +
                ", abonentList=" + abonentList +
                '}';
    }

    @Id
    @Column(name = "tariff_name")
    private String tariffName;
    @Column(name = "tariff_price")
    private int price;
    @Column(name = "internet_traffic")
    private int internetTraffic;
    @Column(name = "calls_limit")
    private long callsLimit;
    @Column(name = "sms_limit")
    private int smsLimit;
    @OneToMany(mappedBy = "tariff", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<Abonent> abonentList;
}
