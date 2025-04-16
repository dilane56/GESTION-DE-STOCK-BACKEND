package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.VentesDto;
import org.kfokam48.gestiondestockbackend.model.Ventes;
import org.modelmapper.ModelMapper;

public class VentesMapper {
    private final ModelMapper modelMapper;

    public VentesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Ventes ventesDtoToVentes(VentesDto ventesDto) {
        return modelMapper.map(ventesDto, Ventes.class);
    }

    public Ventes ventesToVentes(Ventes ventesDto) {
        return modelMapper.map(ventesDto, Ventes.class);
    }
}
