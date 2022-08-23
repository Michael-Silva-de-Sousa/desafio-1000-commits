package beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Carro {
    private Integer id;
    private String make;
    private String model;
    private String color;
    private Integer year;
    private Double price;
}
