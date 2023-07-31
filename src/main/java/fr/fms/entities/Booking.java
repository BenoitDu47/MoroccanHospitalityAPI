package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstNameOfLessor;
    private String lastNameOfLessor;
    private String phoneNameOfLessor;
    private String mailNameOfLessor;
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private int totalPrise;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
