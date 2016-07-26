import java.util.List;

/**
 * Represents the related guest 1 email field
 */
public class RelatedGuest1Email extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG1_EMAIL;
    }
    
    @Override
    public List<String> verify() {
        return testEmail();
    }
}