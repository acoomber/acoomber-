import java.util.List;

/**
 * Represents the custom field 3
 */
public class CustomField3 extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CUSTOM_FIELD_3;
    }
    
    @Override
    public List<String> verify() {
        return testCustomField();
    }
}