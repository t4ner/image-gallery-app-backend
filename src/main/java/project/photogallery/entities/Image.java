package project.photogallery.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    private String type;

    @Column(length = 50000000)
    @Lob
    private byte[] file;

    public Image(String name, String type, byte[] file) {
        this.name = name;
        this.type = type;
        this.file = file;
    }
}