package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.MvtStkDto;
import org.kfokam48.gestiondestockbackend.model.MvtStk;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MvtStkMapper {
    private final ModelMapper modelMapper;

    public MvtStkMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MvtStk mvtStkDtotoMvtStk(MvtStkDto mvtStk) {
        return modelMapper.map(mvtStk, MvtStk.class);
    }

    public MvtStkDto mvtStkToMvtStkDto(MvtStk mvtStk) {
        return modelMapper.map(mvtStk, MvtStkDto.class);
    }
}
