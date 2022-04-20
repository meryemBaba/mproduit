package ma.sofadev.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import ma.sofadev.microservice.entities.Produit;

@Controller
public interface ProduitRepository  extends CrudRepository<Produit, Long>{

}
