import java.util.List;

/**
 * Represents the custom field 1
 */
public class CustomField1 extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CUSTOM_FIELD_1;
    }
    
    @Override
    public List<String> verify() {
        return testCustomField();
    }
}