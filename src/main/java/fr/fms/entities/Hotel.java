package fr.fms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private int stars;
    private int price;
    private int numberOfRoom;
    private String photo;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Booking> bookingList;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
