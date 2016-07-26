import java.util.List;

/**
 * Represents the related guest 1 first name field
 */
public class RelatedGuest1FirstName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG1_FIRST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}