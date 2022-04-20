package ma.sofadev.microservice.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ma.sofadev.microservice.entities.Produit;
import ma.sofadev.microservice.repository.ProduitRepository;

@Service
@AllArgsConstructor
public class ProduitService {

	private ProduitRepository produitRepository;

	public Iterable<Produit> getAllProducts() {
		return produitRepository.findAll();
	}

	public Optional<Produit> getProductById(Long idProduct) {
		return produitRepository.findById(idProduct);
	}

	public void deleteProduct(final Long id) {
		produitRepository.deleteById(id);
	}

	public Produit saveProduit(Produit produit) {
		Produit savedProduit = produitRepository.save(produit);
		return savedProduit;
	}

}
