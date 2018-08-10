package utils;

public class ClassNameUtil {

    private ClassNameUtil(){}

    public static String getCurrentClassName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e){
            return e.getStackTrace()[1].getClassName();
        }
    }

    public static String getCurrentMethodName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e){
            return e.getStackTrace()[1].getMethodName();
        }
    }




}
