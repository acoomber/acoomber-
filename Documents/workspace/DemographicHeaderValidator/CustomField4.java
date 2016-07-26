import java.util.List;

/**
 * Represents the custom field 4
 */
public class CustomField4 extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CUSTOM_FIELD_4;
    }
    
    @Override
    public List<String> verify() {
        return testCustomField();
    }
}