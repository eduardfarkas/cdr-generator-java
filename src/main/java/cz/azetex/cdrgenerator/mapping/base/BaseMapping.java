package cz.azetex.cdrgenerator.mapping.base;

public interface BaseMapping<E, D> {

    D toDto(E entity);

    E toEntity(D dto);

}
