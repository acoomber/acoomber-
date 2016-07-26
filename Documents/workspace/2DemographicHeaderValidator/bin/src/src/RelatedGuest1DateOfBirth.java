import java.util.List;

/**
 * Represents the related guest 1 date of birth field
 */
public class RelatedGuest1DateOfBirth extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG1_DATE_OF_BIRTH;
    }
    
    @Override
    public List<String> verify() {
        return testDate(true);
    }
}