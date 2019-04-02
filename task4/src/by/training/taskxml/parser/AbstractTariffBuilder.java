package by.training.taskxml.parser;

import by.training.taskxml.entity.tariffs.TariffType;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTariffBuilder {
    protected Set<TariffType> tariffs;
    public AbstractTariffBuilder() {
        tariffs = new HashSet<>();
    }
    public AbstractTariffBuilder(Set<TariffType> tariffs) {
        this.tariffs = tariffs;
    }

    public Set<TariffType> getTariffs() {
        return tariffs;
    }
    abstract public void buildSetTariffType(String fileName);
}
