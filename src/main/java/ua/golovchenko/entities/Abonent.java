package ua.golovchenko.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ua.golovchenko.entities.activity.SMS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Abonents")
public class Abonent {
    @Id
    @Column(name = "abonent_number")
    private String number;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "devices")
    private ArrayList<String> devices;
    @Column(name = "sms_log")
    @OneToMany(mappedBy = "abonent", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<SMS> smsLog;

}
