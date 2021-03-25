package com.GestionParc.Gestion_Parc.DTO.Mapping.BaseDtoConvert;

import java.util.List;

abstract public class BaseDTOConverter<T,E> {

    public abstract   T convertToDTO(E entity);
    public abstract   E convertToEntity (T dto);
    public abstract   List<T> convertToListDTO (List<E> entity);

}
