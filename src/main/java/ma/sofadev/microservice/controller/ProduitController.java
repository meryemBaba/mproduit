package ma.sofadev.microservice.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.sofadev.microservice.entities.Produit;
import ma.sofadev.microservice.service.ProduitService;

@RestController
@AllArgsConstructor
public class ProduitController {

	private ProduitService produitService;

	@GetMapping("/produits")
	public Iterable<Produit> getAllProducts() {
		return produitService.getAllProducts();
	}

	@GetMapping("/produit/{id}")
	public Produit getProductById(@PathVariable("id") final Long id) {
		Optional<Produit> produit = produitService.getProductById(id);

		if (!produit.isPresent())
			return null;
		return produit.get();

	}

	/**
	 * Create - Add a new product
	 * 
	 * @param product An object product
	 * @return product saved
	 */
	@PostMapping("/produit")
	public Produit createProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
	}

	@PutMapping("/produit/{id}")
	public Produit updateProduit(@PathVariable("id") final Long id, @RequestBody Produit produit) {

		Optional<Produit> p = produitService.getProductById(id);
		if (!p.isPresent())
			return null;
		Produit currentProduit = p.get();

		String nom = produit.getNom();
		if (nom != null) {
			currentProduit.setNom(nom);
		}
		String description = produit.getDescription();
		if (description != null) {
			currentProduit.setDescription(description);
			;
		}
		double prix = produit.getPrix();
		currentProduit.setPrix(prix);

		produitService.saveProduit(currentProduit);
		return currentProduit;

	}
	
	
	@DeleteMapping("/produit/{id}")
	public void deleteProduit(@PathVariable("id") final Long id) {
		produitService.deleteProduct(id);
	}
}
