package episen.pds.citizens.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private Integer id_house;
    private String address;
    private Integer id_owner;
}
