package ProjetoIntegrador.Lumens.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoIntegrador.Lumens.Model.CategoriaModel;
import ProjetoIntegrador.Lumens.Repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable long id) {

		return categoriaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/produto/{produto}")
	public ResponseEntity<List<CategoriaModel>> getByProduto(@PathVariable String produto) {

		return ResponseEntity.ok(categoriaRepository.findALLByProdutoContainingIgnoreCase(produto));
	}

	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoriaModel(@Valid @RequestBody CategoriaModel categoriaModel){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoriaModel));
	}

	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoriaModel(@Valid @RequestBody CategoriaModel categoriaModel){

		return categoriaRepository.findById(categoriaModel.getId())
				.map(resposta -> ResponseEntity.ok().body(categoriaRepository.save(categoriaModel)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoriaModel(@PathVariable long id){
		return categoriaRepository.findById(id)
				.map(resposta ->{
					categoriaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	
	
}
	}
