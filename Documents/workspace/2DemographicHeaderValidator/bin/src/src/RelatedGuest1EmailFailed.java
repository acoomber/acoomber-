import java.util.List;

/**
 * Represents the related guest 1 email failed field
 */
public class RelatedGuest1EmailFailed extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG1_EMAIL_FAILED;
    }
    
    @Override
    public List<String> verify() {
        return testBoolean();
    }
}