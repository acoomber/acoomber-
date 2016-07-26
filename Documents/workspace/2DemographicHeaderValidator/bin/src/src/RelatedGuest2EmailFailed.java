import java.util.List;

/**
 * Represents the related guest 2 email failed field
 */
public class RelatedGuest2EmailFailed extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG2_EMAIL_FAILED;
    }
    
    @Override
    public List<String> verify() {
        return testBoolean();
    }
}