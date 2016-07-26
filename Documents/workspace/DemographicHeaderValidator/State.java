import java.util.ArrayList;
import java.util.List;

/**
 * Represents the state field
 */
public class State extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return STATE;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        List<String> states = getStateList();

        if(value.length()==0){
            return errors;
        }
        
        if(!states.contains(value)){
            errors.add(getFieldName() + " is invalid");
        }

        autoCorrect(errors);
        return errors;
    }
    
    private List<String> getStateList(){
        List<String> states = new ArrayList<String>();
        states.add("AL");
        states.add("AK");
        states.add("AZ");
        states.add("AR");
        states.add("CA");
        states.add("CO");
        states.add("CT");
        states.add("DE");
        states.add("DC");
        states.add("FL");
        states.add("GA");
        states.add("HI");
        states.add("ID");
        states.add("IL");
        states.add("IN");
        states.add("IA");
        states.add("KS");
        states.add("KY");
        states.add("LA");
        states.add("ME");
        states.add("MD");
        states.add("MA");
        states.add("MI");
        states.add("MN");
        states.add("MS");
        states.add("MO");
        states.add("MT");
        states.add("NE");
        states.add("NV");
        states.add("NH");
        states.add("NJ");
        states.add("NM");
        states.add("NY");
        states.add("NC");
        states.add("ND");
        states.add("OH");
        states.add("OK");
        states.add("OR");
        states.add("PA");
        states.add("PR");
        states.add("RI");
        states.add("SC");
        states.add("SD");
        states.add("TN");
        states.add("TX");
        states.add("UT");
        states.add("VT");
        states.add("VA");
        states.add("WA");
        states.add("WV");
        states.add("WI");
        states.add("WY");
        states.add("AS");
        states.add("FM");
        states.add("GU");
        states.add("MH");
        states.add("MP");
        states.add("PW");
        states.add("VI");
        states.add("AA");
        states.add("AE");
        states.add("AP");
        states.add("AB");
        states.add("BC");
        states.add("MB");
        states.add("NB");
        states.add("NL");
        states.add("NT");
        states.add("NS");
        states.add("NU");
        states.add("ON");
        states.add("PE");
        states.add("QC");
        states.add("SK");
        states.add("YT");
        return states;
    }
}