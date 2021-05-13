package Exercises;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/*
JAVA reflection is a very powerful tool to inspect the attributes of a class in runtime. For example, we can retrieve the list of public fields of a class using getDeclaredMethods().
You have to fill in the incompleted lines so that it prints all the methods of another class called Student in alphabetical order. We will append your code with the Student class before running it. The Student class looks like this:

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    ......
    ......
    some more methods
    ......
}
You have to print all the methods of the student class in alphabetical order like this:

anothermethod
getName
setEmail
setId
......
......
some more methods
......

Hint: See the oracle docs for more details about JAVA Reflection Methods and Fields
*/

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public String getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void anothermethod(){  }
    public void bnothermethod(){  }
    public void xnothermethod(){  }
    public void fnothermethod(){  }
    public void znothermethod(){  }
    public void cnothermethod(){  }

}

public class A014_Reflection_Attributes {
    public static void main(String[] args){
        Student student = new Student();
        Method[] methods = student.getClass().getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();

        for(Method method : methods){
            methodList.add(method.getName());
        }

        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
