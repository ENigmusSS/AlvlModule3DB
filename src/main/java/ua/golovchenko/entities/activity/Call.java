package ua.golovchenko.entities.activity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ua.golovchenko.entities.Abonent;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

@NoArgsConstructor
@Entity(name = "calls_log")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String CallID;
    @OneToOne
    private Abonent caller;
    @OneToOne
    private Abonent receiver;
    @Column(name = "call_starttime")
    private LocalDateTime callStartTime;
    @Column(name = "call_endtime")
    private LocalDateTime callEndTime;
    @Column(name = "call_length")
    private long callLenth = callEndTime.getLong(ChronoField.SECOND_OF_DAY)
            - callStartTime.getLong(ChronoField.SECOND_OF_DAY);

}
