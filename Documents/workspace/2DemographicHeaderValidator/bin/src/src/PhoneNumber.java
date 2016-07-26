import java.util.List;

/**
 * Represents the phone number field
 */
public class PhoneNumber extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return PHONE_NUMBER;
    }
    
    @Override
    public List<String> verify() {
        return testPhoneNumber();
    }
}