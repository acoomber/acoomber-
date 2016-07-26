import java.util.List;

/**
 * Represents the email field
 */
public class Email extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return EMAIL;
    }
    
    @Override
    public List<String> verify() {
        return testEmail();
    }
}