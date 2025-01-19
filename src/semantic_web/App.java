package semantic_web;

import java.util.Arrays;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;

public class App {

    static String ontologyFile = "project-management.owl";
    static String theQuery = OntologyQueries.WHO_FUNDS_A_GIVEN_PROJECT;

    public static void main(String[] args) throws Exception {

        Model model = RDFDataMgr.loadModel(ontologyFile);
        Dataset dataset = DatasetFactory.create(model);
        try {
            executeQuery(theQuery, dataset);
        } finally {
            model.close();
            dataset.close();
        }
    }

    public static void executeQuery(String queryString, Dataset dataset) {
        Query query = QueryFactory.create(queryString);
        QueryExecution queryExecution = QueryExecutionFactory.create(query, dataset);

        try {
            if (queryString.contains("SELECT")) {
                String[] variables = getSelectVariables(queryString);

                ResultSet results = queryExecution.execSelect();
                while (results.hasNext()) {
                    QuerySolution solution = results.nextSolution();

                    System.out.println("------------");
                    for (String variable : variables) {
                        System.out.println(variable + ": " + solution.get(variable));
                    }
                }
            } else if (queryString.contains("ASK")) {
                System.out.println("------------");
                boolean result = queryExecution.execAsk();
                System.out.println(result);
            }
        } finally {
            queryExecution.close();
            dataset.close();
            System.out.println("------------");
        }
    }

    public static String[] getSelectVariables(String queryString) {
        String[] lines = queryString.split("\n");

        for (String line : lines) {
            if (line.trim().startsWith("SELECT")) {
                String[] lineItems = line.split(" \\?");
                String[] queryVariables = Arrays.copyOfRange(lineItems, 1, lineItems.length);
                return queryVariables;
            }
        }

        return new String[] {};
    }
}
