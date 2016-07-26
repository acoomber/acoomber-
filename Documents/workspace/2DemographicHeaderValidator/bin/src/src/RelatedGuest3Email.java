import java.util.List;

/**
 * Represents the related guest 3 email field
 */
public class RelatedGuest3Email extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG3_EMAIL;
    }
    
    @Override
    public List<String> verify() {
        return testEmail();
    }
}