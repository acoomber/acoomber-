import java.util.List;

/**
 * Represents the related guest 2 date of birth field
 */
public class RelatedGuest2DateOfBirth extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG2_DATE_OF_BIRTH;
    }
    
    @Override
    public List<String> verify() {
        return testDate(true);
    }
}