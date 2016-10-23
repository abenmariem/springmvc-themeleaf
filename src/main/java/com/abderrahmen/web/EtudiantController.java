package com.abderrahmen.web;

import java.io.File;
import java.io.FileInputStream;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.abderrahmen.dao.EtudiantRepository;
import com.abderrahmen.entities.Etudiant;

@Controller
@RequestMapping(value = "/etudiant")
public class EtudiantController {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Value("${dir.images}")
	private String dirImages;

	@RequestMapping(value = "/Index")
	public String Index(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "motCle", defaultValue = "") String motCle) {

		Page<Etudiant> pageEtudiants = etudiantRepository.chercherEtudiants("%" + motCle + "%",
				new PageRequest(page, 5));

		int pagesCount = pageEtudiants.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);

		model.addAttribute("pageCourante", page);

		model.addAttribute("pageEtudiants", pageEtudiants);

		model.addAttribute("motCle", motCle);
		return "etudiants";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)

	public String formEtudiant(Model model) {

		Etudiant et = new Etudiant();
		model.addAttribute("etudiant", et);

		return "formEtudiant";
	}

	@RequestMapping(value = "/saveEtudiant", method = RequestMethod.POST)

	public Object saveEtudiant(@Valid Etudiant et, BindingResult bindingResult, @RequestParam(value="picture") MultipartFile file) throws Exception {

		if (bindingResult.hasErrors()) {
			return "formEtudiant";
		}

		if(! file.isEmpty()){
			et.setPhoto(file.getOriginalFilename());
		}
		
		etudiantRepository.save(et);
		
		if(! file.isEmpty()){
			et.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(dirImages+et.getId()));
		}
		
		return "redirect:Index";
	}

	@RequestMapping(value = "/getPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //envoie des donnees dans le corps de la reponse
	public byte[] getPhoto(Long id) throws Exception{
		
		File file = new File(dirImages+id);
		
		return IOUtils.toByteArray(new FileInputStream(file));
		
	}
	
	
	@RequestMapping(value = "/supprimer")
	public String supprimer(Long id){
		
		etudiantRepository.delete(id);
		return "redirect:Index";
	}
	
	@RequestMapping(value = "/editer")
	public String edit(Long id, Model model){
		Etudiant e = etudiantRepository.getOne(id);
		model.addAttribute("etudiant", e);
		return "editEtudiant";
	}
	
	
	@RequestMapping(value = "/updateEtudiant", method = RequestMethod.POST)

	public Object updateEtudiant(@Valid Etudiant et, BindingResult bindingResult, @RequestParam(value="picture") MultipartFile file) throws Exception {

		if (bindingResult.hasErrors()) {
			return "editEtudiant";
		}

		if(! file.isEmpty()){
			et.setPhoto(file.getOriginalFilename());
		}
		
		etudiantRepository.save(et);
		
		if(! file.isEmpty()){
			et.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(dirImages+et.getId()));
		}
		
		return "redirect:Index";
	}
	
	
	
	
}
