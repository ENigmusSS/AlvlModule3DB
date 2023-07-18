package ua.golovchenko.phoneoperator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Devices" )
public class Device {
    @Id
    @Column(name = "model")
    private String model;
    @ManyToMany(mappedBy = "devices")
    Set<Abonent> abonentSet = new HashSet<>();

    @Override
    public String toString() {
        return "Device{" +
                "model='" + model + '\'' +
                ", abonentSet=" + abonentSet +
                '}';
    }
}
