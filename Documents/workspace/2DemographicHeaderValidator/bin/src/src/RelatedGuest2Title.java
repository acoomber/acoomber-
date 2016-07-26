import java.util.List;

/**
 * Represents the related guest 2 title field
 */
public class RelatedGuest2Title extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG2_TITLE;
    }
    
    @Override
    public List<String> verify() {
        return testTitle();
    }
}