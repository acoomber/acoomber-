import java.util.List;

/**
 * Represents the custom field 6
 */
public class CustomField6 extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CUSTOM_FIELD_6;
    }
    
    @Override
    public List<String> verify() {
        return testCustomField();
    }
}