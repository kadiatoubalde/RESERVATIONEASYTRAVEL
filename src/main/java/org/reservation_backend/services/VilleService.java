package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.VilleDto;
import org.reservation_backend.models.Ville;

public interface VilleService {
	
	VilleDto addVille(VilleDto villeDto) ;
	VilleDto updateVille(VilleDto villeDto,String uuid);
	VilleDto getVille(String uuid);
	List<VilleDto> listeVille();
	boolean deleteVille(String uuid);
	public Ville findByUuid(String uuid);
}
	
 
	 

