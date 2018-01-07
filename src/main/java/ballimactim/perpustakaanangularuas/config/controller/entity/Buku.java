/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballimactim.perpustakaanangularuas.config.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AguzR
 */
@Entity
public class Buku {
    
    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String judul_buku;
    
    @Column @Getter @Setter
    private String penulis;
    
}
