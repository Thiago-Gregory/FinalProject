package thiagoyasmin.releasedconsoles.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author Thiago Araújo
 * @author Yasmin Luzia
 * @since 01/05/2020
 * @version 1.0
 */

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

@Entity
@Table(name = "consoles")
public class ConsoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_console")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "units_sold")
    private int unitSold;

    @Column(name = "release_year")
    private int release_year;

    @Column(name = "initial_price")
    private double initial_price;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "memory")
    private String memory;

    @Column(name = "storage")
    private String storage;

    @Column(name = "generation")
    private byte generation;
}
