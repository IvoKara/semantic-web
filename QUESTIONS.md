# Ontology Questions

## Table of contents
- [Which are the members of a project?](#wchich-are-the-members-of-a-project)
- [Which project manager manages a given project member?](#which-project-manager-manages-a-given-project-member)
- [Who funds a given project?](#who-funds-a-given-project)
- [What is the budget of a given project?](#what-is-the-budget-of-a-given-project)
- [What is the start and end date for a given project?](#what-is-the-start-and-end-date-for-a-given-project)
- [Which project manager manages which projects?](#which-project-manager-manages-which-projects)
- [What phase is a given project currently in?](#what-phase-is-a-given-project-currently-in)
- [What are the deliverables of a given project?](#what-are-the-deliverables-of-a-given-project)
- [What tasks does a given project member work on?](#what-tasks-does-a-given-project-member-work-on)
- [What are the material resources of a given project?](#what-are-the-material-resources-of-a-given-project)
- [Which project member uses which material resources?](#which-project-member-uses-which-material-resources)
- [What emails are sent in connection with the project? By whom and for whom?](#what-emails-are-sent-in-connection-with-the-project-by-whom-and-for-whom)
- [What reports are made in connection with the project? By whom and for whom?](#what-reports-are-made-in-connection-with-the-project-by-whom-and-for-whom)
- [What meetings are held in connection with the project? Who are its users and what is your function?](#what-meetings-are-held-in-connection-with-the-project-who-are-its-users-and-what-is-your-function)

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

 
```

### What is the start and end date for a given project?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### Which project manager manages which projects?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What phases does a project go through?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What is the change in each phase?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What risks does a given project have?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What phase is a given project currently in?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What are the deliverables of a given project?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What tasks does a given project member work on?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What are the material resources of a given project?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### Which project member uses which material resources?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What emails are sent in connection with the project? By whom and for whom?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What reports are made in connection with the project? By whom and for whom?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```

### What meetings are held in connection with the project? Who are its users and what is your function?
```sql
PREFIX : <http://www.semanticweb.org/ivo/project-management>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>

 
```
