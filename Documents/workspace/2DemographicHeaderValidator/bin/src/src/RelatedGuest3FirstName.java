import java.util.List;

/**
 * Represents the related guest 3 first name field
 */
public class RelatedGuest3FirstName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG3_FIRST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}