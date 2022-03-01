package owlapi.tutorial;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OWLAPIFirst {
    public static void main(String[] args) throws OWLOntologyCreationException {
        // create an empty ontology
        IRI IOR = IRI.create("http://owl.api.tutorial");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();
        OWLClass student = df.getOWLClass(IOR+"#Student");
        // There is a class called Student.
        OWLDeclarationAxiom da = df.getOWLDeclarationAxiom(student);
        o.add(da);
        // BtechStudent is a subclass of Student.
        OWLClass btechStudent = df.getOWLClass(IOR+"#BtechStudent");
        OWLSubClassOfAxiom sca = df.getOWLSubClassOfAxiom(btechStudent, student);
        o.add(sca);
        // IddStudent is a subclass of Student.
        OWLClass iddStudent = df.getOWLClass(IOR+"#IddStudent");
        OWLSubClassOfAxiom sca2 = df.getOWLSubClassOfAxiom(iddStudent, student);
        o.add(sca2);

        // There is a class called academicSession.
        OWLClass academicSession = df.getOWLClass(IOR+"#AcademicSession");
        OWLDeclarationAxiom da2 = df.getOWLDeclarationAxiom(academicSession);
        o.add(da2);

        // There is a class called branch.
        OWLClass branch = df.getOWLClass(IOR+"#Branch");
        OWLDeclarationAxiom da3 = df.getOWLDeclarationAxiom(branch);
        o.add(da3);

        // There is a class called courses.
        OWLClass courses = df.getOWLClass(IOR+"#Courses");
        OWLDeclarationAxiom da4 = df.getOWLDeclarationAxiom(courses);
        o.add(da4);

        // There is a class called fees.
        OWLClass fees = df.getOWLClass(IOR+"#Fees");
        OWLDeclarationAxiom da5 = df.getOWLDeclarationAxiom(fees);
        o.add(da5);

        // There is a class called gradeInCourse.
        OWLClass gradeInCourse = df.getOWLClass(IOR+"#GradeInCourse");
        OWLDeclarationAxiom da6 = df.getOWLDeclarationAxiom(gradeInCourse);
        o.add(da6);

        // Student gets gradeInCourse.
        // s1 gets g1("OS", "A", "2021")

        // There is a class called result.
        OWLClass result = df.getOWLClass(IOR+"#Result");
        OWLDeclarationAxiom da7 = df.getOWLDeclarationAxiom(result);
        o.add(da7);


        // There is a data property called hasName.
        OWLDataProperty hasName = df.getOWLDataProperty(IOR+"#hasName");
        OWLDeclarationAxiom da8 = df.getOWLDeclarationAxiom(hasName);
        o.add(da8);
        // hasName has range of string and domain of student,courses,branch.
        OWLDataPropertyRangeAxiom dr = df.getOWLDataPropertyRangeAxiom(hasName, df.getStringOWLDatatype());
        o.add(dr);
        OWLDataPropertyDomainAxiom dp = df.getOWLDataPropertyDomainAxiom(hasName, student);
        o.add(dp);
        OWLDataPropertyDomainAxiom dp22 = df.getOWLDataPropertyDomainAxiom(hasName, courses);
        o.add(dp22);
        OWLDataPropertyDomainAxiom dpp3 = df.getOWLDataPropertyDomainAxiom(hasName, branch);
        o.add(dpp3);


        // There is a data property called hasRollNo.
        OWLDataProperty hasRollNo = df.getOWLDataProperty(IOR+"#hasRollNo");
        OWLDeclarationAxiom da9 = df.getOWLDeclarationAxiom(hasRollNo);
        o.add(da9);
        // hasRollNo has range of integer and domain of student.
        OWLDataPropertyRangeAxiom dr2 = df.getOWLDataPropertyRangeAxiom(hasRollNo, df.getIntegerOWLDatatype());
        o.add(dr2);
        OWLDataPropertyDomainAxiom dp2 = df.getOWLDataPropertyDomainAxiom(hasRollNo, student);
        o.add(dp2);


        // There is a data property called acadFees.
        OWLDataProperty acadFees = df.getOWLDataProperty(IOR+"#acadFees");
        OWLDeclarationAxiom da10 = df.getOWLDeclarationAxiom(acadFees);
        o.add(da10);
        // acadFees has a range of integer and has a domain of fees.
        OWLDataPropertyRangeAxiom drr = df.getOWLDataPropertyRangeAxiom(acadFees, df.getIntegerOWLDatatype());
        o.add(drr);
        OWLDataPropertyDomainAxiom dpp = df.getOWLDataPropertyDomainAxiom(acadFees, fees);
        o.add(dpp);

        // There is a data property called hasId
        OWLDataProperty hasId = df.getOWLDataProperty(IOR+"#hasId");
        OWLDeclarationAxiom da11 = df.getOWLDeclarationAxiom(hasId);
        o.add(da11);
        // hasId has a range of integer and has a domain of courses.
        OWLDataPropertyRangeAxiom drr2 = df.getOWLDataPropertyRangeAxiom(hasId, df.getIntegerOWLDatatype());
        o.add(drr2);
        OWLDataPropertyDomainAxiom dpp2 = df.getOWLDataPropertyDomainAxiom(hasId, courses);
        o.add(dpp2);


        // There is a data property called hasCpi.
        OWLDataProperty hasCpi = df.getOWLDataProperty(IOR+"#hasCpi");
        OWLDeclarationAxiom da12 = df.getOWLDeclarationAxiom(hasCpi);
        o.add(da12);
        // hasCpi has a range of float and has a domain of result.
        OWLDataPropertyRangeAxiom dr3 = df.getOWLDataPropertyRangeAxiom(hasCpi, df.getFloatOWLDatatype());
        o.add(dr3);
        OWLDataPropertyDomainAxiom dp3 = df.getOWLDataPropertyDomainAxiom(hasCpi, result);
        o.add(dp3);

        // There is a data property called hasCredits.
        OWLDataProperty hasCredits = df.getOWLDataProperty(IOR+"#hasCredits");
        OWLDeclarationAxiom da13 = df.getOWLDeclarationAxiom(hasCredits);
        o.add(da13);
        // hasCredits has a range of integer and has a domain of courses.
        OWLDataPropertyRangeAxiom dr4 = df.getOWLDataPropertyRangeAxiom(hasCredits, df.getIntegerOWLDatatype());
        o.add(dr4);
        OWLDataPropertyDomainAxiom dp4 = df.getOWLDataPropertyDomainAxiom(hasCredits, courses);
        o.add(dp4);

        // There is a data property called hasGrade.
        OWLDataProperty hasGrade = df.getOWLDataProperty(IOR+"#hasGrade");
        OWLDeclarationAxiom da14 = df.getOWLDeclarationAxiom(hasGrade);
        o.add(da14);
        // hasGrade has a range of string and has a domain of gradeInCourse.
        OWLDataPropertyRangeAxiom dr5 = df.getOWLDataPropertyRangeAxiom(hasGrade, df.getStringOWLDatatype());
        o.add(dr5);
        OWLDataPropertyDomainAxiom dp5 = df.getOWLDataPropertyDomainAxiom(hasGrade, gradeInCourse);
        o.add(dp5);

        // There is a data property called hasSem.
        OWLDataProperty hasSem = df.getOWLDataProperty(IOR+"#hasSem");
        OWLDeclarationAxiom da15 = df.getOWLDeclarationAxiom(hasSem);
        o.add(da15);
        // hasSem has a range of integer and has a domain of academicSession.
        OWLDataPropertyRangeAxiom dr6 = df.getOWLDataPropertyRangeAxiom(hasSem, df.getIntegerOWLDatatype());
        o.add(dr6);
        OWLDataPropertyDomainAxiom dp6 = df.getOWLDataPropertyDomainAxiom(hasSem, academicSession);
        o.add(dp6);

        // There is a data property called hasYear.
        OWLDataProperty hasYear = df.getOWLDataProperty(IOR+"#hasYear");
        OWLDeclarationAxiom da16 = df.getOWLDeclarationAxiom(hasYear);
        o.add(da16);
        // hasYear has a range of integer and has a domain of academicSession.
        OWLDataPropertyRangeAxiom dr7 = df.getOWLDataPropertyRangeAxiom(hasYear, df.getIntegerOWLDatatype());
        o.add(dr7);
        OWLDataPropertyDomainAxiom dp7 = df.getOWLDataPropertyDomainAxiom(hasYear, academicSession);
        o.add(dp7);

        // There is a data property called hasEmail.
        OWLDataProperty hasEmail = df.getOWLDataProperty(IOR+"#hasEmail");
        OWLDeclarationAxiom da17 = df.getOWLDeclarationAxiom(hasEmail);
        o.add(da17);
        // hasEmail has a range of string and has a domain of student.
        OWLDataPropertyRangeAxiom dr8 = df.getOWLDataPropertyRangeAxiom(hasEmail, df.getStringOWLDatatype());
        o.add(dr8);
        OWLDataPropertyDomainAxiom dp8 = df.getOWLDataPropertyDomainAxiom(hasEmail, student);
        o.add(dp8);


        // There is a data property called messFees.
        OWLDataProperty messFees = df.getOWLDataProperty(IOR+"#messFees");
        OWLDeclarationAxiom da18 = df.getOWLDeclarationAxiom(messFees);
        o.add(da18);
        // messFees has a range of integer and has a domain of Fees.
        OWLDataPropertyRangeAxiom dr9 = df.getOWLDataPropertyRangeAxiom(messFees, df.getIntegerOWLDatatype());
        o.add(dr9);
        OWLDataPropertyDomainAxiom dp9 = df.getOWLDataPropertyDomainAxiom(messFees, fees);
        o.add(dp9);


        // There is object property called belongsTo.
        OWLObjectProperty belongsTo = df.getOWLObjectProperty(IOR+"#belongsTo");
        OWLDeclarationAxiom da19 = df.getOWLDeclarationAxiom(belongsTo);
        o.add(da19);
        // belongsTo has a domain of student and a range of branch.
        OWLObjectPropertyDomainAxiom dp10 = df.getOWLObjectPropertyDomainAxiom(belongsTo, student);
        o.add(dp10);
        OWLObjectPropertyRangeAxiom dr10 = df.getOWLObjectPropertyRangeAxiom(belongsTo, branch);
        o.add(dr10);

        // There is object property called gets.
        OWLObjectProperty gets = df.getOWLObjectProperty(IOR+"#gets");
        OWLDeclarationAxiom da20 = df.getOWLDeclarationAxiom(gets);
        o.add(da20);
        // gets has a domain of student and a range of result.
        OWLObjectPropertyDomainAxiom dp11 = df.getOWLObjectPropertyDomainAxiom(gets, student);
        o.add(dp11);
        OWLObjectPropertyRangeAxiom dr11 = df.getOWLObjectPropertyRangeAxiom(gets, result);
        o.add(dr11);

        // There is object property called has.
        OWLObjectProperty has = df.getOWLObjectProperty(IOR+"#has");
        OWLDeclarationAxiom da21 = df.getOWLDeclarationAxiom(has);
        o.add(da21);
        // has has a domain of gradeInCourse and a range of courses.
        OWLObjectPropertyDomainAxiom dp12 = df.getOWLObjectPropertyDomainAxiom(has, gradeInCourse);
        o.add(dp12);
        OWLObjectPropertyRangeAxiom dr12 = df.getOWLObjectPropertyRangeAxiom(has, courses);
        o.add(dr12);



        // There is object property called in.
        OWLObjectProperty in = df.getOWLObjectProperty(IOR+"#in");
        OWLDeclarationAxiom da22 = df.getOWLDeclarationAxiom(in);
        o.add(da22);
        // in has a domain of fees,result, gradeInCourse abd a range of academicSession.
        OWLObjectPropertyDomainAxiom dpp12 = df.getOWLObjectPropertyDomainAxiom(in, fees);
        o.add(dpp12);
        OWLObjectPropertyDomainAxiom dp13 = df.getOWLObjectPropertyDomainAxiom(in, result);
        o.add(dp13);
        OWLObjectPropertyDomainAxiom dp14 = df.getOWLObjectPropertyDomainAxiom(in, gradeInCourse);
        o.add(dp14);
        OWLObjectPropertyRangeAxiom drr12 = df.getOWLObjectPropertyRangeAxiom(in, academicSession);
        o.add(drr12);

        // There is object property called of.
        OWLObjectProperty of = df.getOWLObjectProperty(IOR+"#of");
        OWLDeclarationAxiom da23 = df.getOWLDeclarationAxiom(of);
        o.add(da23);
        // of has a domain of courses and a range of branch.
        OWLObjectPropertyDomainAxiom dp15 = df.getOWLObjectPropertyDomainAxiom(of, courses);
        o.add(dp15);
        OWLObjectPropertyRangeAxiom dr13 = df.getOWLObjectPropertyRangeAxiom(of, branch);
        o.add(dr13);

        // There is object property called pays.
        OWLObjectProperty pays = df.getOWLObjectProperty(IOR+"#pays");
        OWLDeclarationAxiom da24 = df.getOWLDeclarationAxiom(pays);
        o.add(da24);
        // pays has a domain of student and a range of fees.
        OWLObjectPropertyDomainAxiom dp16 = df.getOWLObjectPropertyDomainAxiom(pays, student);
        o.add(dp16);
        OWLObjectPropertyRangeAxiom dr14 = df.getOWLObjectPropertyRangeAxiom(pays, fees);
        o.add(dr14);

        // There is object property called hasGradeInCourse.
        OWLObjectProperty hasGradeInCourse = df.getOWLObjectProperty(IOR+"#hasGradeInCourse");
        OWLDeclarationAxiom da25 = df.getOWLDeclarationAxiom(hasGradeInCourse);
        o.add(da25);
        // hasGradeInCourse has a domain of student and a range of gradeInCourse.
        OWLObjectPropertyDomainAxiom dp17 = df.getOWLObjectPropertyDomainAxiom(hasGradeInCourse, student);
        o.add(dp17);
        OWLObjectPropertyRangeAxiom dr15 = df.getOWLObjectPropertyRangeAxiom(hasGradeInCourse, gradeInCourse);
        o.add(dr15);


        // print every axiom in the ontology
        o.logicalAxioms().forEach(System.out::println);


        // save the ontology to a new file
        OWLXMLOntologyFormat format = new OWLXMLOntologyFormat();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("C:\\Users\\satya\\Desktop\\s11.owl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            o.saveOntology(format, fos);
        } catch (OWLOntologyStorageException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
