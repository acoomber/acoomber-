import java.util.List;

/**
 * Represents the custom field 2
 */
public class CustomField2 extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CUSTOM_FIELD_2;
    }
    
    @Override
    public List<String> verify() {
        return testCustomField();
    }
}