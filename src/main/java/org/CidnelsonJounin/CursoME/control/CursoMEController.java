package org.CidnelsonJounin.CursoME.control;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.CidnelsonJounin.CursoME.Form.AtualizaCursoMEForm;
import org.CidnelsonJounin.CursoME.Form.CursoMEForm;
import org.CidnelsonJounin.CursoME.dto.CursoMEDto;
import org.CidnelsonJounin.CursoME.entity.CursoME;
import org.CidnelsonJounin.CursoME.repository.CursoMERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursoME")
public class CursoMEController {
	@Autowired
	private CursoMERepository CursoRepository;

	// Read - Ler
	@GetMapping
	public List<CursoMEDto> listar() {
		List<CursoME> Cursos = CursoRepository.findAll();
		return CursoMEDto.converter(Cursos);
	}

	// Create -- Cadastrar
	@PostMapping
	@Transactional
	public void salvar(@RequestBody CursoMEForm cursoForm) {
		CursoME Curso = cursoForm.converter();
		CursoRepository.save(Curso);
	}

	// Delete -- Remover/apagar
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoMEDto> apagar(@PathVariable int id) {
		Optional<CursoME> optional = CursoRepository.findById(id);
		if (optional.isPresent()) {
			CursoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update -- Atualizar
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoMEDto> atualizar(@PathVariable int id, @RequestBody AtualizaCursoMEForm cursoForm) {
		Optional<CursoME> optional = CursoRepository.findById(id);
		if (optional.isPresent()) {
			cursoForm.atualizar(id, CursoRepository);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
