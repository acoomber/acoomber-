import java.util.List;

/**
 * Represents the related guest 3 last name field
 */
public class RelatedGuest3LastName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG3_LAST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}