package semantic_web;

public class OntologyQueries {

    public static final String MEMBERS_OF_A_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectName ?member ?memberName
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName .
                FILTER regex(?projectName, "^Project Nexus$") .
                ?project :hasProjectMember ?member .
                ?member :hasMemberName ?memberName
            }
            """;

    public static final String PROJECT_MANAGER_MANAGES_A_GIVEN_PROJECT_MEMBER = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?project ?member ?projectManager
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectMember ?member .
                {
                    ?member :managedBy ?projectManager .
                }
                UNION
                {
                    ?projectManager :manages ?member .
                }
            }
            """;

    public static final String WHO_FUNDS_A_GIVEN_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?stakeholderName ?stakeholderType ?project
            WHERE {
                ?stakeholderType rdfs:subClassOf :Stakeholder .
                ?stakeholder rdf:type ?stakeholderType .
                ?stakeholder :hasStakeholderName ?stakeholderName .
                {
                    ?stakeholder :funds ?project .
                }
                UNION
                {
                    ?project :fundedBy ?stakeholder .
                }
            }
            """;

    public static final String BUDGET_OF_A_GIVEN_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectName ?budget
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName .
               ?project :hasBudget ?budget
            }
            """;

    public static final String START_AND_END_DATE_FOR_A_GIVEN_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectName ?startDate ?endDate
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName .
                ?project :hasStartDate ?startDate .
                ?project :hasEndDate ?endDate
            }
            """;

    public static final String PROJECT_MANAGER_MANAGES_WHICH_PROJECTS = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectManagerName ?projectName
            WHERE {
                ?projectManager rdf:type :ProjectManager .
                ?projectManager :hasMemberName ?projectManagerName .
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName
                {
                    ?project :managedBy ?projectManager .
                }
                UNION
                {
                    ?projectManager :manages ?project .
                }
            }
            """;

    public static final String PHASES_OF_A_PROJECT_AND_DURATION = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectName ?phase ?phaseType ?phaseDuration
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName .
                ?project :hasPhase ?phase .
                ?phase rdf:type ?phaseType .
                ?phaseType rdfs:subClassOf :ProjectPhase .
                ?phase :hasPhaseDuration ?phaseDuration
            }
            """;

    public static final String RISKS_OF_A_GIVEN_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectName ?risk ?riskType
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName .
                ?project :hasRisk ?risk .
                ?risk rdf:type ?riskType .
                ?riskType rdfs:subClassOf :Risk
            }
            """;

    public static final String CURRENT_PHASE_OF_A_GIVEN_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectName ?phase ?phaseType ?phaseDuration
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName .
                ?project :isInPhase ?phase .
                ?phase rdf:type ?phaseType .
                ?phaseType rdfs:subClassOf :ProjectPhase .
                ?phase :hasPhaseDuration ?phaseDuration
            }
            """;

    public static final String DELIVERABLES_OF_A_GIVEN_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?projectName ?task ?taskDeadline ?taskDescription
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectName ?projectName .
                ?project :hasTask ?task .
                ?task rdf:type :Deliverable .
                ?task :hasTaskDeadline ?taskDeadline .
                ?task :hasTaskDescription ?taskDescription
            }
            """;

    public static final String TASKS_OF_A_GIVEN_PROJECT_MEMBER = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT DISTINCT ?member ?memberType ?task ?taskType
            WHERE {
                {
                    ?memberType rdfs:subClassOf :HumanResource .
                    ?member rdf:type ?memberType .
                }
                UNION
                {
                    ?memberType rdfs:subClassOf :TeamMember .
                    ?member rdf:type ?memberType .
                }
                ?taskType rdfs:subClassOf :Task .
                ?task rdf:type ?taskType .
                ?worksOn rdfs:subPropertyOf :worksOn .
                {
                    ?member ?worksOn ?task .
                }
                UNION
                {
                    ?task :assignedTo ?member .
                }
            }
            ORDER BY ?taskType
            """;

    public static final String PROJECT_MEMBER_USES_WHICH_MATERIAL_RESOURCES = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT DISTINCT ?memberName ?memberType ?resource
            WHERE {
                {
                    ?memberType rdfs:subClassOf :HumanResource .
                    ?member rdf:type ?memberType .
                }
                UNION
                {
                    ?memberType rdfs:subClassOf :TeamMember .
                    ?member rdf:type ?memberType .
                }
                ?member :hasMemberName ?memberName .
                ?member :usesMaterialResource ?resource
            }
            ORDER BY ?memberType
            """;

    public static final String EMAILS_SENT_IN_CONNECTION_WITH_THE_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?project ?email ?sender ?recipient
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectEmail ?email .
                ?email rdf:type :Email .
                ?email :hasEmailSender ?sender .
                {
                    ?email :hasEmailRecipient ?recipient .
                }
                UNION
                {
                    ?recipient :readsEmail ?email .
                }
            }
            """;

    public static final String REPORTS_MADE_IN_CONNECTION_WITH_THE_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?project ?report ?reporter ?reportRecipient
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectReport ?report .
                ?report rdf:type :Report .
                ?report :reportedBy ?reporter .
                {
                    ?report :reportsTo ?reportRecipient .
                }
                UNION
                {
                    ?reportRecipient :readsReport ?report .
                }
            }
            """;

    public static final String MEETINGS_HELD_IN_CONNECTION_WITH_THE_PROJECT = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            SELECT ?project ?meeting ?meetingType  ?hasMeetingMember ?meetingMember ?meetingDuration
            WHERE {
                ?project rdf:type :Project .
                ?project :hasProjectMeeting ?meeting .
                ?meetingType rdfs:subClassOf :Meeting .
                ?meeting rdf:type ?meetingType .
                ?hasMeetingMember rdfs:subPropertyOf :hasMeetingMember .
                ?meeting ?hasMeetingMember ?meetingMember .
                ?meeting :hasMeetingDuration ?meetingDuration
            }
            ORDER BY ?meeting
            """;

    public static final String CHECK_PROJECT_HAS_ANY_RISK = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            ASK {
                :Project_Nexus :hasRisk ?risk .
            }
            """;

    public static final String CHECK_PROJECT_IS_IN_MONITORING_PHASE = """
            PREFIX : <http://www.semanticweb.org/ivo/project-management#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

            ASK {
                ?phase :rdf:type :MonitoringPhase .
                :Project_Nexus :isInPhase ?phase .
            }
            """;
}
