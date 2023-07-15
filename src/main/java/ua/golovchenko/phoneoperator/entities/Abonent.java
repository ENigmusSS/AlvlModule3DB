package ua.golovchenko.phoneoperator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Abonents")
public class Abonent {
    @Override
    public String toString() {
        return "Abonent{" +
                "number='" + number + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", devices=" + devices +
                ", tariff=" + tariff +
                ", smsLog=" + smsLog +
                ", callsLength=" + callsLength +
                ", trafficConsumed=" + trafficConsumed +
                '}';
    }

    @Id
    @Column(name = "abonent_number", length = 10)
    private String number;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "tariff_name")
    private Tariff tariff;
    @Column(name = "sms_log")
    @OneToMany(mappedBy = "abonent_number", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<SMS> smsLog;
    @Column(name = "calls_length")
    private long callsLength;
    @Column(name = "traffic_consumed")
    private long trafficConsumed;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "Abonent_Device",
            joinColumns = @JoinColumn(name = "abonent_number"),
            inverseJoinColumns = @JoinColumn(name = "model")
    )
    Set<Device> devices = new HashSet<>();
}