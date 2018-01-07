/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballimactim.perpustakaanangularuas.config.controller.entity.repo;

import ballimactim.perpustakaanangularuas.config.controller.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AguzR
 */
@Repository
public interface BukuRepo extends JpaRepository<Buku, String> {
	Buku findOneById(String id);
    
    
}
