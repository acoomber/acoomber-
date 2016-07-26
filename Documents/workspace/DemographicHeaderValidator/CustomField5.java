import java.util.List;

/**
 * Represents the custom field 5
 */
public class CustomField5 extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CUSTOM_FIELD_5;
    }
    
    @Override
    public List<String> verify() {
        return testCustomField();
    }
}