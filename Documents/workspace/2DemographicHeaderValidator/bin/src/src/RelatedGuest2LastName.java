import java.util.List;

/**
 * Represents the related guest 2 last name field
 */
public class RelatedGuest2LastName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG2_LAST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}