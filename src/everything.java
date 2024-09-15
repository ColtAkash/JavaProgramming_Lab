import java.time.LocalDate;

public class everything  {
    public static void main(String[]args){
        Singers mysingers = new Singers();

        // Set USer Info

        System.out.println(mysingers.getS_id());
        System.out.println(mysingers.getS_name());
        System.out.println(mysingers.getS_address());
        System.out.println(mysingers.getS_dob());
        System.out.println(mysingers.getS_id());


        mysingers.setS_id(12345);
        mysingers.setS_name("Eminem");
        mysingers.setS_address("82 Scarborough Blvrd");
        mysingers.setS_dob(LocalDate.of(2000,10,07));
        mysingers.setS_album(56);

        System.out.println();

        System.out.println(mysingers.getS_id());
        System.out.println(mysingers.getS_name());
        System.out.println(mysingers.getS_address());
        System.out.println(mysingers.getS_dob());
        System.out.println(mysingers.getS_id());

    }
}
