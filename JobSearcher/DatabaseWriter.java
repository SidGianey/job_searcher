package JobSearcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DatabaseWriter extends DatabaseConstants{
    

    public static void saveCompanies(){
        Companies companies = Companies.getInstance();
        ArrayList<Company> employers = companies.getCompanies();
        JSONArray jsonEmployers = new JSONArray();

        for(int i = 0; i<employers.size(); i++){
            jsonEmployers.add(getCompanyJSON(employers.get(i)));
        }

        try(FileWriter file = new FileWriter(COMPANIES_FILE)){
            file.write(jsonEmployers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getCompanyJSON(Company company){
            JSONObject companiesDetails = new JSONObject();
            companiesDetails.put(COMPANIES_ID, company.getCompanyID());
            companiesDetails.put(COMPANIES_NAME, company.getName());
            companiesDetails.put(COMPANIES_LOCATION, company.getLocation());
            companiesDetails.put(COMPANIES_SECTOR, company.getSector());
            companiesDetails.put(COMPANIES_INDUSTRY, company.getIndustry());

        return companiesDetails;
    }
    public static void saveJobs(){
        Jobs jobs = Jobs.getInstance();
        ArrayList<Job> jobOpportunity = jobs.getJobs();
        JSONArray jsonJobs = new JSONArray();

        for(int i = 0; i<jobOpportunity.size(); i++){
            jsonJobs.add(getJobsJSON(jobOpportunity.get(i)));
        }

        try(FileWriter file = new FileWriter(JOBS_FILE)){
            file.write(jsonJobs.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getJobsJSON(Job job){
            JSONObject jobsDetails = new JSONObject();
            jobsDetails.put(JOBS_ID, job.getJobID());
            jobsDetails.put(JOBS_NAME, job.getName());
            jobsDetails.put(JOBS_COMPANY_ID, job.getCompany());
            jobsDetails.put(JOBS_EMPLOYER_ID, job.getEmployer());
            jobsDetails.put(JOBS_START_DATE, job.getStartDate());
            jobsDetails.put(JOBS_END_DATE, job.getEndDate());
            jobsDetails.put(JOBS_SALARY, job.getSalary());
            jobsDetails.put(JOBS_DESCRIPTION, job.getDescription());
            jobsDetails.put(JOBS_LOCATION, job.getLocation());
            jobsDetails.put(JOBS_REMOTE, job.getRemote());

        return jobsDetails;
    }
    public static void saveEmployers(){
        Users users = Users.getInstance();
        ArrayList<Employer> workers = users.getEmployers();
        JSONArray jsonUsers = new JSONArray();

        for(int i = 0; i<workers.size(); i++){
            jsonUsers.add(getEmployersJSON(workers.get(i)));
        }

        try(FileWriter file = new FileWriter(EMPLOYERS_FILE)){
            file.write(jsonUsers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getEmployersJSON(Employer employer){
            JSONObject employersDetails = new JSONObject();
            employersDetails.put(EMPLOYERS_ID, employer.getEmployerID());
            employersDetails.put(EMPLOYERS_USERNAME, employer.getUsername());
            employersDetails.put(EMPLOYERS_PASSWORD, employer.getPassword());
            employersDetails.put(EMPLOYERS_FIRSTNAME, employer.getFirstName());
            employersDetails.put(EMPLOYERS_LASTNAME, employer.getLastName());
            employersDetails.put(EMPLOYERS_COMPANY_ID, employer.getCompany().getCompanyID());
            employersDetails.put(EMPLOYERS_COMPANY, employer.getCompany().getName());
            employersDetails.put(EMPLOYERS_PHONE_NUMBER, employer.getPhoneNumber());


        return employersDetails;
    }
    public static void saveStudents(){
        Users users = Users.getInstance();
        ArrayList<Student> candidates = users.getStudents();
        JSONArray jsonUsers = new JSONArray();

        for(int i = 0; i<candidates.size(); i++){
            jsonUsers.add(getStudentsJSON(candidates.get(i)));
        }

        try(FileWriter file = new FileWriter(STUDENTS_FILE)){
            file.write(jsonUsers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getStudentsJSON(Student student){
            JSONObject studentsDetails = new JSONObject();
            studentsDetails.put(STUDENTS_ID, student.getStudentId());
            studentsDetails.put(STUDENTS_USERNAME, student.getUsername());
            studentsDetails.put(STUDENTS_PASSWORD, student.getPassword());
            studentsDetails.put(STUDENTS_FIRSTNAME, student.getFirstName());
            studentsDetails.put(STUDENTS_LASTNAME, student.getLastName());
            studentsDetails.put(STUDENTS_GPA, student.getGPA());
            studentsDetails.put(STUDENTS_EDU_ACCOUNT, student.getEduAccount());
            studentsDetails.put(STUDENTS_PHONE_NUMBER, student.getPhoneNumber());
            studentsDetails.put(STUDENTS_FAVORITES, student.getFavorites());
            studentsDetails.put(STUDENTS_RATINGS, student.getRatings());
            studentsDetails.put(STUDENTS_EDUCATION, student.getEducation());
            studentsDetails.put(STUDENTS_ACHIEVEMENTS, student.getAchievements());
            studentsDetails.put(STUDENTS_SKILLS, student.getSkills());
            studentsDetails.put(STUDENTS_EXPERIENCE, student.getExperience());


        return studentsDetails;
    }
}
