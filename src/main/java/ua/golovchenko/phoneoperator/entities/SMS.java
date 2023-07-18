package ua.golovchenko.phoneoperator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "SMS_Storage")
public class SMS {
    @Override
    public String toString() {
        return "SMS{" +
                "sms_ID='" + sms_ID + '\'' +
                ", abonent=" + abonent +
                ", receiver='" + receiver + '\'' +
                ", timeSend=" + timeSend +
                ", text='" + text + '\'' +
                '}';
    }

    @Column(name = "SMS_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String sms_ID;
    @ManyToOne
    @JoinColumn(name = "abonent_number")
    private Abonent abonent;
    @Column(name = "receiver", length = 10)
    private String receiver;
    @Column(name = "time_send")
    private LocalDateTime timeSend;
    @Column(name = "text")
    private String text;
}
