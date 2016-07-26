import java.util.List;

/**
 * Represents the first name field
 */
public class FirstName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return FIRST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}