import java.util.List;

/**
 * Represents the mobile phone field
 */
public class MobilePhone extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return MOBILE_PHONE;
    }
    
    @Override
    public List<String> verify() {
        return testPhoneNumber();
    }
}