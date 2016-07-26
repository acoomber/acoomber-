import java.util.List;

/**
 * Represents the related guest 2 email field
 */
public class RelatedGuest2Email extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG2_EMAIL;
    }
    
    @Override
    public List<String> verify() {
        return testEmail();
    }
}