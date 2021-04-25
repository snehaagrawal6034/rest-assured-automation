package stepDefinition;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import models.FormData;

import java.util.Map;

public class  DataRegistryConfigurer implements TypeRegistryConfigurer {
    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(FormData.class, new TableEntryTransformer<FormData>() {
            @Override
            public FormData transform(Map<String, String> map) throws Throwable {
                return new FormData(map.get("Arbit"), map.get("Value"));
            }
        }));
    }
}
