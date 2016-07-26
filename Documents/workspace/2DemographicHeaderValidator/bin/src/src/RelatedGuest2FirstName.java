import java.util.List;

/**
 * Represents the related guest 2 first name field
 */
public class RelatedGuest2FirstName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG2_FIRST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}