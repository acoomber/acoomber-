import java.util.List;

/**
 * Represents the related guest 3 email failed field
 */
public class RelatedGuest3EmailFailed extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG3_EMAIL_FAILED;
    }
    
    @Override
    public List<String> verify() {
        return testBoolean();
    }
}