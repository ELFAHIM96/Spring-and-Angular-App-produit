package org.sid.sp_produit;

import org.sid.sp_produit.dao.ProduitRepository;
import org.sid.sp_produit.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class SpProduitApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(SpProduitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"Ordinateur Lx 45", 6700, 3));
		produitRepository.save(new Produit(null,"Impriment HP", 6700, 3));
		produitRepository.save(new Produit(null,"Smart phone LG", 700, 4));
		
		produitRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		
	}

}
