package semantic_web;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class App {

    static String personalURI = "http://somewhere/JohnSmith";
    static String fullName     = "John Smith";

    public static void main(String[] args) throws Exception {
        Model model = ModelFactory.createDefaultModel();

        Resource johnSmith = model.createResource(personalURI);

        johnSmith.addProperty(VCARD.FN, fullName);
    }
}
