package stepDefinition;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

public class FormDataConfigurer implements TypeRegistryConfigurer {
    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(RandomData.class, (TableEntryTransformer<RandomData>) map -> new RandomData(map.get("Arbit"), map.get("Value"))));
    }
}
