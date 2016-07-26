import java.util.List;

/**
 * Represents the related guest 1 last name field
 */
public class RelatedGuest1LastName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG1_LAST_NAME;
    }
    
    @Override
    public List<String> verify() {
        return testName();
    }
}