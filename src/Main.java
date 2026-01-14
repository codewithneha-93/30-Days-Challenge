package src;
import java.util.Scanner;

/*------ENUM -------*/
enum StudyLevel {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED,
    EXPERT
}

/*-----DATA CLASS------ */
 class StudyPlan {
    String name;
    String subject;
    int hours;
    StudyLevel level;
}

/*-----MAIN CLASS----- */
public class Main {

/*-----MAIN------ */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        StudyPlan plan = null;
        boolean running = true;

        while (running) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();//buffer clear

            switch (choice) {
                case 1:

                
                 plan = enterStudyDetails(sc);

                 System.out.println("\n Details saved successfully!");
                 break;

                 case 2:
                    if (plan == null) {
                        System.out.println("Please enter study details first (Option 1).");
                    } else {
                        showSummary(plan);

                        suggestNextStep(plan);
                    }
                    
                    break;

                    case 3:
                        System.out.println("👋Exiting program. Keep learning💙");
                        running = false;
                        break;
            
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
    /*-------MENU------- */
        static void printSummary(String name, String subject, int hours){
            System.out.println("\n--- Study Plan Summary---");
            System.out.println("Name:"+ name);
            System.out.println("Subject:"+subject);
            System.out.println("Daily Study Hours:"+ hours);
        }

        /*-------ADVICE------ */
        static String getStudyadviceByLevel(StudyLevel level){
            switch (level) {
                case BEGINNER:
                    return "You are starting slow. Try to increase study time gradually.";

                case INTERMEDIATE:
                    return "Good pace! You can comfortably learn java with consistency.";

                case ADVANCED:
                    return "Great! You are ready for intensive java learning.";
                case EXPERT:
                    return "Excellent! You are ready for real-world Java projects and DSA";  
            
                default:
                    return "Keep going!";
            }
        }

        /*-------LEVEL LOGIC----- */
        static StudyLevel getStudyLevel(int hours){
            if (hours <= 2){
                return StudyLevel.BEGINNER;
            }else if (hours <= 4){
                return StudyLevel.INTERMEDIATE;
            } else if (hours <= 6){
                return StudyLevel.ADVANCED;
            } else {
                return StudyLevel.EXPERT;
            }
        }
            /*------MENU--------- */
        static void showMenu() {
            System.out.println("\n=====Menu======");
            System.out.println("1. Enter Study Details");
            System.out.println("2. View Study Advice");
            System.out.println("3. Exit");
            System.out.println("Choose an option:");
        }
        /*--------CASE 1 METHOD-------- */
        static StudyPlan enterStudyDetails(Scanner sc) {

            StudyPlan plan = new StudyPlan();

            System.out.print("Enter  your name:");
             plan.name = sc.nextLine();

            System.out.print("Enter subject you want to study:");
            plan.subject = sc.nextLine();

            
            while (true) {
                System.out.print("Enter daily study hours (1 to 24):");
                plan.hours = sc.nextInt();
                sc.nextLine();//buffer clear

                if (plan.hours >= 1 && plan.hours <= 24) {
                    break;
                }
                System.out.println("❌ Invalid hours. try again.");
            }
            

            plan.level = getStudyLevel(plan.hours);
            return plan;
        }

        /*------CASE 2 METHOD------ */
        static void showSummary(StudyPlan plan){
            System.out.println("\n------ Study Plan Summary-----");
            System.out.println("Name:"+ plan.name);
            System.out.println("Subject:"+ plan.subject);
            System.out.println("Daily Study Hours:"+ plan.hours);
            System.out.println("Study Level:"+ plan.level);

            String advice = getStudyadviceByLevel(plan.level);
            System.out.println("Advice:"+ advice);
        }

        static void suggestNextStep(StudyPlan plan){

            System.out.println("\n 📌 Next Step Suggestion");

            switch (plan.level) {
                case BEGINNER:
                    System.out.println("👉 Try increasing study time by 30 minutes daily");
                    break;
                case INTERMEDIATE:
                    System.out.println("👉 Start small coding problems daily");
                    break;

                case ADVANCED:
                 System.out.println("👉 Begin mini projects and DSA practice");
                 break;

                case EXPERT:
                System.out.println("👉 Build real-world projects and contribute to open source.");  
                break;

            }
            
        }
}
