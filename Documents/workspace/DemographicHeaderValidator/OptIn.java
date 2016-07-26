import java.util.List;

/**
 * Represents the opt-in field
 */
public class OptIn extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return OPT_IN;
    }
    
    @Override
    public List<String> verify() {
        return testBoolean();
    }
}