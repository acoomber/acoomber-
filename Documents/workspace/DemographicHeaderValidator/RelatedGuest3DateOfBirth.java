import java.util.List;

/**
 * Represents the related guest 3 date of birth field
 */
public class RelatedGuest3DateOfBirth extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG3_DATE_OF_BIRTH;
    }
    
    @Override
    public List<String> verify() {
        return testDate(true);
    }
}