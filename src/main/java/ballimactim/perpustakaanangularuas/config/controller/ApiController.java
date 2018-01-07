/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballimactim.perpustakaanangularuas.config.controller;

import ballimactim.perpustakaanangularuas.config.controller.entity.Buku;
import ballimactim.perpustakaanangularuas.config.controller.entity.repo.BukuRepo;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 *
 * @author AguzR
 */
@RestController
public class ApiController {

	@RequestMapping("/get-nama")
	public Map<String, Object> getNama(){
		Map<String, Object> result = new HashMap();
		result.put("nama", "Agus");

		return result;
	}
        @Autowired
        private BukuRepo bukuRepo;

	//-- aplikasi mahasiswa 
	@RequestMapping("/daftar-buku")
        public List<Buku> ambilDaftarBuku(){
            return bukuRepo.findAll();
        }

    @RequestMapping(value = "/tambah-buku", method = RequestMethod.POST)
    public void tambahData(@RequestBody Buku bk){
    	bukuRepo.save(bk);
    }

    @RequestMapping("/get-bk-by-id/{id}")
    public Buku getBkById(@PathVariable("id") String id) {
    	return bukuRepo.findOneById(id);
    }

    @RequestMapping(value = "/hapus-data/{id}", method = RequestMethod.DELETE)
    public void hapusData(@PathVariable("id") String id){
        bukuRepo.delete(id);
    }


    @RequestMapping("/keluar")
    public void keluar(HttpServletRequest req, 
        HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder
            .getContext().getAuthentication();
        new SecurityContextLogoutHandler()
            .logout(req, resp, auth);
    }


}