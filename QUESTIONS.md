# Ontology Questions

## Table of contents


## Questions

### Which are the members of a project?
In this case the members of a Project which name is "Project Nexus".

```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### Which project manager manages a given project member?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

SELECT ?project ?member ?projectManager
WHERE {
    ?project rdf:type :Project .
    ?project :hasProjectMember ?member .
    ?member :managedBy ?projectManager
}
```

### Who funds a given project?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What is the budget of a given project?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What is the start and end date for a given project?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### Which project manager manages which projects?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What phases does a project go through? What is the duration of each phase?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What risks does a given project have?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What phase is a given project currently in?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
    ?phaseType rdfs:subClassOf :ProjectPhase
}
```

### What are the deliverables of a given project?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What tasks does a given project member work on?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### Which project member uses which material resources?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```


### What emails are sent in connection with the project? By whom and for whom?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What reports are made in connection with the project? By whom and for whom?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### What meetings are held in connection with the project? Who are its member and what is its duration?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
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
```

### Check wether a project has any risk or not?
In this case is `Project_Nexus`
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

ASK {
    :Project_Nexus :hasRisk ?risk .
}
```

### Check wether a project is in Monitoring Phase or not?
In this case is `Project_Nexus`
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

ASK {
    ?phase :rdf:type :MonitoringPhase .
    :Project_Nexus :isInPhase ?phase .
}
```