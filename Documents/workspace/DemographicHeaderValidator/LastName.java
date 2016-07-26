import java.util.List;

/**
 * Represents the last name field
 */
public class LastName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return LAST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}