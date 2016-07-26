import java.util.List;

/**
 * Represents the email failed field
 */
public class EmailFailed extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return EMAIL_FAILED;
    }
    
    @Override
    public List<String> verify() {
        return testBoolean();
    }
}