package ua.golovchenko.entities.activity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity(name = "SMS_Storage")
public class SMS {
    @Column(name = "SMS_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDgenerator")
    private String sms_ID;
    @Column(name = "time_send")
    private LocalDateTime timeSend;

}
