package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathalogy")
public class PathalogyResource {

	List<Disease> diseases = Arrays.asList(
			new Disease("D1","Astama","Warm water bath"),
			new Disease("D2","Headache","Hot water bath"),
			new Disease("D3","Corona","Stay home")
			);
	
	@RequestMapping("/diseases")
	public DiseaseList diseases() {
		DiseaseList diseaseList = new DiseaseList();
		diseaseList.setDiseases(diseases);
		return diseaseList;
	}
	
	@RequestMapping("/diseases/{id}")
	public Disease getDiseasesById(@PathVariable("id") String id) {
		Disease e = diseases.stream().filter(disease->id.equals(disease.getId())).findAny().orElse(null);
		
		return e;
	}
}
