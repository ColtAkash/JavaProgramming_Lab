import java.sql.Date;
//Reference taken from GeeksForGeeks
import java.time.LocalDate;

public class Singers{
    public int S_id;
    public String S_name;
    public String S_address;
    public LocalDate S_dob;
    public int S_album;

    //constructors
    public Singers(){

    }
    // With 1 Arguments
    public Singers(int S_id){
        this.S_id=S_id;

    }
    // With 2 Arguments
    public Singers(int S_id, String S_name){
        this.S_id=S_id;
        this.S_name=S_name;

    }
    // With 3 Arguments
    public Singers(int S_id, String S_name,String S_address){
        this.S_id=S_id;
        this.S_name=S_name;
        this.S_address =S_address;
    }
    // With 4 Arguments
    public Singers(int S_id, String S_name,String S_address, LocalDate s_dob){
        this.S_id=S_id;
        this.S_name=S_name;
        this.S_address =S_address;
        this.S_dob = s_dob;

    }
    // With 5 Arguments
    public Singers(int S_id, String S_name,String S_address, LocalDate s_dob, int S_album){
        this.S_id=S_id;
        this.S_name=S_name;
        this.S_address =S_address;
        this.S_dob = s_dob;
        this.S_album =S_album;
    }

    //Setters
    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public void setS_address(String s_address) {
        S_address = s_address;
    }

    public void setS_dob(LocalDate s_dob) {
        S_dob = s_dob;
    }

    public void setS_album(int s_album) {
        S_album = s_album;
    }

    //Group
    public void set_All(int S_id, String S_name,String S_address, LocalDate s_dob, int S_album) {
        this.S_id = S_id;
        this.S_name = S_name;
        this.S_address = S_address;
        this.S_dob = s_dob;
        this.S_album = S_album;
    }

    public int getS_id() {
        return S_id;
    }

    public String getS_name() {
        return S_name;
    }

    public String getS_address() {
        return S_address;
    }

    public LocalDate getS_dob() {
        return S_dob;
    }

    public int getS_album() {
        return S_album;
    }
}